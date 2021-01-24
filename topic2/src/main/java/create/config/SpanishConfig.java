package create.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pojo.GreetingPerformer;
import pojo.SpanishMen;

@Configuration
public class SpanishConfig {

    @Bean(name = "spanishMen")
    GreetingPerformer spanishMen() {
        return new SpanishMen();
    }

}
