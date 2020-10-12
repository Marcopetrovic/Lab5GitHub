package com.company.lab5gitHub;
import java.util.Scanner;





public class YatziMain {
    static Dieces[] ds;
    private static int gameTurns;





    public static void main(String[] args) {

        System.out.println("Hello! Do you want to play a game of Yatzi? (type yes for start, rules to read the rules, hacks to test to auto generate Yatzi and anything else for no)");
        Scanner start = new Scanner(System.in);
        switch (start.next()) {
            case "yes" -> gameIsOn();
            case "rules" -> Rules.printRules();
            case "hacks" -> gameIsOnHax();
        }
    }


    static void startOver() {

        System.out.println("Hello! Do you want to play a game of Yatzi? (type yes for start, rules to read the rules, hacks to test to auto generate Yatzi and anything else for no)");
        Scanner start = new Scanner(System.in);
        switch (start.next()) {
            case "yes" -> gameIsOn();
            case "rules" -> Rules.printRules();
            case "hacks" -> gameIsOnHax();
        }
    }


    static void gameIsOnHax() {
        ds = new Dieces[5];
        for (int d = 0; d < 5; d++) {
            ds[d] = new Dieces();
        }
        while (gameTurns < 3) {
            System.out.println("Welcome to Yatzi!");
            System.out.println("Starting turn " + (gameTurns + 1) + " of 3, rolling dice.");
            for (int i = 0; i < ds.length; i++) {
                ds[i].value = 5; //Test if yatzi work
                System.out.println(i + ": " + ds[i].getString());
            }
            checkIfYatzi();
        }
    }


    static void gameIsOn() {
        ds = new Dieces[5];
        for (int d = 0; d < 5; d++) {
            ds[d] = new Dieces();
        }
        while (gameTurns < 3) {
            System.out.println("Welcome to Yatzi!");
            System.out.println("Starting turn " + (gameTurns + 1) + " of 3, rolling dice.");
            for (int i = 0; i < ds.length; i++) {
                ds[i].diceRoll();
                System.out.println(i + ": " + ds[i].getString());
            }
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
            System.exit(0);
        } else {
            notYatzi();
        }
    }


    public static void notYatzi() {
        if (gameTurns != 2) {
            System.out.println("Want to throw again?");
            Scanner sc = new Scanner(System.in);
            if (sc.next().equals("yes")) {
                ++gameTurns;
            } else {
                System.out.println("See you another time!");
                System.exit(0);
            }
        } else {
            gameOver();
        }
    }


    public static void gameOver(){
        System.out.println("Game over! Want to play again?");
        Scanner sc = new Scanner(System.in);
        if (sc.next().equals("yes")) {
            gameTurns = 0;
        } else if (sc.next().equals("no")){
            System.out.println("See you another time!");
            System.exit(0);
        }
    }
}

