package library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAutoConfig {

    @Bean
    MyLibraryClass libraryClass() {
        return new MyLibraryClass();
    }

}
