package com.quathar.pro.contactbook;

import java.util.Objects;

/**
 * <h1>Contact Model</h1>
 *
 * @since 2022-03-XX
 * @version 1.0
 * @author Q
 */
public class Contact implements Comparable<Contact> {

    // <<-FIELDS->>
    private final String username;
    private final String name;
    private final String telephone;

    // <<-CONSTRUCTOR->>
    public Contact(String username, String name, String telephone) {
        this.username  = username;
        this.name      = name;
        this.telephone = telephone;
    }

    // <<-METHODS->>
    @Override
    public int compareTo(Contact o) {
        return this.username.compareTo(o.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        return Objects.equals(this.username, other.username);
    }

    @Override
    public String toString() {
        return String.format("Contact [name=%s, telephone=%s]", this.name, this.telephone);
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public String getTelephone() {
        return this.telephone;
    }

}
