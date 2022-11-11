package junit.tutorial.ex02.e03;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RangeTest {

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
	void Rangetest() {
		Range range1 = new Range(0.0, 10.5);
		assertAll("Range", () -> assertFalse(range1.contains(-0.1), "error:-0.1 not false"),
				() -> assertTrue(range1.contains(0.0), "error:0.0 not true"),
				() -> assertTrue(range1.contains(10.5), "error:10.5 not true"),
				() -> assertFalse(range1.contains(10.6), "error:10.6 not false"));

		Range range2 = new Range(-5.1, 5.1);
		assertAll("Range", () -> assertFalse(range2.contains(-5.2), "error:-5.2 not false"),
				() -> assertTrue(range2.contains(-5.1), "error:-5.1 not true"),
				() -> assertTrue(range2.contains(5.1), "error:5.1 not true"),
				() -> assertFalse(range2.contains(5.2), "error:5.2 not false"));
	}

	@ParameterizedTest
	@ValueSource(doubles = { 0.0, 10.5 })
	void Rangetest3(double n) {
		Range range3 = new Range(0.0, 10.5);
		assertTrue(range3.contains(n));
	}

	@ParameterizedTest
	@ValueSource(doubles = { -0.1, 10.6 })
	void Rangetest4(double n) {
		Range range4 = new Range(0.0, 10.5);
		assertFalse(range4.contains(n));
	}

	@ParameterizedTest
	@ValueSource(doubles = { -5.1, 5.1 })
	void Rangetest5(double n) {
		Range range5 = new Range(-5.1, 5.1);
		assertTrue(range5.contains(n));
	}

	@ParameterizedTest
	@ValueSource(doubles = { -5.2, 5.2 })
	void Rangetest6(double n) {
		Range range6 = new Range(-5.1, 5.1);
		assertFalse(range6.contains(n));

	}
}
