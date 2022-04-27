package com.ssadprojects.ssadassignment;

import java.io.Serializable;

/**
 * Class User implements system's user object
 * If contains getters and setters.
 * After creation of User, username can not be changed, because of unique of each User.
 * Each user has username, password and URL of avatar photo and status.
 * User can be Admin, who can modify database of sentiment based keywords.
 */
public class User implements Serializable {

    private final String username;
    private final String password;

    private String photoURL = "";
    private String status = "";

    private boolean isAdmin = false;

    public User(String username, String password) {

        if (username.equals("admin")) isAdmin = true;

        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
