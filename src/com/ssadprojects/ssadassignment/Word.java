package com.ssadprojects.ssadassignment;

import java.io.Serializable;

public class Word implements Serializable {

    private final String text;
    private final Mood mood;

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
