package com.company.lab5gitHub;

 class Dices  {
    int value;



    void diceRoll() {
        this.value = (int)(Math.random()*6+1);
    }

    void setDieValue(int v) {
        this.value = v;
    }







}



