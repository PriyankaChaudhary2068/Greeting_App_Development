package com.bridgelabz.greetingappdevelopment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "greetingappmessage")
public class GreetingData {
    @Id
    String name;
    long id;
    public GreetingData(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GreetingData() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}