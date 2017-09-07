package org.skexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by skand on 9/7/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class GreetingServiceTest {

    // This is our system under test;
    // InjectMocks will instantiate like Autowired inject any transitive dependencies as mocks.
    @InjectMocks
    private GreetingService greetingService;

    @Test
    public void canHelloWorld() throws Exception {
        Greeting greeting = greetingService.getHello("foo");
        assertEquals(greeting.getText(), "Hello, foo!");
    }

    @Test
    public void canGreet() throws Exception {
        Greeting greeting = greetingService.getGreeting("foo");
        assertTrue(greeting.getText().startsWith("Good"));
    }
}
