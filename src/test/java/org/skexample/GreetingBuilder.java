package org.skexample;

/**
 * Created by skand on 9/7/17.
 */
public class GreetingBuilder {

    private Greeting greeting;

    public static GreetingBuilder greetingBuilder() {
        return new GreetingBuilder();
    }

    private GreetingBuilder() {
        greeting = new Greeting(0, "foo");
    }

    public GreetingBuilder withText(String text) {
        greeting.setText(text);
        return this;
    }

    public Greeting build() {
        return greeting;
    }
}
