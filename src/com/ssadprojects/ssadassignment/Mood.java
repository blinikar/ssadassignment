package com.ssadprojects.ssadassignment;

public enum Mood {
    GOOD("GOOD"), BAD("BAD");

    final String text;
    Mood(String text) {
        this.text = text;
    }

    static Mood parseMood(String mood) {

        switch (mood) {
            case "GOOD":
                return GOOD;
            case "BAD":
                return BAD;
        }

        return null;
    }
}
