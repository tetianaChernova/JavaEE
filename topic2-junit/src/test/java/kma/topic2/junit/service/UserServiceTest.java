package kma.topic2.junit.service;

import kma.topic2.junit.exceptions.ConstraintViolationException;
import kma.topic2.junit.exceptions.LoginExistsException;
import kma.topic2.junit.model.NewUser;
import kma.topic2.junit.model.User;
import kma.topic2.junit.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserServiceTest {
	private static final String LOGIN1 = "login1";
	private static final String LOGIN2 = "login2";
	private static final String LOGIN3 = "login3";
	private static final String FULL_NAME = "Test user";
	private static final String PASSWORD = "pass";
	private static final String PASSWORD_WITH_INVALID_SIZE = "testPassword";
	private static final String PASSWORD_WITH_INVALID_SYMBOL = "test_pa";
	private static final String PASSWORD_WITH_INVALID_SYMBOL_AND_SIZE = "test_password";
	private static final String LOGIN_EXISTS_EXCEPTION_MESSAGE = "Login %s already taken";
	private static final String CONSTRAINT_VIOLATION_EXCEPTION_MESSAGE = "You have errors in you object";
	private static final String PASSWORD_INVALID_SIZE_EXCEPTION_MESSAGE = "Password has invalid size";
	private static final String PASSWORD_INVALID_SYMBOL_EXCEPTION_MESSAGE = "Password doesn't match regex";

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	@Test
	public void shouldCreateNewUserSuccessfully() {
		NewUser user = NewUser.builder()
				.fullName(FULL_NAME)
				.login(LOGIN1)
				.password(PASSWORD)
				.build();

		User expectedUser = User.builder()
				.fullName(FULL_NAME)
				.login(LOGIN1)
				.password(PASSWORD)
				.build();

		userService.createNewUser(user);

		assertEquals(userService.getUserByLogin(LOGIN1), expectedUser);
		assertEquals(userRepository.getUserByLogin(LOGIN1), expectedUser);
	}

	@Test
	public void shouldNotCreateNewUserWithExistingLogin() {
		NewUser user = NewUser.builder()
				.fullName(FULL_NAME)
				.login(LOGIN2)
				.password(PASSWORD)
				.build();

		userService.createNewUser(user);
		assertThrows(LoginExistsException.class, () -> userService.createNewUser(user),
				String.format(LOGIN_EXISTS_EXCEPTION_MESSAGE, user.getLogin()));
	}

	@Test
	public void shouldFailUserCreationBecauseOfPasswordInvalidSizeException() {
		NewUser user = NewUser.builder()
				.fullName(FULL_NAME)
				.login(LOGIN3)
				.password(PASSWORD_WITH_INVALID_SIZE)
				.build();

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class,
				() -> userService.createNewUser(user), CONSTRAINT_VIOLATION_EXCEPTION_MESSAGE);
		assertEquals(exception.getErrors(), Collections.singletonList(PASSWORD_INVALID_SIZE_EXCEPTION_MESSAGE));
	}

	@Test
	public void shouldFailUserCreationBecauseOfPasswordInvalidSymbolException() {
		NewUser user = NewUser.builder()
				.fullName(FULL_NAME)
				.login(LOGIN3)
				.password(PASSWORD_WITH_INVALID_SYMBOL)
				.build();

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class,
				() -> userService.createNewUser(user), CONSTRAINT_VIOLATION_EXCEPTION_MESSAGE);
		assertEquals(exception.getErrors(), Collections.singletonList(PASSWORD_INVALID_SYMBOL_EXCEPTION_MESSAGE));
	}


	@Test
	public void shouldFailUserCreationBecauseOfPasswordInvalidSymbolAndSizeException() {
		NewUser user = NewUser.builder()
				.fullName(FULL_NAME)
				.login(LOGIN3)
				.password(PASSWORD_WITH_INVALID_SYMBOL_AND_SIZE)
				.build();

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class,
				() -> userService.createNewUser(user), CONSTRAINT_VIOLATION_EXCEPTION_MESSAGE);
		assertEquals(exception.getErrors(), List.of(PASSWORD_INVALID_SIZE_EXCEPTION_MESSAGE,
				PASSWORD_INVALID_SYMBOL_EXCEPTION_MESSAGE));
	}

}