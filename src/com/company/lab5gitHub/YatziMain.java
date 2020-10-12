package com.company.lab5gitHub;





import java.util.Scanner;





public class YatziMain {
    private static int gameTurns = 1;
    static Scanner sc = new Scanner(System.in);
    static Dices[] ds = new Dices[5];




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

        for (int d = 0; d < 5; d++) {
            ds[d] = new Dices();
        }

    }

    static void rollDices() {
        int dieNumber = 1;
        for (Dices die: ds) {
            die.diceRoll();
            System.out.println(dieNumber + ": " + "Dice shows " + die.value);
            dieNumber++;
        }

    }


    static void rollDicesOnHax() {
        int dieNumber = 1;
        for (Dices die: ds) {
            die.value = 6;
            System.out.println(dieNumber + ": " + "Dice shows " + die.value);
            dieNumber++;
        }
    }


    static void startOver() {
        gameTurns = 1;
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
            newRound();
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
            newRound();
        }
    }


    public static boolean checkIfYatzi(Dices[] dices) {
        for (int i = 1; i < dices.length; i++) {
            if (dices[i].value != dices[i - 1].value) {
                return false;
            }
        }
        return true;
    }





    public static void newRound() {
        if(!checkIfYatzi(ds)){
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
        } else {
            System.out.println("You got YATZI! in " + ds[0].value + "'s");
            gameTurns = 1;
            startOver();
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