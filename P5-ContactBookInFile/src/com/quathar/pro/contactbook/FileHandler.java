package com.quathar.pro.contactbook;

import java.io.IOException;

/**
 * <h1>File Handler</h1>
 * <br>
 * <p>
 *     Interface defining read and write operations for handling contacts in a file.
 * </p>
 *
 * @since 2022-03-XX
 * @version 1.0
 * @author Q
 */
public interface FileHandler {

    /**
     * Reads a contact from the file.
     *
     * @return the contact read from the file
     * @throws IOException if an I/O exception occurs while reading the contact
     */
    Contact read() throws IOException;

    /**
     * Writes a contact to the file.
     *
     * @param contact the contact to write to the file
     * @throws IOException if an I/O exception occurs while writing the contact
     */
    void write(Contact contact) throws IOException;

}
