package com.ssadprojects.ssadassignment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Post implements Serializable {

    private final Integer id;
    private Double rating = 0.0;
    private final List<String> comments = new ArrayList<>();
    private final String text;
    private final String authorUsername;

    public Post(Integer id, String text, String authorUsername) {
        this.id = id;
        this.text = text;
        this.authorUsername = authorUsername;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public Integer getId() {
        return id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addComment(String text) {
        comments.add(text);
    }

    public String getText() {
        return text;
    }
}
