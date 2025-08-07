package br.com.tsantos.controller;

import br.com.tsantos.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello, %s!";

    // http://localhost:8080/greeting?name=Tiago
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World")
            String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
