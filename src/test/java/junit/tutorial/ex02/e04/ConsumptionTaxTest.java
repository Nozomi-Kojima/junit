package junit.tutorial.ex02.e04;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConsumptionTaxTest {

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
	void ConsumptionTaxTest1() {
		ConsumptionTax conTax5 = new ConsumptionTax(5);
		assertAll("ConsumptionTax5%", () -> assertEquals(105, conTax5.apply(100), "error:入力値(100)"),
				() -> assertEquals(3150, conTax5.apply(3000), "error:入力値(3000)"),
				() -> assertEquals(52, conTax5.apply(50), "error:入力値(50)"));

		ConsumptionTax conTax10 = new ConsumptionTax(10);
		assertAll("ConsumptionTax10%", () -> assertEquals(55, conTax10.apply(50), "error:入力値(50)"));

		ConsumptionTax conTax3 = new ConsumptionTax(3);
		assertAll("ConsumptionTax3%", () -> assertEquals(51, conTax3.apply(50), "error:入力値(50)"));
	}
	@ParameterizedTest
	 @CsvSource({
			"5,  100, 105",
		    "5, 3000, 3150",
		    "10, 50, 55",
		    "5,  50, 52",
		    "3, 50, 51",
	})
	void ConsumptionTaxTest2(int tax, int input, int expectedValue) {
		ConsumptionTax contax = new ConsumptionTax(tax);
		int inputprice = contax.apply(input);
		assertThat(expectedValue).isEqualTo(inputprice);
		assertEquals(expectedValue, inputprice, "error not equals");
	}
	
}
