package com.quathar.pro.contactbook;

import java.io.IOException;
import java.util.List;

/**
 * <h1>Contact Book</h1>
 * <br>
 * <p>
 *      Interface defining operations for managing contacts.
 * </p>
 *
 * @since 2022-03-XX
 * @version 1.0
 * @author Q
 */
public interface ContactBook {

    /**
     * Creates a new contact.
     *
     * @param contact the contact to be created
     * @return {@code true} if the contact was successfully created, otherwise {@code false}
     * @throws IOException if an I/O exception occurs while creating the contact
     */
    boolean create(Contact contact) throws IOException;

    /**
     * Retrieves a list of all contacts.
     *
     * @return a list of contacts
     * @throws IOException if an I/O exception occurs while retrieving the contacts
     */
    List<Contact> list() throws IOException;

    /**
     * Retrieves a list of contacts for debugging purposes.
     *
     * @return a list of contacts used for debugging
     * @throws IOException if an I/O exception occurs while retrieving the debug contacts
     */
    List<Contact> debug() throws IOException;

    /**
     * Retrieves a contact based on the provided username.
     *
     * @param username the username of the contact to retrieve
     * @return the contact corresponding to the given username, or {@code null} if not found
     * @throws IOException if an I/O exception occurs while retrieving the contact
     */
    Contact read(String username) throws IOException;

    /**
     * Updates an existing contact.
     *
     * @param contact the updated contact information
     * @return {@code true} if the contact was successfully updated, otherwise {@code false}
     * @throws IOException if an I/O exception occurs while updating the contact
     */
    boolean update(Contact contact) throws IOException;

    /**
     * Deletes a contact based on the provided username.
     *
     * @param username the username of the contact to delete
     * @return {@code true} if the contact was successfully deleted, otherwise {@code false}
     * @throws IOException if an I/O exception occurs while deleting the contact
     */
    boolean delete(String username) throws IOException;

}
