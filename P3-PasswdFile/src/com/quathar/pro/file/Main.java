package com.quathar.pro.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * <h1>Main</h1>
 *
 * @since 2022-02-XX
 * @version 1.0
 * @author Q
 */
public class Main {

    // <<-CONSTANT->>
    private static final String PATH = Path.of(System.getProperty("user.dir"), "etc", "passwd").toString();

    // <<-METHODS->>
    private static void readWithList() {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            List<User> users = new ArrayList<>();

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] h = linea.split(":");
                users.add(new User(
                        h[0],
                        h[1],
                        h[2],
                        h[3],
                        h[4],
                        h[5],
                        h[6]
                ));
            }

            // As it is a ArrayList, we have to sort it with the 'sort()' method
            Collections.sort(users);

            // Show users
            for (User user : users) {
                System.out.println(user);
            }

            users.clear();
        } catch (IOException e) {
            throw new RuntimeException("I/O Exception while reading passwd file", e);
        }
    }

    private static void readWithSet() {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            Set<User> users = new TreeSet<>();

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] h = linea.split(":");
                users.add(new User(
                        h[0],
                        h[1],
                        h[2],
                        h[3],
                        h[4],
                        h[5],
                        h[6]
                ));
            }

            // As it is a TreeSet,
            // we don't have to sort it
            // because we already implement the comparable interface
            // in User class

            // Show users
            for (User user : users) {
                System.out.println(user);
            }

            users.clear();
        } catch (IOException e) {
            throw new RuntimeException("I/O Exception while reading passwd file", e);
        }

    }

    public static void main(String[] args) {
        Main.readWithList();
        Main.readWithSet();
    }

}
