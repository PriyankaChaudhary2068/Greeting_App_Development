package com.bridgelabz.greetingappdevelopment.controller;

import com.bridgelabz.greetingappdevelopment.model.GreetingData;
import com.bridgelabz.greetingappdevelopment.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*
    UC1 : Using Greeting Controller Return JSON For Different HTTP Methods
    *localhost:8080/greeting
     */
    @GetMapping("/greeting")
    public GreetingData greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingData(counter.incrementAndGet(),
                String.format(template, name));
    }

    //localhost:8080/param/Priyanka
    @GetMapping("/param/{name}")
    public GreetingData greeting1(@PathVariable String name) {
        return new GreetingData(counter.incrementAndGet(),
                String.format(template, name));

    }

     /*
    UC2 : Extend GreetingController To Use Service Layer To Get
    Simple Greeting Message "Hello World"
    *localhost:8080/getMessage
     */

    @GetMapping("/getMessage")
    public String getMessage() {
        return GreetingService.getMessage();
    }
}



