package be.ordina.demo.ehb.soccer;

import java.util.Random;

public enum Direction {

    LEFT,
    MIDDLE,
    RIGHT;

    public static Direction random(){
        final int pick = new Random().nextInt(Direction.values().length);
        return Direction.values()[pick];
    }
}
