package wiring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pojo.GreetingPerformer;

@Component
public class ConciergeSetter {

    private GreetingPerformer greetingPerformer;

    @Autowired
    public void setGreetingPerformer(final GreetingPerformer greetingPerformer) {
        this.greetingPerformer = greetingPerformer;
    }

    public void sayHelloToNewVisitor(final String visitorName) {
        System.out.println("=== concierge open the door to new visitor(with setter) ===");
        greetingPerformer.sayHello(visitorName);
    }

}
