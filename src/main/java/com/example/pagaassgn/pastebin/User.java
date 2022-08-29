package com.example.pagaassgn.pastebin;

import java.util.Date;

public class User {
    private long id;
    private String username;

    private Date createdOn;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }
}
