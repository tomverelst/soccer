package be.ordina.demo.ehb.soccer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.BlockingQueue;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertThat;
import static org.springframework.cloud.stream.test.matcher.MessageQueueMatcher.receivesPayloadThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForwardIntegrationTests {

	@Autowired
	private Forward forward;

	@Autowired
	private OutputChannels outputChannels;

	@Autowired
	private MessageCollector collector;

	@Test
	public void kick() throws Exception {
		forward.kick();

		final BlockingQueue<Message<?>> messages = collector.forChannel(outputChannels.output());

		assertThat(messages, receivesPayloadThat(any(Football.class)));
	}

}
