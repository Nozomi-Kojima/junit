package junit.tutorial.ex03.e04;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class AuthenticationTest {
	@InjectMocks
	Authentication auth = new Authentication();
	@Mock
	AccountDao accountDao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void certificationTest1() {
		doReturn(null).when(accountDao).findOrNull("username");
		assertNull(auth.authenticate("username","password"));
	}
	@Test
	void certificationTest2() {
		Account account = new Account("username", "password");
		doReturn(account).when(accountDao).findOrNull("username");	
		Account inputLogin = auth.authenticate("username", "password"); 
		assertEquals(account, inputLogin);
	}
	@Test
	void certificationTest3() {
		Account account = new Account("username", "password");
		doReturn(account).when(accountDao).findOrNull("username");	
		Account inputLogin = auth.authenticate("username", "passw");
		assertNull(inputLogin);
	}
}
