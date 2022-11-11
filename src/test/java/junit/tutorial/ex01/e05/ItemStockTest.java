package junit.tutorial.ex01.e05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.tutorial.ex01.e04.NumberUtils;

class ItemStockTest {

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
	void getNumtest1() {
		ItemStock itemStock = new ItemStock();
		Item item = new Item(null, 0);
		int result = itemStock.getNum(item);
		assertEquals(0, result, "エラー！");
	}
	@Test
	void getNumtest2() {
		ItemStock itemStock = new ItemStock();
		Item item = new Item(null, 0);
		item.setName("book");
		item.setPrice(100);
		itemStock.add(item);
		int result = itemStock.getNum(item);
		assertEquals(1, result, "エラー！");
	}
	
	@Test
	void getNumtest4() {
		ItemStock itemStock = new ItemStock();
		Item item = new Item(null,0);
		item.setName("book");
		item.setPrice(100);
		itemStock.add(item);
		itemStock.add(item);
		int result = itemStock.getNum(item);
		assertEquals(2, result, "エラー！");
	}
	@Test
	void getNumtest5() {
		ItemStock itemStock = new ItemStock();
		Item item = new Item(null,0);
		String item1 = "book";
		String item2 = "CD";
		item.setName(item1);
		itemStock.add(item);
		item.setName(item2);
		itemStock.add(item);
		int result = itemStock.getNum(item);
		assertEquals(1, result, "エラー！");
	}

}

