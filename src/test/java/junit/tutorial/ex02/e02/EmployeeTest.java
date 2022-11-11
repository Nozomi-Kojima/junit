package junit.tutorial.ex02.e02;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {

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
	void employeeTest() throws Exception  {
		InputStream sytemin = System.in;
		// ファイルからストリームを作る
		InputStream fileStream = new FileInputStream("/kyojima/springworkspace/junit/src/main/java/junit/tutorial/ex02/e02/Employee.txt");
		// ストリームをバッファする
		InputStream bufferedStream = new BufferedInputStream(fileStream); 
		
		Employee target = new Employee();
		target.load(bufferedStream);
		assertAll("employee",
			() -> assertEquals("Ichiro", target.getFirstName(), "error:firstName"),
			() -> assertEquals("Tanaka", target.getLastName(), "error:lastName"),
			() -> assertEquals("ichiro@example.com", target.getEmail(), "error:eMail")
		);
		bufferedStream.close();
	}

}
