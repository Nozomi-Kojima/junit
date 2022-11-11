package junit.tutorial.ex01.e02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.tutorial.ex01.e03.Counter;

class CalculatorTest {

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
	void incrementTest1() {
		Counter counter = new Counter();
		int result = counter.increment();
		assertEquals(1, result, "エラー！");
	}

	@Test
	void incrementTest2() {
		Counter counter = new Counter();
		int result = counter.increment();
		result = counter.increment();
		assertEquals(2, result, "エラー！");

	}
	@Test
	void incrementTest3() {
		Counter counter = new Counter();
		int result;
		for(int i = 1; i <= 50; i++) {
			result = counter.increment();
		}
		result = counter.increment();
		assertEquals(51, result, "エラー！");

	}
}