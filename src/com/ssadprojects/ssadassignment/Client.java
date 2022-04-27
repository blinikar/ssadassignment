package com.ssadprojects.ssadassignment;

import java.util.List;
import java.util.Locale;

public class Client {

    private static final Database database = new Database();
    private static final Analyzer analyzer = new Analyzer();

    private static Stage stage = Stage.LOGIN;
    private static User loggedInUser = null;

    private static String extraMessage = null;

    private static boolean login(String username, String password) {

        User foundUser = database.getUserByUsername(username);

        if (foundUser == null) {
            foundUser = new User(username, password);
            database.addUser(foundUser);
        }

        if (foundUser.getPassword().equals(password)) {
            loggedInUser = foundUser;
            return true;
        }

        return false;
    }

    private static void processLoginStage() {

        int choice = OutputFormatter.printMenu("LOGIN using Gosuslugi", "EXIT");

        switch (choice) {
            case 1:
                String username = OutputFormatter.printInputText("Enter username: ");
                String password = OutputFormatter.printInputText("Enter password: ");

                boolean loginSuccess = login(username, password);

                if (loginSuccess)
                    stage = Stage.FEED;
                else
                    OutputFormatter.printPlainText("Login error. Try again");

                break;
            case 2:
                stage = Stage.EXIT;
                break;
        }
    }

    private static void processFeedStage() {

        List<Post> posts = database.getPosts();

        OutputFormatter.printFeed(analyzer.getFeed(posts));

        int choice = OutputFormatter.printMenu("CREATE NEW", "SHOW POST BY ID", "USER/ADMIN PANEL", "SIGN OUT");

        switch (choice) {
            case 1:
                String newPostText = OutputFormatter.printInputText("Enter post text: ");
                int newPostId = posts.size();
                Post newPost = new Post(newPostId, newPostText, loggedInUser.getUsername());
                newPost.setRating(analyzer.analyze(newPost, database.getWords()));
                database.addPost(newPost);
                break;
            case 2:
                extraMessage = OutputFormatter.printInputText("Enter post ID: ");
                stage = Stage.POST;
                break;
            case 3:
                stage = Stage.ADMIN_PANEL;
                break;
            case 4:
                stage = Stage.LOGIN;
                loggedInUser = null;
                break;
        }
    }

    private static void processPostStage() {

        Post post = database.getPostByID(Integer.parseInt(extraMessage));

        OutputFormatter.printPostWithComments(post);

        int choice = OutputFormatter.printMenu("ADD COMMENT", "GO BACK");

        switch (choice) {
            case 1:
                String newCommentText = OutputFormatter.printInputText("Enter comment text: ");
                post.addComment(newCommentText);
                post.setRating(analyzer.analyze(post, database.getWords()));
                database.dataBaseStateSave();
                break;
            case 2:
                stage = Stage.FEED;
                break;
        }
    }

    private static void processAdminPanelStage() {
        OutputFormatter.printPlainText("You're logged in");
        OutputFormatter.printUserInfo(loggedInUser);

        int choice;
        if (loggedInUser.isAdmin()) {
            OutputFormatter.printWords(database.getWords());
            choice = OutputFormatter.printMenu("CHANGE STATUS", "CHANGE PHOTO", "GO BACK", "ADD WORD");
        } else {
            choice = OutputFormatter.printMenu("CHANGE STATUS", "CHANGE PHOTO", "GO BACK");
        }

        switch (choice) {
            case 1:
                String newStatus = OutputFormatter.printInputText("Enter new Status: ");
                loggedInUser.setStatus(newStatus);
                break;
            case 2:
                String newPhoto = OutputFormatter.printInputText("Enter new Photo: ");
                loggedInUser.setPhotoURL(newPhoto);
                break;
            case 3:
                stage = Stage.FEED;
                break;
            case 4:
                String newWordText = OutputFormatter.printInputText("Enter new Word: ");
                OutputFormatter.printPlainText("Word moods: GOOD, BAD");
                String newWordStatus = OutputFormatter.printInputText("Enter word mood: ");

                database.addWord(new Word(newWordText, Mood.parseMood(newWordStatus.toUpperCase(Locale.ROOT))));
                break;
        }
        database.dataBaseStateSave();
    }

    public static void main(String[] args) {

        OutputFormatter.printPlainText("Welcome to Lichnoe Delo - Social network for important opinions " +
                                        "this is Russian Social Network\n" +
                                        "Our office address: Moscow, Lubyanskaya sq., 2");

        while (true) {

            switch (stage) {
                case EXIT:
                    OutputFormatter.printPlainText("Goodbye");
                    System.exit(0);
                    break;
                case LOGIN:
                    processLoginStage();
                    break;
                case FEED:
                    processFeedStage();
                    break;
                case POST:
                    processPostStage();
                    break;
                case ADMIN_PANEL:
                    processAdminPanelStage();
                    break;
            }
        }
    }
}
