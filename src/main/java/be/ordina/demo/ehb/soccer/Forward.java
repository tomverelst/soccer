package be.ordina.demo.ehb.soccer;

import java.util.Objects;
import java.util.Random;

/**
 * The forward player kicks the football towards the goal.
 *
 * It sends the messages (footballs) to the goal output channel.
 */
public class Forward {

    private final Goal target;

    public Forward(Goal target){
        this.target = Objects.requireNonNull(target);
    }

    public void kick(){
        final Football football = new Football();
        football.setDirection(Direction.random());
        football.setVelocity(new Random().nextInt(100)+1);

        target.shoot(football);
    }

}
