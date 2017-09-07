package org.skexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @RequestMapping(
            value = "/hello",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting hello(@RequestParam(value="name", defaultValue="World") String name) {
        return greetingService.getHello(name);
    }

    @RequestMapping(
            value = "/greeting",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return greetingService.getGreeting(name);
    }
}
