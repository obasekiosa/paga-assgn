package com.example.pagaassgn.pastebin;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pastebin {

    @Id
    private String id;
    private long createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expiry;

    @CreationTimestamp
    private Date createdOn;

    @Column(columnDefinition="TEXT")
    private String content;

    public Pastebin() {}

    public Pastebin(String id, long createdBy, String content) {
        this.id = id;
        this.createdBy = createdBy;
        this.expiry = null;
        this.content = content;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Pastebin{" +
                "id='" + id + '\'' +
                ", createdBy=" + createdBy +
                ", expiry=" + expiry +
                ", createdOn=" + createdOn +
                ", content='" + content + '\'' +
                '}';
    }
}
