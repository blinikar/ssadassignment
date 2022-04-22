package com.ssadprojects.ssadassignment;

import java.util.ArrayList;

public class Post {

    private Double rating = 0.0;
    private ArrayList<String> comments = new ArrayList<>();
    private String text;

    public Post(String text) {
        this.text = text;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getComments() {
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
