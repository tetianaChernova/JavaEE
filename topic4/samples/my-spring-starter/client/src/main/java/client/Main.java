package client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import library.MyLibraryClass;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);

        MyLibraryClass libraryClass = applicationContext.getBean(MyLibraryClass.class);
        libraryClass.printInfo();
    }

}
