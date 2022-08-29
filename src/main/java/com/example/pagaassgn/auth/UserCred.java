package com.example.pagaassgn.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class UserCred {

    @Id @GeneratedValue
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
