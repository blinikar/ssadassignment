package com.ssadprojects.ssadassignment;

import java.util.ArrayList;

public class User {

    final private String username;

    private String password;

    private String photoURL = "";

    private ArrayList<Post> posts = new ArrayList<>();

    private String status = "";

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addPost(Post post){
        this.posts.add(post);
    }

    public boolean validatePassword(String password){
        return this.password.equals(password);
    }
}
