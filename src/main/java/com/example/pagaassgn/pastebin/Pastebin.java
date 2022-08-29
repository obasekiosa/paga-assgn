package com.example.pagaassgn.pastebin;

import java.util.Date;

public class Pastebin {

    private String id;
    private long createdBy;
    private Date expiry;
    private Date createdOn;

    private String content;

    public Pastebin() {}

    public Pastebin(String id, long createdBy, Date expiry, String content) {
        this.id = id;
        this.createdBy = createdBy;
        this.expiry = expiry;
        this.content = content;
    }
}
