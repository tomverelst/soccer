package be.ordina.demo.ehb.soccer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * The goalkeeper defends the goal.
 *
 * It reads all messages (footballs) from the goal input channel.
 */
public class Goalkeeper {

    private static final Logger LOGGER = LoggerFactory.getLogger(Goalkeeper.class);

    private final Results results = new Results();

    public Goalkeeper(final Goal goal){
        goal.defend((football) -> {
            if(catches(football)){
                LOGGER.info("Goalkeeper catches the ball!");

                results.addCatch();

            } else {
                LOGGER.info("Goalkeeper could not catch the ball! Goal!");

                results.addGoal();
            }

        });
    }

    public boolean catches(final Football football){
        final Direction jumpDirection = jump();

        LOGGER.info("Goalkeeper jumps to the {}", jumpDirection.name().toLowerCase());

        if(jumpDirection.equals(football.getDirection())){
            final int speed = new Random().nextInt(100) + 1;
            return speed >= football.getVelocity();
        } else {
            return false;
        }
    }

    private Direction jump(){
        return Direction.random();
    }

    public Results getResults() {
        return results;
    }
}
