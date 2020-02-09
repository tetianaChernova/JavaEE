package client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import library.ComponentOnPropertyValue;
import library.ComponentOnPropertyValueCustom;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);

        ComponentOnPropertyValue componentOnPropertyValue = applicationContext.getBean(ComponentOnPropertyValue.class);
        componentOnPropertyValue.printInfo();
    }

}
