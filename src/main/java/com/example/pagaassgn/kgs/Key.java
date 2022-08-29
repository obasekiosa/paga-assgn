package com.example.pagaassgn.kgs;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "keys")
public class Key {

    @Id
    private String id;
    private Date createdOn;
    private boolean active;

    public Key() {}

    public Key(String key, boolean active) {
        this.id = key;
        this.active = active;
    }

    public String getKey() {
        return id;
    }

    public void setKey(String key) {
        this.id = key;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Key{" +
                "id='" + id + '\'' +
                ", createdOn=" + createdOn +
                ", active=" + active +
                '}';
    }
}
