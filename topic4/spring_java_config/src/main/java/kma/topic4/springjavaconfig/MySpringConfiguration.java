package kma.topic4.springjavaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MySpringConfiguration {

    @Primary
    @Bean
    ClassFromExternalLibrary myExternalBean() {
        return new ClassFromExternalLibrary("primary-bean", 1);
    }

    @Bean("myCustomNameForBean")
    ClassFromExternalLibrary myExternalBeanSecond() {
        return new ClassFromExternalLibrary("secondary-bean", 1);
    }

}

class ClassFromExternalLibrary {

    private String field1;

    public ClassFromExternalLibrary(String field1, int field2) {
        this.field1 = field1;
    }

    public void printInfo() {
        System.out.println("ClassFromExternalLibrary.printInfo: field1 value = " + field1);
    }
}
