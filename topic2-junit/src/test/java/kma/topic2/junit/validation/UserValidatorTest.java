package kma.topic2.junit.validation;

import kma.topic2.junit.exceptions.ConstraintViolationException;
import kma.topic2.junit.exceptions.LoginExistsException;
import kma.topic2.junit.model.NewUser;
import kma.topic2.junit.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserValidatorTest {
	private static final String LOGIN = "login";
	private static final String FULL_NAME = "Test user";
	private static final String PASSWORD = "pass";
	private static final String PASSWORD_WITH_INVALID_SIZE = "testPassword";
	private static final String PASSWORD_WITH_INVALID_SYMBOL = "test_pa";
	private static final String PASSWORD_WITH_INVALID_SYMBOL_AND_SIZE = "test_password";
	private static final String LOGIN_EXISTS_EXCEPTION_MESSAGE = "Login %s already taken";
	private static final String CONSTRAINT_VIOLATION_EXCEPTION_MESSAGE = "You have errors in you object";
	private static final String PASSWORD_INVALID_SIZE_EXCEPTION_MESSAGE = "Password has invalid size";
	private static final String PASSWORD_INVALID_SYMBOL_EXCEPTION_MESSAGE = "Password doesn't match regex";

	@InjectMocks
	private UserValidator testInstance;
	@Mock
	private UserRepository userRepository;
	private NewUser user;

	@BeforeEach
	public void init() {
		user = NewUser.builder()
				.fullName(FULL_NAME)
				.login(LOGIN)
				.password(PASSWORD)
				.build();
	}

	@Test
	public void shouldValidateNewUserSuccessfully() {
		when(userRepository.isLoginExists(LOGIN)).thenReturn(false);

		assertDoesNotThrow(() -> testInstance.validateNewUser(user));
	}

	@Test
	public void shouldThrowLoginExistsExceptionWhenValidateExistedLogin() {
		when(userRepository.isLoginExists(LOGIN)).thenReturn(true);

		assertThrows(LoginExistsException.class,
				() -> testInstance.validateNewUser(user),
				String.format(LOGIN_EXISTS_EXCEPTION_MESSAGE, user.getLogin()));
	}

	@Test
	public void shouldThrowExceptionBecauseOfInvalidPasswordSize() {
		NewUser userWithInvalidPassword = NewUser.builder()
				.fullName(FULL_NAME)
				.login(LOGIN)
				.password(PASSWORD_WITH_INVALID_SIZE)
				.build();

		when(userRepository.isLoginExists(userWithInvalidPassword.getLogin())).thenReturn(false);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class,
				() -> testInstance.validateNewUser(userWithInvalidPassword), CONSTRAINT_VIOLATION_EXCEPTION_MESSAGE);
		assertEquals(exception.getErrors(), Collections.singletonList(PASSWORD_INVALID_SIZE_EXCEPTION_MESSAGE));
	}

	@Test
	public void shouldThrowExceptionBecauseOfInvalidPasswordSymbol() {
		NewUser userWithInvalidPassword = NewUser.builder()
				.fullName(FULL_NAME)
				.login(LOGIN)
				.password(PASSWORD_WITH_INVALID_SYMBOL)
				.build();

		when(userRepository.isLoginExists(userWithInvalidPassword.getLogin())).thenReturn(false);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class,
				() -> testInstance.validateNewUser(userWithInvalidPassword), CONSTRAINT_VIOLATION_EXCEPTION_MESSAGE);
		assertEquals(exception.getErrors(), Collections.singletonList(PASSWORD_INVALID_SYMBOL_EXCEPTION_MESSAGE));
	}

	@Test
	public void shouldThrowExceptionBecauseOfInvalidPasswordSymbolAndSize() {
		NewUser userWithInvalidPassword = NewUser.builder()
				.fullName(FULL_NAME)
				.login(LOGIN)
				.password(PASSWORD_WITH_INVALID_SYMBOL_AND_SIZE)
				.build();

		when(userRepository.isLoginExists(userWithInvalidPassword.getLogin())).thenReturn(false);

		ConstraintViolationException exception = assertThrows(ConstraintViolationException.class,
				() -> testInstance.validateNewUser(userWithInvalidPassword), CONSTRAINT_VIOLATION_EXCEPTION_MESSAGE);
		assertEquals(exception.getErrors(), List.of(PASSWORD_INVALID_SIZE_EXCEPTION_MESSAGE, PASSWORD_INVALID_SYMBOL_EXCEPTION_MESSAGE));
	}

}