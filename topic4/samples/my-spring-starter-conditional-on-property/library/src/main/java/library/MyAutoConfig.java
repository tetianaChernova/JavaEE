package library;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAutoConfig {

    @Bean
    @ConditionalOnProperty(value = "my.property", havingValue = "custom")
    ComponentOnPropertyValue custom() {
        return new ComponentOnPropertyValueCustom();
    }

    @Bean
    @ConditionalOnProperty(value = "my.property", havingValue = "default", matchIfMissing = true)
    ComponentOnPropertyValue defaultComponent() {
        return new ComponentOnPropertyValueDefault();
    }

}
