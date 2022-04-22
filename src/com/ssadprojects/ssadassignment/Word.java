package com.ssadprojects.ssadassignment;

public class Word {

    private String text;
    private Mood mood;

    public Word(String text, Mood mood) {
        this.text = text;
        this.mood = mood;
    }

    public String getText(){
        return this.text;
    }

    public Mood getMood(){
        return this.mood;
    }
}
