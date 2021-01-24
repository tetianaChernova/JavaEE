package wiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Concierge;
import pojo.GreetingPerformer;

public class WiringOldSpringExample {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/wiring.xml");

        final GreetingPerformer englishMen = applicationContext.getBean("englishGreeting", GreetingPerformer.class);
        englishMen.sayHello("Ben");

        final GreetingPerformer spanishGreeting = applicationContext.getBean("spanishGreeting", GreetingPerformer.class);
        spanishGreeting.sayHello("Ben");

        final Concierge concierge = applicationContext.getBean(Concierge.class);
        concierge.sayHelloToNewVisitor("Ben");
    }

}
