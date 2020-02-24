package kma.topic6.springdatasample;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringWebSampleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringWebSampleApplication.class, args);
		UserService userService = applicationContext.getBean(UserService.class);

		UserEntity user = userService.createUser("firstName1", "lastName1", "email1@example.com");
		System.out.println("Saved new user: " + user);
		userService.createUser("firstName2", "lastName2", "email2@example.com");

		System.out.println("Get user by id 1: " + userService.getUserById(1));
		System.out.println("Get user by unknown id: " + userService.getUserById(1000));

		System.out.println("Number of users in DB:" + userService.countUsers());
		System.out.println("Find all users\n" + userService.findAllUsers());

		System.out.println("==== Custom query example =====");
		System.out.println("Get users, where one of name parts start with 'first': \n" + userService.findUserWhereFirstOrLastNameContains("first"));
		userService.createUser("otherFirstName", "otherLastName", "email3@example.com");
		System.out.println("Get users, where one of name parts start with 'other': \n" + userService.findUserWhereFirstOrLastNameContains("other"));
		System.out.println("User with email 'email3@example.com': " + userService.findByEmail("email3@example.com"));
	}

}
