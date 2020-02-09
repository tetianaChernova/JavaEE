package kma.topic4.springjavaconfig;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "kma.topic4.springjavaconfig")
@ComponentScan(basePackageClasses = MySpringComponent.class)
public class MyBaseConfiguration {

}
