package junit.tutorial.ex03.e01;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonthlyCalendarTest {
	private LocalDate nowDate;

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
	void calenderTest1() {
		nowDate = LocalDate.of(2012, 01, 31);
		MonthlyCalendar monthcal = new MonthlyCalendar(nowDate);
		assertEquals(0, monthcal.getRemainingDays(), "error");
	}
	@Test
	void calenderTest2() {
		nowDate = LocalDate.of(2012, 01, 30);
		MonthlyCalendar monthcal = new MonthlyCalendar(nowDate);
		assertEquals(1, monthcal.getRemainingDays(), "error");
	}
	@Test
	void calenderTest3() {
		nowDate = LocalDate.of(2012, 02, 01);
		MonthlyCalendar monthcal = new MonthlyCalendar(nowDate);
		assertEquals(28, monthcal.getRemainingDays(), "error");
	}

}
