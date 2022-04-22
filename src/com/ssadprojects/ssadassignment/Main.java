package com.ssadprojects.ssadassignment;

import java.util.ArrayList;
import java.util.List;

// КТО ЗАКОМИТИТ ЭТОТ КЛАСС В МЭЙН БЕЗ РАЗРЕШЕНИЯ ТОТ ЛОХ
public class Main {

    Database database = new Database();

    public static void showPostWithComments(Post post) {

        String postText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                    " tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim " +
                    " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea " +
                    "commodo consequat.";

        List<String> comments = new ArrayList<>();
        comments.add("Comment 1");
        comments.add("Comment 2");
        comments.add("Comment 3");
        comments.add("Comment 4");
        comments.add("Comment 5");

        StringBuilder output = new StringBuilder("--------------\n");
        output.append(postText);

        for (String comment : comments) {
            output.append(comment);
        }
    }

    public static void main(String[] args) {
    // write your code here
    }
}
