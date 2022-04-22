package com.ssadprojects.ssadassignment;

public class User {

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
