package com.quathar.pro.contactbook;

/**
 * <h1>Contact Book</h1>
 * <br>
 * <p>
 *     Represents an interface for managing a contact book.
 * </p>
 *
 * @since 2022-03-XX
 * @version 1.0
 * @author Q
 */
public interface ContactBook {

    /**
     * Lists all contacts available in the contact book.
     */
    void listAllContacts();

    /**
     * Adds a new contact to the contact book.
     *
     * @param contact The contact to be added.
     * @return {@code true} if the contact is successfully added, {@code false} otherwise.
     */
    boolean addContact(Contact contact);

    /**
     * Checks if a contact exists in the contact book.
     *
     * @param contact The contact to check for existence.
     * @return {@code true} if the contact exists, {@code false} otherwise.
     */
    boolean exists(Contact contact);

    /**
     * Searches for a contact by username in the contact book.
     *
     * @param username The username of the contact to search for.
     * @return The contact object if found, {@code null} otherwise.
     */
    Contact searchContact(String username);

    /**
     * Updates an existing contact in the contact book.
     *
     * @param contact The contact to be updated.
     * @return {@code true} if the contact is successfully updated, {@code false} otherwise.
     */
    boolean updateContact(Contact contact);

    /**
     * Deletes a contact from the contact book.
     *
     * @param contact The contact to be deleted.
     * @return {@code true} if the contact is successfully deleted, {@code false} otherwise.
     */
    boolean deleteContact(Contact contact);

    /**
     * Checks if the contact book is full.
     *
     * @return {@code true} if the contact book is full, {@code false} otherwise.
     */
    boolean isFull();

    /**
     * Gets the number of free spaces available in the contact book.
     *
     * @return The number of available free spaces.
     */
    int freeSpaces();

}
