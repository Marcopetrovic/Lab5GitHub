package com.company.lab5gitHub;

public class Dieces  {
    int value;

/*
    public static Dieces[] ds;

    public static void newDieces() {
        ds = new Dieces[5];
        for (int d = 0; d < 5; d++) {
            ds[d] = new Dieces();
        }
    }


 */


    public void diceRoll() {
        value = (int)(Math.random()*6+1);
    }



    public String getString() {
        return "Dice shows " + value;
    }




}

