package kma.topic4.springjavaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyClassFromExternalLibraryClient {

    private ClassFromExternalLibrary defaultComponent;
    private ClassFromExternalLibrary otherBean;

    @Autowired
    public void setDefaultComponent(final ClassFromExternalLibrary defaultComponent) {
        this.defaultComponent = defaultComponent;
    }

    @Autowired
    @Qualifier("myCustomNameForBean")
    public void setOtherBean(final ClassFromExternalLibrary otherBean) {
        this.otherBean = otherBean;
    }

    public void printInfo() {
        System.out.println("Primary component info:");
        defaultComponent.printInfo();

        System.out.println("Secondary component info:");
        otherBean.printInfo();
    }
}
