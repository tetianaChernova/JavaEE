package kma.javaee.practice7.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Practice7SpringDataApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Practice7SpringDataApplication.class, args);

		UserService userService = applicationContext.getBean(UserService.class);

		UserEntity user1 = UserEntity.builder()
			.fullName("john smith")
			.email("john.smith@email.com")
			.build();
		user1 = userService.saveUser(user1);
		System.out.println("New user: " + user1);

		UserEntity user2 = UserEntity.builder()
			.fullName("james gosling")
			.email("james.gosling@email.com")
			.build();
		user2 = userService.saveUser(user2);
		System.out.println("New user: " + user2);

		System.out.println("Get user by id 1: " + userService.getUserById(1));
		System.out.println("Get user by unknown id: " + userService.getUserById(1000));
		System.out.println("======================");
		System.out.println("Get all users: " + userService.getAllUsers());
		System.out.println("======================");
		System.out.println("Get all user with \"i\": " + userService.getAllUsersWhereNameLike("i"));
		System.out.println("Get all user with \"smith\": " + userService.getAllUsersWhereNameLike("smith"));
		System.out.println("======================");
		System.out.println("Exists by email [john.smith@email.com]: " + userService.existByEmail("john.smith@email.com"));
		System.out.println("Exists by email [unknown@email.com]: " + userService.existByEmail("unknown@email.com"));
		System.out.println("======================");
		System.out.println("find by custom query: " + userService.findAllWhereEmailLikeOrFullNameLike("smith@email", "gosling"));
	}

}
