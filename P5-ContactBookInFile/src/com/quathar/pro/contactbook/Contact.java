package com.quathar.pro.contactbook;

/**
 * <h1>Contact Model</h1>
 *
 * @since 2022-03-XX
 * @version 1.0
 * @author Q
 */
public class Contact implements Comparable<Contact> {

    // <<-FIELD->>
    private String username;
    private String name;
    private String telephone;

    // <<-CONSTRUCTOR->>
    public Contact(String username, String name, String telephone) {
        this.setUsername (username);
        this.setName     (name);
        this.setTelephone(telephone);
    }

    // <<-METHODS->>
    @Override
    public int compareTo(Contact o) {
        return this.username.compareTo(o.username);
    }

    @Override
    public String toString() {
        return String.format("%-10s = [ %-100s | %-17s ]",
                this.username,
                this.name,
                this.telephone);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username != null ? username.trim() : null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name != null ? name.trim() : null;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone != null ? telephone.trim() : null;
    }

}
