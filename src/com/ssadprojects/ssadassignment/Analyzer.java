package com.ssadprojects.ssadassignment;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Analyzer {
    Double Analyze(Post post, List<Word> list){
        double result = 0.0;

        String[] words = post.getText().split(" ");

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < list.size(); j++){
                if (list.get(i).getText().equals(words[i])){
                    if (list.get(i).getMood() == Mood.GOOD){
                        result += 1;
                    }
                    else if (list.get(i).getMood() == Mood.BAD){
                        result -= 1;
                    }
                }
            }
        }

        result /= words.length;

        return result;
    }

    List<Post> getFeed(List<Post> posts){
        List<Post> sorted = posts.stream()
                .sorted(Comparator.comparingDouble(Post::getRating))
                .collect(Collectors.toList());
        return sorted;
    }
}
