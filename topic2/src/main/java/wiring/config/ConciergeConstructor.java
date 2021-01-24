package wiring.config;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pojo.GreetingPerformer;

@Component
@RequiredArgsConstructor
public class ConciergeConstructor {

    private final GreetingPerformer greetingPerformer;

    public void sayHelloToNewVisitor(final String visitorName) {
        System.out.println("=== concierge open the door to new visitor(with constructor) ===");
        greetingPerformer.sayHello(visitorName);
    }

}
