package com.quathar.pro.contactbook.withArray;

import com.quathar.pro.contactbook.Contact;
import com.quathar.pro.contactbook.ContactBook;

/**
 * <h1>Array Contact Book Implementation</h1>
 *
 * @since 2022-03-XX
 * @version 1.0
 * @author Q
 */
public class ArrayContactBook implements ContactBook {

    // <<-CONSTANT->>
    private static final int DEFAULT_SIZE = 10;

    // <<-FIELDS->>
    private final Contact[] contacts;
    private int availableSpaces;

    // <<-CONSTRUCTORS->>
    public ArrayContactBook(int maxSpace) {
        this.contacts        = new Contact[maxSpace];
        this.availableSpaces = maxSpace;
    }

    public ArrayContactBook() {
        this(DEFAULT_SIZE);
    }

    // <<-METHODS->>
    @Override
    public void listAllContacts() {
        for (int i = 0; i < this.contacts.length; i++) {
            Contact contact = this.contacts[i];
            System.out.printf("%02d: %-5s [ %-5s | %-3s ]%n",
                    i + 1,
                    contact.getUsername(),
                    contact.getName(),
                    contact.getTelephone());
        }
    }

    @Override
    public boolean addContact(Contact contact) {
        for (int i = 0; i < this.contacts.length; i++)
            if (this.contacts[i] == null) {
                this.contacts[i] = contact;
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
        for (int i = 0; i < this.contacts.length; i++)
            if (this.contacts[i].getUsername().equals(contact.getUsername())) {
                this.contacts[i] = contact;
                return true;
            }
        return false;
    }

    @Override
    public boolean deleteContact(Contact contact) {
        for (int i = 0; i < this.contacts.length; i++)
            if (this.contacts[i].getUsername().equals(contact.getUsername())) {
                this.contacts[i] = null;
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
