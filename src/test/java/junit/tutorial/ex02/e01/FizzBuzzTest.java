package junit.tutorial.ex02.e01;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {

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
	void FizzBuzztest1() {
		FizzBuzz fizzBuzz = new FizzBuzz();
		List<String> fizzBuzzList = fizzBuzz.createFizzBuzzList(16);
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= 16; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				result.add("FizzBuzz");
			} else if (i % 5 == 0) {
				result.add("Buzz");
			} else if (i % 3 == 0) {
				result.add("Fizz");
			} else {
				result.add("" + i);
			}
		}
	
		assertIterableEquals(fizzBuzzList, result);
	}
}
