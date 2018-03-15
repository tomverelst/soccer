package be.ordina.demo.ehb.soccer;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.function.Consumer;

public class Goal {

    private final MessageChannel target;
    private final SubscribableChannel goal;

    public Goal(final InputChannels inputChannels,
                final OutputChannels outputChannels) {
        this.goal = inputChannels.input();
        this.target = outputChannels.output();
    }

    /**
     * Shoots the ball at the target.
     *
     * The football is sent as a message to the target output channel.
     */
    public void shoot(final Football football){
        target.send(MessageBuilder
                .withPayload(football)
                .build());
    }

    /**
     * Defends the goal.
     *
     * Subscribes a {@link Consumer} to the goal input channel.
     */
    public void defend(final Consumer<Football> consumer){
        goal.subscribe((msg) -> consumer.accept((Football) msg.getPayload()));
    }

}
