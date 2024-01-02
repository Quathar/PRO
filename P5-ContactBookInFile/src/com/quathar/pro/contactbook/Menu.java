package com.quathar.pro.contactbook;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

/**
 * <h1>Menu</h1>
 * <br>
 * <p>
 *     Represents a menu-driven interface for managing contacts.
 * </p>
 *
 * @since 2022-03-XX
 * @version 1.0
 * @author Q
 */
public class Menu implements Closeable {

    // <<-FIELD->>
    private final FileContactBook contactBook;
    private final Scanner scanner;

    // <<-CONSTRUCTOR->>
    public Menu(FileContactBook contactBook) throws IOException {
        this.contactBook = contactBook;
        this.scanner     = new Scanner(System.in);
        while (menu());
    }

    // <<-METHODS->>
    private boolean register() throws IOException {
        System.out.println("Username:");
        String username = this.scanner.nextLine();

        System.out.println("Name:");
        String name = this.scanner.nextLine();

        System.out.println("Telephone:");
        String telephone = this.scanner.nextLine();

        Contact contact = new Contact(username, name, telephone);
        return this.contactBook.create(contact);
    }

    private void list() throws IOException {
        for (Contact contact : this.contactBook.list()) {
            System.out.println(contact);
        }
    }

    private Contact consult() throws IOException {
        System.out.println("Contact to consult (Write the username):");
        String username = this.scanner.nextLine();
        return this.contactBook.read(username);
    }

    private boolean modify() throws IOException {
        System.out.println("Contact to modify (Write the username):");
        String username = this.scanner.nextLine();

        Contact contact = this.contactBook.read(username);
        if (contact == null) {
            return false;
        }

        String template = "New < %s > ? Old < %s > is: %s%n";

        System.out.printf(template, "name", "name", contact.getName());
        String name = this.scanner.nextLine();
        contact.setName(name.isBlank() ? contact.getName() : name);

        System.out.printf(template, "telephone", "telephone", contact.getTelephone());
        String telephone = this.scanner.nextLine();
        contact.setTelephone(telephone.isBlank() ? contact.getTelephone() : telephone);

        return this.contactBook.update(contact);
    }

    private boolean unsubscribe() throws IOException {
        System.out.println("Username:");
        String username = this.scanner.nextLine();
        return this.contactBook.delete(username);
    }

    private void debug() throws IOException {
        System.err.println("[[ DEBUG >>");
        for (Contact contact : this.contactBook.debug()) {
            System.err.println(contact);
        }
        System.err.println(">> ]]");
    }

    @Override
    public void close() throws IOException {
        this.contactBook.close();
        this.scanner    .close();
    }

    public boolean menu() throws IOException {
        System.out.printf("%n[ Register | Unsubscribe | Modify | Consult | List | Debug | Help | Exit ]%n");
        switch (this.scanner.nextLine()) {
            case "--register", "-r":
                if (this.register())
                     System.out.println("Contact added.");
                else System.out.println("The contact could not be registered.");
                break;
            case "--list", "-l":
                this.list();
                break;
            case "--consult", "-s":
                Contact contact = this.consult();
                if (contact != null)
                     System.out.println(contact);
                else System.err.println("This contact DOES NOT EXIST.");
                break;
            case "--modify", "-m":
                if (this.modify())
                     System.out.println("Modified contact.");
                else System.err.println("The contact COULD NOT be modified.");
                break;
            case "--unsubscribe", "-u":
                if (this.unsubscribe())
                     System.out.println("Contact deleted.");
                else System.err.println("The contact COULD NOT unsubscribe.");
                break;
            case "--clear", "-c":
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                break;
            case "--debug", "-d":
                this.debug();
                break;
            case "--help", "-?":
                System.out.println("   Register: [ --register    | -r ]");
                System.out.println("    Consult: [ --consult     | -s ]");
                System.out.println("     Modify: [ --modify      | -m ]");
                System.out.println("Unsubscribe: [ --unsubscribe | -u ]");
                System.out.println("       List: [ --list        | -l ]");
                System.out.println("      Clear: [ --clear       | -c ]");
                System.out.println("      Debug: [ --debug       | -a ]");
                System.out.println("       Help: [ --help        | -? ]");
                System.out.println("       Exit: [ --exit        | -x ]");
                break;
            case "--exit", "-x":
                this.close();
                return false;
            default:
                System.err.println("Select a correct option.");
        }
        return true;
    }

}
