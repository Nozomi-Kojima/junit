package junit.tutorial.ex01.e01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

	@Test
	void toSnakeCase1() {
		String result = StringUtils.toSnakeCase("aaa");
		assertEquals("aaa", result, "toSnakeCase(aaa)失敗");
	}
	
	@Test
	void toSnakeCase2() {
		String result = StringUtils.toSnakeCase("HelloWorld");
		assertEquals("hello_world", result, "toSnakeCase(hello_world)失敗");
	}
	
	@Test
	void toSnakeCase3() {
		String result = StringUtils.toSnakeCase("practiceJunit");
		assertEquals("practice_junit", result, "toSnakeCase(practice_junit)失敗");
	}
}
