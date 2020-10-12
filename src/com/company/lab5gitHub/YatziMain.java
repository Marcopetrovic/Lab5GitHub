package com.company.lab5gitHub;





import java.util.Scanner;





public class YatziMain {
    static Dieces[] ds;
    private static int gameTurns = 1;
    static Scanner sc = new Scanner(System.in);




    public static void main(String[] args) {

        System.out.println("Hello! Do you want to play a game of Yatzi? (type yes for start, rules to read the rules, hacks to test to auto generate Yatzi and anything else for no)");
        switch (sc.next()) {
            case "yes" -> gameIsOn();
            case "rules" -> Rules.printRules();
            case "hacks" -> gameIsOnHax();
            default -> exitGame();
        }
    }


    static void createDice(){

        ds = new Dieces[5];
        for (int d = 0; d < 5; d++) {
            ds[d] = new Dieces();
        }
    }

    static void rollDices() {
        for (int i = 0; i < ds.length; i++) {
            ds[i].diceRoll();
            System.out.println((i + 1) + ": " + ds[i].getString());
        }
    }


    static void rollDicesOnHax() {
        for (int i = 0; i < ds.length; i++) {
            ds[i].value = 5; //Test if yatzi work
            System.out.println(i + ": " + ds[i].getString());
        }
    }


    static void startOver() {

        System.out.println("Would you like to play a new game of Yatzi? (type yes for start, rules to read the rules, hacks to test to auto generate Yatzi and anything else for no)");
        switch (sc.next()) {
            case "yes" -> gameIsOn();
            case "rules" -> Rules.printRules();
            case "hacks" -> gameIsOnHax();
            default -> exitGame();
        }
    }


    static void gameIsOnHax() {
        createDice();
        while (gameTurns <= 3) {
            System.out.println("Welcome to Yatzi! Now with hacks 2.0");
            System.out.println("Starting turn " + (gameTurns) + " of 3, rolling dice.");
            rollDicesOnHax();
            checkIfYatzi();
        }
    }


    static void gameIsOn() {
        createDice();
        while (gameTurns <= 3) {
            if(gameTurns == 1) {
                System.out.println("Welcome to Yatzi!");
            }
            System.out.println("Starting turn " + (gameTurns) + " of 3, rolling dice.");
            rollDices();
            checkIfYatzi();
        }
    }


    public static void checkIfYatzi() {
        boolean yatzi = true;
        for (int j = 1; j < 5; j++) {
            //Set yatzi to false
            if (ds[j].value != ds[j - 1].value) {
                yatzi = false;
                break;
            }
        }


        if (yatzi) {
            System.out.println("You got YATZI! in " + ds[0].value + "'s");
            gameTurns = 1;
            startOver();
        } else {
            notYatzi();
        }
    }


    public static void notYatzi() {
        if (gameTurns != 3) {
            System.out.println("Want to throw again?");
            if (sc.next().equals("yes")) {
                ++gameTurns;
            } else {
                exitGame();
            }
        } else {
            gameOver();
        }
    }


    public static void gameOver(){
        System.out.println("Game over! Want to play again? Type yes to play again and type menu to come to the menu.");
        switch (sc.next()) {
            case "yes" -> gameIsOn();
            case "menu" -> startOver();
            default -> exitGame();
        }

    }


    public static void exitGame(){
        System.out.println("See you another time!");
        System.exit(0);
    }

}