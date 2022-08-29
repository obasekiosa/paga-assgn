package com.example.pagaassgn.pastebin;

import java.util.Date;

public class UserCred {
    private long id;
    private long userId;
    private Date createdOn;
    private Date updatedOn;
    private String password;
    private String salt;

    public UserCred() {
    }

    public UserCred(long userId, String password) {
        this.userId = userId;
        this.salt = generateSalt();
        this.password = hashPassword(password, this.salt);
    }

    public static String generateSalt() {
        throw new UnsupportedOperationException("This method has not been implemented");
    }

    public static String hashPassword(String password, String salt) {
        throw new UnsupportedOperationException("This method has not been implemented");
    }
}
