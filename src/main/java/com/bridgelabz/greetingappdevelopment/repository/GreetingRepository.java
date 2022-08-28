package com.bridgelabz.greetingappdevelopment.repository;

import com.bridgelabz.greetingappdevelopment.model.GreetingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingData,Long> {

}
