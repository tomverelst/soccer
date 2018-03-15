package be.ordina.demo.ehb.soccer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputChannels {

    @Output
    MessageChannel output();
}
