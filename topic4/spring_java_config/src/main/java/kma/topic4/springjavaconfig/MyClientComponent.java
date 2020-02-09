package kma.topic4.springjavaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyClientComponent {

    private MySpringComponent mySpringComponent;

    @Autowired
    public void setMySpringComponent(final MySpringComponent mySpringComponent) {
        this.mySpringComponent = mySpringComponent;
    }

    public void myClientComponentMethod() {
        mySpringComponent.myFirstMethod();
        mySpringComponent.mySecondMethod();
    }

}
