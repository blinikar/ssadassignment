package com.ssadprojects.ssadassignment;

import java.util.ArrayList;
import java.util.List;

public class Post {

    private final Integer id;
    private Double rating = 0.0;
    private final List<String> comments = new ArrayList<>();
    private String text;

    public Post(Integer id, String text) {
        this.id = id;
        this.text = text;
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

    public String getCommentByOrderNumber(int index){
        return comments.get(index);
    }

    public int getAmountOfComments(){
        return comments.size();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
