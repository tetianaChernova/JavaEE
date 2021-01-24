package create;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.GreetingPerformer;

public class CreateOldSpringExample {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/create.xml");

        final GreetingPerformer englishMen = applicationContext.getBean("englishGreeting", GreetingPerformer.class);
        englishMen.sayHello("Ben");

        final GreetingPerformer spanishGreeting = applicationContext.getBean("spanishGreeting", GreetingPerformer.class);
        spanishGreeting.sayHello("Ben");
    }

}
