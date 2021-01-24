package pojo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EnglishMen implements GreetingPerformer {

    private final String iAm;

    @Override
    public void sayHello(final String name) {
        System.out.println("Hello, " + name + ". My name is " + iAm);
    }
}
