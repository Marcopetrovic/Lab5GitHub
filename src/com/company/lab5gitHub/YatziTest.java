package com.company.lab5gitHub;

import com.company.lab5gitHub.Dieces;
import org.junit.jupiter.api.Test;

public class YatziTest {
    @Test
    void isYatziWhenAllDiceMatches() {
        Dieces[] dice = new Dieces[5];
        for(Dieces die: dice) {
            die.value = 6;
        }
        //Assert something?
    }

    @Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        Dieces[] dice = new Dieces[5];
        for(Dieces die: dice) {
            die.value = 6;
        }
        dice[5].value = 1;
        //Assert something?
    }
}
