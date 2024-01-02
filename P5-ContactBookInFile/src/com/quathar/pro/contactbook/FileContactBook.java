package com.quathar.pro.contactbook;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <h1>File Contact Book</h1>
 *
 * @since 2022-03-XX
 * @version 1.0
 * @author Q
 */
public class FileContactBook implements ContactBook, FileHandler, Closeable {

    // <<-CONSTANT->>
    private static final String PATH          = Path.of(System.getProperty("user.dir"), "agenda.dat").toString();
    private static final String MRK_DLT       = "#";
    private static final int UTF_LENGTH       = 2;
    private static final int USERNAME_LENGTH  = 10;
    private static final int NAME_LENGTH      = 100;
    private static final int TELEPHONE_LENGTH = 17;
    private static final int CONTACT_LENGTH   = UTF_LENGTH + USERNAME_LENGTH
                                              + UTF_LENGTH + NAME_LENGTH
                                              + UTF_LENGTH + TELEPHONE_LENGTH;

    // <<-FIELDS->>
    private final RandomAccessFile raf;
    private final Map<String, Long> idx;

    // <<-CONSTRUCTOR->>
    public FileContactBook() throws IOException {
        this.raf = new RandomAccessFile(PATH, "rw");
        this.idx = new TreeMap<>();
        this.fillIndex();
    }

    private void fillIndex() throws IOException {
        // We put in the index the information that is in the file
        this.raf.seek(0L);
        while (this.raf.getFilePointer() < this.raf.length()) {
            long position = this.raf.getFilePointer();
            Contact contact = this.read();
            if (contact != null) {
                this.idx.put(contact.getUsername().trim(), position);
            }
        }
    }

    // <<-METHODS->>
    @Override
    public boolean create(Contact contact) throws IOException {
        if (this.idx.containsKey(contact.getUsername())) {
            return false;
        }
        long position = this.raf.length();
        this.idx.put(contact.getUsername(), position);
        this.raf.seek(position);
        this.write(contact);
        return true;
    }

    @Override
    public List<Contact> list() throws IOException {
        List<Contact> contacts = new ArrayList<>();
        for (String username : this.idx.keySet()) {
            contacts.add(this.read(username));
        }
        return contacts;
    }

    public List<Contact> debug() throws IOException {
        List<Contact> contacts = new ArrayList<>();
        this.raf.seek(0L);
        while (this.raf.getFilePointer() < this.raf.length()) {
            Contact contact = this.read();
            contacts.add(contact == null ? new Contact(MRK_DLT, null, null) : contact);
        }
        return contacts;
    }

    @Override
    public Contact read(String username) throws IOException {
        Long position = this.idx.get(username);
        if (position == null) {
            return null;
        }
        this.raf.seek(position);
        return this.read();
    }

    @Override
    public boolean update(Contact contact) throws IOException {
        Long position = this.idx.get(contact.getUsername());
        if (position == null) {
            return false;
        }
        this.raf.seek(position);
        this.write(contact);
        return true;
    }

    @Override
    public boolean delete(String username) throws IOException {
        Long position = this.idx.get(username);
        System.out.println("position is " + position);
        if (position == null) {
            return false;
        }
        this.idx.remove(username);
        this.raf.seek(position);
        this.raf.writeUTF(this.format(MRK_DLT, USERNAME_LENGTH));
        return true;
    }

    @Override
    public Contact read() throws IOException {
        Contact contact = new Contact(
                this.raf.readUTF(),
                this.raf.readUTF(),
                this.raf.readUTF()
        );
        return contact.getUsername().trim().equals(MRK_DLT) ? null : contact;
    }

    @Override
    public void write(Contact contact) throws IOException {
        this.raf.writeUTF( this.format(contact.getUsername(),  USERNAME_LENGTH)  );
        this.raf.writeUTF( this.format(contact.getName(),      NAME_LENGTH)      );
        this.raf.writeUTF( this.format(contact.getTelephone(), TELEPHONE_LENGTH) );
    }

    private String format(String txt, int length) {
        StringBuilder sb = new StringBuilder(txt.trim());
        int spacesToAdd = Math.max(0, length - sb.length());
        return sb.append(" ".repeat(spacesToAdd)).substring(0, length);
    }

    @Override
    public void close() throws IOException {
        this.raf.close();
        this.idx.clear();
    }

    public long getLength() throws IOException {
        return this.raf.length() / CONTACT_LENGTH;
    }

}
