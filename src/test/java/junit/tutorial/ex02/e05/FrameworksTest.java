package junit.tutorial.ex02.e05;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FrameworksTest {

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
	void SupportTest1() {
		Boolean GlassFish1 = Frameworks.isSupport(ApplicationServer.GlassFish,Database.Oracle);
		Boolean GlassFish2 = Frameworks.isSupport(ApplicationServer.GlassFish,Database.DB2);
		Boolean GlassFish3 = Frameworks.isSupport(ApplicationServer.GlassFish,Database.PostgreSQL);
		Boolean GlassFish4 = Frameworks.isSupport(ApplicationServer.GlassFish,Database.MySQL);
		assertAll("GlassFish",
				() -> assertTrue(GlassFish1, "error:not support Oracle"),
				() -> assertTrue(GlassFish2, "error:not support DB2"),
				() -> assertTrue(GlassFish3, "error:not support PostgreSQL"),
				() -> assertTrue(GlassFish4, "error:not support MySQL")
				);
	}
	@Test
	void SupportTest2() {
		Boolean JBoss1 = Frameworks.isSupport(ApplicationServer.JBoss,Database.Oracle);
		Boolean JBoss2 = Frameworks.isSupport(ApplicationServer.JBoss,Database.DB2);
		Boolean JBoss3 = Frameworks.isSupport(ApplicationServer.JBoss,Database.PostgreSQL);
		Boolean JBoss4 = Frameworks.isSupport(ApplicationServer.JBoss,Database.MySQL);
		assertAll("JBoss",
				() -> assertFalse(JBoss1, "error:Oracle"),
				() -> assertTrue(JBoss2, "error:not support DB2"),
				() -> assertTrue(JBoss3, "error:not support PostgreSQL"),
				() -> assertFalse(JBoss4, "error:MySQL")
				);
	}
	
	@Test
	void SupportTest3() {
		Boolean Tomcat1 = Frameworks.isSupport(ApplicationServer.Tomcat,Database.Oracle);
		Boolean Tomcat2 = Frameworks.isSupport(ApplicationServer.Tomcat,Database.DB2);
		Boolean Tomcat3 = Frameworks.isSupport(ApplicationServer.Tomcat,Database.PostgreSQL);
		Boolean Tomcat4 = Frameworks.isSupport(ApplicationServer.Tomcat,Database.MySQL);
		assertAll("JBoss",
				() -> assertFalse(Tomcat1, "error:Oracle"),
				() -> assertFalse(Tomcat2, "error:DB2"),
				() -> assertFalse(Tomcat3, "error:PostgreSQL"),
				() -> assertTrue(Tomcat4, "error:not support MySQL")
				);
	}
	@ParameterizedTest
	 @CsvSource({
			"GlassFish,Oracle",
		    "GlassFish,DB2",
			"GlassFish, PostgreSQL",
		    "GlassFish, MySQL",
		    "JBoss,PostgreSQL",
		    "JBoss,DB2",
		    "Tomcat,MySQL",
	})
	void SupportTest4(ApplicationServer app, Database data) {
		Frameworks frame = new Frameworks();
		Boolean result = frame.isSupport(app, data);
		assertTrue(result,"error:not true");
		
	}
	@ParameterizedTest
	 @CsvSource({
			"JBoss,Oracle",
		    "JBoss,MySQL",
			"Tomcat,Oracle",
		    "Tomcat,DB2",
		    "Tomcat,PostgreSQL",
		    })
	void SupportTest5(ApplicationServer app, Database data) {
		Frameworks frame = new Frameworks();
		Boolean result = frame.isSupport(app, data);
		assertFalse(result,"error:not false");
		
	}
	@ParameterizedTest
	 @CsvSource({
			"true,GlassFish,Oracle",
		    "true,GlassFish,DB2",
			"true,GlassFish, PostgreSQL",
		    "true,GlassFish, MySQL",
		    "true,JBoss,PostgreSQL",
		    "true,JBoss,DB2",
		    "true,Tomcat,MySQL",
		    "false,JBoss,Oracle",
		    "false,JBoss,MySQL",
			"false,Tomcat,Oracle",
		    "false,Tomcat,DB2",
		    "false,Tomcat,PostgreSQL",
	})
	void SupportTest6(Boolean truth,ApplicationServer app, Database data) {
		Frameworks frame = new Frameworks();
		Boolean result = frame.isSupport(app, data);
		assertEquals(truth, result, "error:not equals");
	}

}
