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

        Double postRating = 0.0;
        String postAuthor = "@" + "blinikar";

        StringBuilder output = new StringBuilder();
        output.append(postText);

        output.append("\n\nPost by ").append(postAuthor);
        output.append("\nPost rating ").append(postRating);
        output.append("\nComments: ");

        output.append("\n| --------------\n");

        if (comments.isEmpty()) {
            output.append("| No comments");
            output.append("\n| --------------\n");
        }

        for (String comment : comments) {
            output.append("| ");
            output.append(comment);
            output.append("\n| --------------\n");
        }

        System.out.println(output.toString());
    }

    public static void main(String[] args) {
        showPostWithComments(new Post());
    }
}
