package com.ssadprojects.ssadassignment;

// КТО ЗАКОМИТИТ ЭТОТ КЛАСС В МЭЙН БЕЗ РАЗРЕШЕНИЯ ТОТ ЛОХ
public class Main {

    private static final Database database = new Database();
    private static final Analyzer analyzer = new Analyzer();

    private static Stage stage = Stage.LOGIN;

    public static void processLogin() {

        int choice = OutputFormatter.printMenu("LOGIN using Gosuslugi", "EXIT");


//        switch (choice) {
//            case 1:
//        }
    }

    public static void main(String[] args) {

        OutputFormatter.printPlainText("Welcome to Lichnoe Delo - Social network for important opinions" +
                                        "\n this is Russian Social Network \n" +
                                        "Our office address: Moscow, Lubyanskaya sq., 2");

        for (;;) {
            switch (stage) {
                case LOGIN:
                    processLogin();
                    break;
                default:
                    break;
            }
        }
    }
}
