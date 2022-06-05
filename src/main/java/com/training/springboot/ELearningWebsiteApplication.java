package com.training.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.springboot.model.User;
import com.training.springboot.repository.UserRepository;

@SpringBootApplication
//public class ELearningWebsiteApplication implements CommandLineRunner {
public class ELearningWebsiteApplication {


	public static void main(String[] args) {
		SpringApplication.run(ELearningWebsiteApplication.class, args);
	}
	/*@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String...args) throws Exception{
		this.userRepository.save(new User("Glad","Anand","2022-02-08","glad@gmail.com", 1234567893, "Pewaukee","tester8","Glad@1234","admin5"));
		this.userRepository.save(new User("Priya","Anand","2022-02-09","priya@gmail.com", 1234567893, "Hartland","tester9","Priya@1234","admin6"));
		this.userRepository.save(new User("Kevin","Anand","2022-02-10","kevin@gmail.com", 1234567893, "Brookfield","tester10","Kevin@1234","admin7"));
	}*/
	

}
