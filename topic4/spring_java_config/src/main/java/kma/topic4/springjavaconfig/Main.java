package kma.topic4.springjavaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("kma.topic4.springjavaconfig");
        applicationContext.refresh();

        System.out.println("Print info from simple autowired bean");
        MyClientComponent myClientComponent = applicationContext.getBean(MyClientComponent.class);
        myClientComponent.myClientComponentMethod();
        System.out.println("======================");

        MyClassFromExternalLibraryClient myClassFromExternalLibraryClient = applicationContext.getBean(MyClassFromExternalLibraryClient.class);
        System.out.println("Print info when available more then one candidate for autowiring");
        myClassFromExternalLibraryClient.printInfo();
    }

}
