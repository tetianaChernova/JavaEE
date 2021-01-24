package scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import scope.beans.PrototypeScope;
import scope.beans.SingletonScope;

public class ScopeExample {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("scope.beans");

        SingletonScope singletonScope1 = applicationContext.getBean(SingletonScope.class);
        SingletonScope singletonScope2 = applicationContext.getBean(SingletonScope.class);

        singletonScope1.doAction();
        singletonScope2.doAction();
        System.out.println("Singleton same object: " + (singletonScope1 == singletonScope2));

        System.out.println("============");
        PrototypeScope prototypeScope1 = applicationContext.getBean(PrototypeScope.class);
        PrototypeScope prototypeScope2 = applicationContext.getBean(PrototypeScope.class);

        prototypeScope1.doAction();
        prototypeScope2.doAction();
        System.out.println("Prototype same object: " + (prototypeScope1 == prototypeScope2));
    }

}
