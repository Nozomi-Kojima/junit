package junit.tutorial.ex03.e03;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import junit.tutorial.ex03.e02.LogAnalyzer;
import junit.tutorial.ex03.e02.LogLoader;
@ExtendWith(MockitoExtension.class)
class NetworkResourcesTest {
	@InjectMocks
	private NetworkResources netResource = new NetworkResources();
	@Mock
	private NetworkLoader netLoader;
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
	void networkResourceTest1() throws Exception {
		String  message= "HelloWorld";
		ByteArrayInputStream buff = new ByteArrayInputStream(message.getBytes());
		doReturn(buff).when(netLoader).getInput();
		assertEquals(message, netResource.load());
	}

}
