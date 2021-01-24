package wiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pojo.Concierge;
import pojo.GreetingPerformer;
import wiring.config.ConciergeConstructor;
import wiring.config.ConciergeSetter;

public class WiringNewSpringExample {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("wiring.config");

        applicationContext.getBean(GreetingPerformer.class)
            .sayHello("Ben");

        applicationContext.getBean(Concierge.class)
            .sayHelloToNewVisitor("Mike");

        applicationContext.getBean(ConciergeSetter.class)
            .sayHelloToNewVisitor("Kate");

        applicationContext.getBean(ConciergeConstructor.class)
            .sayHelloToNewVisitor("Molly");
    }

}
