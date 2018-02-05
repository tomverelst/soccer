package be.ordina.demo.ehb.soccer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputChannels {

    @Input
    SubscribableChannel input();

}
