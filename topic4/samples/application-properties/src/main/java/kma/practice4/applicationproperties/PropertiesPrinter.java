package kma.practice4.applicationproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesPrinter {

    @Value("${my.first.property}")
    private String firstProperty;
    @Value("${my.second.property}")
    private String secondProperty;

    public void printInfo() {
        System.out.println("First property: " + firstProperty);
        System.out.println("Second property: " + secondProperty);
    }

}
