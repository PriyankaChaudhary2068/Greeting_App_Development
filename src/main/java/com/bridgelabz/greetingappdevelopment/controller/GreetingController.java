package com.bridgelabz.greetingappdevelopment.controller;

import com.bridgelabz.greetingappdevelopment.model.GreetingData;
import com.bridgelabz.greetingappdevelopment.model.UserData;
import com.bridgelabz.greetingappdevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private GreetingService greetingService;

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


    //localhost:8080/greeting
    @PostMapping("/greeting")
    public GreetingData getGreeting(@RequestBody UserData data) {
        GreetingData greeting = new GreetingData(5, "Hi " + data.getFirstName() + ".This is POST");
        return greeting;
    }

    //localhost:8080/greeting/hello
    @PostMapping("/greeting/hello")
    public GreetingData getGreetingHi(@RequestBody UserData data) {
        return new GreetingData(counter.incrementAndGet(), String.format(template, data.getLastName()));
    }

    //localhost:8080/greeting/put?name=Priyanka
    @PutMapping("/greeting/put")
    public GreetingData putGreeting(@RequestParam(value = "name") String name) {
        return new GreetingData(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greet")
    public GreetingData greeting(@RequestParam(value = "FirstName", defaultValue = "") String fname,
                                 @RequestParam(value = "LastName", defaultValue = "") String lname) {

        UserData userData = new UserData();
        userData.setFirstName(fname);
        userData.setLastName(lname);

        GreetingService greetingService = new GreetingService();
        return greetingService.getGreeting(userData);
    }

    /**
     * UC4 : Ability For The Greeting App To Save The Greeting Message
     In The Repository
     * */

    @PostMapping("/greetService")
    public GreetingData greeting(@RequestBody UserData userData)
    {
        return  greetingService.addGreeting(userData);
    }

    /**
     * UC5 : Ability For The Greeting App To Find A Greeting Message By Id
      In The Repository
     * */
    @GetMapping("/greetService/{id}")
    public GreetingData greeting(@PathVariable long id) {
        return  greetingService.getGreetingById(id);
    }


    /**
     * UC6 : Ability For The Greeting App To List All The Greeting
      Messages In The Repository
     * */
    @GetMapping("/greetService")
    public List<GreetingData> greetingFindAll() {
        return  greetingService.getAllGreetings();
    }


}



