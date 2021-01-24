package scope.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeScope {

    public PrototypeScope() {
        System.out.println("Create new prototype bean");
    }

    public void doAction() {
        System.out.println("Do action");
    }

}
