package com.quathar.pro.contactbook.withCollection;

import com.quathar.pro.contactbook.Contact;
import com.quathar.pro.contactbook.ContactBook;

public class MainWithCollection {

    public static void main(String[] args) {
        ContactBook contactBook = new CollectionContactBook(5);
        Contact initContact = new Contact("mario", "Mario", "123");
        contactBook.addContact(initContact);

        for (int i = 1; i < 6; i++) {
            // Generate random contacts
            String username = String.format("C%02d", i);
            String name = String.format("C%02d", i);
            String telephone = Integer.toString((int) (Math.random() * 1000));

            // Try to add the contact if the address book is free.
            contactBook.addContact(new Contact(username, name, telephone));
        }

        // We see if it correctly detects the contact we introduced before.
        contactBook.exists(initContact);

        // We show the agenda
        contactBook.listAllContacts();
        System.out.println();

        // We delete the contact and add a new one to see if everything works correctly.
        contactBook.deleteContact(initContact);
        Contact pepe = new Contact("pepe", "Pepe", "563");
        contactBook.addContact(pepe);
        contactBook.listAllContacts();

        // We see if the agenda is full and how many free spaces it has, we look for a contact.
        System.out.println();
        System.out.println("Is the agenda full? " + contactBook.isFull());
        System.out.printf("The agenda has %d free spaces%n", contactBook.freeSpaces());
        System.out.println("The telephone number of the contact you are looking for is " + contactBook.searchContact("pepe").getTelephone());
        System.out.println();
        contactBook.listAllContacts();
    }

}
