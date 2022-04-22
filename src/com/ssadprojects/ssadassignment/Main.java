package com.ssadprojects.ssadassignment;

import java.util.ArrayList;

// КТО ЗАКОМИТИТ ЭТОТ КЛАСС В МЭЙН БЕЗ РАЗРЕШЕНИЯ ТОТ ЛОХ
public class Main {

    private static final Database database = new Database();
    private static final Analyzer analyzer = new Analyzer();

    private static Stage stage = Stage.LOGIN;
    private static User loggedInUser = null;

    private static String extraMessage = null;

    private static boolean login(String username, String password, User user) {

        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            loggedInUser = user;
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

                boolean loginSuccess = login(username, password, new User("admin", "admin"));

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

        OutputFormatter.printFeed(new ArrayList<>());

        int choice = OutputFormatter.printMenu("CREATE NEW", "SHOW POST BY ID", "USER/ADMIN PANEL", "SIGN OUT");

        switch (choice) {
            case 1:
                // TODO
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

        OutputFormatter.printPostWithComments(new Post());

        int choice = OutputFormatter.printMenu("ADD COMMENT", "GO BACK");

        switch (choice) {
            case 1:
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
                // TODO
                break;
        }
    }

    public static void main(String[] args) {

        OutputFormatter.printPlainText("Welcome to Lichnoe Delo - Social network for important opinions" +
                                        "this is Russian Social Network\n" +
                                        "Our office address: Moscow, Lubyanskaya sq., 2");

        while (true) {
            switch (stage) {
                case EXIT:
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
