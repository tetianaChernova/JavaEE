package create.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pojo.EnglishMen;
import pojo.GreetingPerformer;

@Configuration
public class EnglishConfig {

    @Bean(name = "englishPerformer")
    GreetingPerformer englishPerformer() {
        return new EnglishMen("John");
    }

}
