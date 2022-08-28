package com.bridgelabz.greetingappdevelopment.service;

import com.bridgelabz.greetingappdevelopment.model.GreetingData;
import com.bridgelabz.greetingappdevelopment.model.UserData;
import com.bridgelabz.greetingappdevelopment.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {

    public static String getMessage() {
        return "Hello World";
    }

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    public GreetingData getGreeting(UserData userData) {
        long id = counter.incrementAndGet();
        GreetingData greeting = new GreetingData(id,"Hello "+userData.getFirstName()+" "+userData.getLastName());
        return greeting;
    }
    public GreetingData addGreeting(UserData userData){
        String message = "Hello"+ userData.getFirstName() +" "+userData.getLastName();
        GreetingData greeting=new GreetingData(counter.incrementAndGet(),message);
        return greetingRepository.save(greeting);
    }
    public GreetingData getGreetingById(long id)
    {
        GreetingData greeting=greetingRepository.findById(id).get();
        return greeting;
    }

}




