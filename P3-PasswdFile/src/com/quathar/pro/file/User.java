package com.quathar.pro.file;

/**
 * <h1>User Model</h1>
 *
 * @since 2022-02-XX
 * @version 1.0
 * @author Q
 */
public class User implements Comparable<User> {

    // <<-FIELDS->>
    private final String user;
    private final String password;
    private final String userID;
    private final String groupID;
    private final String description;
    private final String homeDir;
    private final String shell;

    // <<-CONSTRUCTOR->>
    public User(
            String user,
            String password,
            String userID,
            String groupID,
            String description,
            String homeDir,
            String shell
    ) {
        this.user        = user;
        this.password    = password;
        this.userID      = userID;
        this.groupID     = groupID;
        this.description = description;
        this.homeDir     = homeDir;
        this.shell       = shell;
    }

    // <<-METHODS->>
    @Override
    public int compareTo(User o) {
        return this.user.compareTo(o.user);
    }

    @Override
    public String toString() {
        return String.format("%-19s = [ %s | %-5s | %-5s | %-34s | %-26s | %-17s ]",
                this.user,
                this.password,
                this.userID,
                this.groupID,
                this.description,
                this.homeDir,
                this.shell);
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public String getDescription() {
        return this.description;
    }

    public String getHomeDir() {
        return this.homeDir;
    }

    public String getShell() {
        return this.shell;
    }

}
