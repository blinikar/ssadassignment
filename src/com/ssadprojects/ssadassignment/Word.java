package com.ssadprojects.ssadassignment;

public class Word {

    private String text;

    private Mood mood;

    public String getText(){
        return this.text;
    }

    public Mood getMood(){
        return this.mood;
    }

    public void setText(String newText){
        this.text = newText;
    }

    public void setMood(Mood newMood){
        this.mood = newMood;
    }
}
