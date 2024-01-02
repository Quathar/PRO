package com.quathar.pro.contactbook;

import java.io.IOException;

/**
 * <h1>Main</h1>
 *
 * @since 2022-03-XX
 * @version 1.0
 * @author Q
 */
public class Main {

    public static void main(String[] args) throws IOException {
        new Menu(new FileContactBook());
    }

}
