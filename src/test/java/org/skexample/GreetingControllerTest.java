package org.skexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.skexample.GreetingBuilder.greetingBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class GreetingControllerTest {

    @Mock
    private GreetingService mockGreetingService;

    private MockMvc mockMvc;

    @InjectMocks
    private GreetingController greetingController;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(greetingController).build();
    }

    @Test
    public void canGetHelloWorld() throws Exception {

        String testHello = "Hello, World";
        Greeting testGreeting = greetingBuilder().withText(testHello).build();

        when(mockGreetingService.getHello(any(String.class)))
                .thenReturn(testGreeting);

        this.mockMvc.perform(
                get("/hello")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.text").value(testHello));
    }
}