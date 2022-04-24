package com.ssadprojects.ssadassignment;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Analyzer {

    Double analyze(Post post, List<Word> wordsList){

        double result = 0.0;
        int length = 0;

        String[] words = post.getText().split(" ");
        length += words.length;

        for (String s : words) {

            for (Word word : wordsList) {

                if (word.getText().toUpperCase(Locale.ROOT).equals(s.toUpperCase(Locale.ROOT))) {

                    if (word.getMood() == Mood.GOOD) {
                        result += 1;
                    } else if (word.getMood() == Mood.BAD) {
                        result -= 1;
                    }
                }
            }
        }

        List<String> comments = post.getComments();

        for (String i : comments) {

            String[] commentWords = i.split(" ");
            length += commentWords.length;

            for (String s : commentWords) {

                for (Word word : wordsList) {

                    if (word.getText().toUpperCase(Locale.ROOT).equals(s.toLowerCase(Locale.ROOT))) {

                        if (word.getMood() == Mood.GOOD) {
                            result += 1;
                        } else if (word.getMood() == Mood.BAD) {
                            result -= 1;
                        }
                    }
                }
            }
        }

        return result / length;
    }

    List<Post> getFeed(List<Post> posts) {
        List<Post> sortedList = posts.stream()
                .sorted(Comparator.comparingDouble(Post::getRating))
                .collect(Collectors.toList());
        Collections.reverse(sortedList);

        return sortedList;
    }
}
