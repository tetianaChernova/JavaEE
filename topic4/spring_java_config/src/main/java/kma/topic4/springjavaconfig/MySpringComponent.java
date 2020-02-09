package kma.topic4.springjavaconfig;

import org.springframework.stereotype.Component;

@Component
public class MySpringComponent {

    public void myFirstMethod() {
        System.out.println("MySpringComponent.myFirstMethod");
    }

    public void mySecondMethod() {
        System.out.println("MySpringComponent.mySecondMethod");
    }

}
