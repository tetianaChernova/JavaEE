package create;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pojo.GreetingPerformer;

public class CreateNewSpringExample {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("create.config");

        GreetingPerformer greetingPerformer = applicationContext.getBean("englishPerformer", GreetingPerformer.class);
        greetingPerformer.sayHello("Ben");

        applicationContext.getBean("spanishMen", GreetingPerformer.class)
            .sayHello("Ben");
    }

}
