package be.ordina.demo.ehb.soccer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public class OutputChannels {

    @Output
    public MessageChannel output;
}
