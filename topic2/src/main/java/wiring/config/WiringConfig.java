package wiring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pojo.Concierge;
import pojo.EnglishMen;
import pojo.GreetingPerformer;

@Configuration
public class WiringConfig {

    @Bean
    GreetingPerformer greetingPerformer() {
        return new EnglishMen("John");
    }

    @Bean
    Concierge concierge(GreetingPerformer greetingPerformer) {
        return new Concierge(greetingPerformer);
    }

}
