package com.bridgelabz.greetingappdevelopment.service;

import com.bridgelabz.greetingappdevelopment.model.GreetingData;
import com.bridgelabz.greetingappdevelopment.model.UserData;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {

    public static String getMessage() {
        return "Hello World";
    }

    private final AtomicLong counter = new AtomicLong();

    public GreetingData getGreeting(UserData userData) {
        long id = counter.incrementAndGet();
        GreetingData greeting = new GreetingData(id, "Hello " + userData.getFirstName() + " " + userData.getLastName());
        return greeting;
    }
}




