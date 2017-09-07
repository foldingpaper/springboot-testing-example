package org.skexample;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by skand on 9/7/17.
 */
@Component
public class GreetingService {

    private static final String hello_template = "Hello, %s!";
    private static final String good_template = "%s, %s!";

    private final AtomicLong counter = new AtomicLong();

    public Greeting getHello(String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(hello_template, name));
    }

    public Greeting getGreeting(String name) {
        Calendar calendar = new GregorianCalendar();
        String greeting = ( calendar.get(Calendar.AM_PM) == 0 ) ?
            "Good Morning" : "Good Evening";
        return new Greeting(counter.incrementAndGet(),
                String.format(good_template, greeting, name));
    }
}
