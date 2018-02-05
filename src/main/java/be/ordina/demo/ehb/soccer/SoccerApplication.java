package be.ordina.demo.ehb.soccer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.channels.Channels;

@SpringBootApplication
@EnableBinding({InputChannels.class, OutputChannels.class})
public class SoccerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerApplication.class, args);
	}

	@Configuration
	public static class SoccerConfiguration {

		@Autowired
		private InputChannels inputChannels;

		@Autowired
		private OutputChannels outputChannels;

		@Bean
		public Goal goal(){
			return new Goal(inputChannels, outputChannels);
		}

		@Bean
		public Forward forward(){
			return new Forward(goal());
		}

		@Bean
		public Goalkeeper goalkeeper(){
			return new Goalkeeper(goal());
		}
	}
}
