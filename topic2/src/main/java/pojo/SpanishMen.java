package pojo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SpanishMen implements GreetingPerformer {

    @Override
    public void sayHello(final String name) {
        System.out.println("Buenos días, " + name);
    }
}
