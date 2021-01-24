package scope.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonScope {

    public SingletonScope() {
        System.out.println("Singleton scope");
    }

    public void doAction() {
        System.out.println("Do action in singleton");
    }

}
