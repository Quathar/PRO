package com.quathar.pro.contactbook.withCollection;

import com.quathar.pro.contactbook.Contact;
import com.quathar.pro.contactbook.ContactBook;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Collection Contact Book Implementation</h1>
 *
 * @since 2022-03-XX
 * @version 1.0
 * @author Q
 */
public class CollectionContactBook implements ContactBook {

    // <<-CONSTANT->>
    private static final int MAX_SIZE = 100;

    // <<-FIELDS->>
    private final List<Contact> contacts;
    private int availableSpaces;

    // <<-CONSTRUCTOR->>
    public CollectionContactBook(int maxSpace) {
        this.contacts        = new ArrayList<>(maxSpace);
        this.availableSpaces = maxSpace;
    }

    public CollectionContactBook() {
        this(MAX_SIZE);
    }

    // <<-METHODS->>
    @Override
    public void listAllContacts() {
        for (int i = 0; i < this.contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            System.out.printf("%02d: %-5s [ %-5s | %s ]%n",
                    i + 1,
                    contact.getUsername(),
                    contact.getName(),
                    contact.getTelephone());
        }
    }

    @Override
    public boolean addContact(Contact contact) {
        Contact contactToAdd = this.searchContact(contact.getUsername());
        if (contactToAdd == null) {
            this.contacts.add(contact);
            this.availableSpaces--;
            return true;
        }
        return false;
    }

    @Override
    public boolean exists(Contact contactToCheck) {
        for (Contact contact : this.contacts)
            if (contact.equals(contactToCheck))
                return true;
        return false;
    }

    @Override
    public Contact searchContact(String username) {
        for (Contact contact : this.contacts)
            if (contact.getUsername().equals(username))
                return contact;
        return null;
    }

    @Override
    public boolean updateContact(Contact contact) {
        Contact contactToUpdate = this.searchContact(contact.getUsername());
        if (contactToUpdate != null) {
            this.contacts.remove(contactToUpdate);
            this.contacts.add(contact);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteContact(Contact contact) {
        Contact contactToDelete = this.searchContact(contact.getUsername());
        if (contactToDelete != null) {
            this.contacts.remove(contact);
            this.availableSpaces++;
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        return this.availableSpaces == 0;
    }

    @Override
    public int freeSpaces() {
        return this.availableSpaces;
    }

}
