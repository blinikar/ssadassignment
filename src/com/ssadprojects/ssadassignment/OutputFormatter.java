package com.ssadprojects.ssadassignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class OutputFormatter {

    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void printPostWithComments(Post post) {

        StringBuilder output = new StringBuilder();
        output.append(post.getText());

        output.append("\n\nPost by @").append(post.getAuthorUsername());
        output.append("\nPost rating ").append(post.getRating());
        output.append("\nComments: ");

        output.append("\n| --------------\n");

        if (post.getComments().isEmpty()) {
            output.append("| No comments");
            output.append("\n| --------------\n");
        }

        for (String comment : post.getComments()) {
            output.append("| ");
            output.append(comment);
            output.append("\n| --------------\n");
        }

        System.out.println(output);
    }

    public static void printFeed(List <Post> posts) {

        StringBuilder output = new StringBuilder();
        output.append("Your feed:\n--------------\n");

        for (Post post : posts) {
            output.append(post.getId());
            output.append("\n");
            output.append(post.getText());
            output.append("\n--------------\n");
        }

        System.out.println(output);
    }

    public static void printUserInfo(User user) {

        String output = "\nUSER INFO: \n\n";

        output += user.getUsername();
        output += "\nPhoto: ";
        output += user.getPhotoURL();
        output += "\nStatus: ";
        output += user.getStatus();
        output += "\nRole: ";
        output += user.isAdmin() ? "Admin\n" : "User\n";

        System.out.println(output);
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

        int choice;
        do {
            choice = Integer.parseInt(printInputText("Enter number: "));
        } while (!(choice > 0 && choice <= items.length));

        return choice;
    }

    public static void printPlainText(String text) {

        System.out.println("\n" + text + "\n");
    }

    public static String printInputText(String text) {

        System.out.println("\n" + text);

        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
