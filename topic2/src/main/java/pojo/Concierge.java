package pojo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Concierge {

    private final GreetingPerformer greetingPerformer;

    public void sayHelloToNewVisitor(final String visitorName) {
        System.out.println("=== concierge open the door to new visitor ===");
        greetingPerformer.sayHello(visitorName);
    }

}
