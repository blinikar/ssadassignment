package com.ssadprojects.ssadassignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OutputFormatter {

    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void printPostWithComments(Post post) {

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

        System.out.println(output);
    }

    public static void printFeed(List <Post> posts) {

        StringBuilder output = new StringBuilder();
        output.append("Your feed:\n--------------");

        for (Post post : posts) {
            output.append("post ID\n");
            output.append("post text\n");
            output.append("--------------\n");
        }

        System.out.println(output);
    }

    public static void printUserInfo() {

    }

    public static int printMenu(String... items) {

        StringBuilder output = new StringBuilder();
        output.append("\nMENU:\n");

        for (int i = 0; i < items.length; i++) {
            output.append(i+1);
            output.append("-");
            output.append(items[i]);
            output.append("\n");
        }

        output.append("\n");

        System.out.println(output);

        return Integer.parseInt(printInputText("Enter number: "));
    }

    public static void printPlainText(String text) {

        System.out.println("\n" + text + "\n");
    }

    public static String printInputText(String text) {

        System.out.println("\n" + text + ": ");

        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
