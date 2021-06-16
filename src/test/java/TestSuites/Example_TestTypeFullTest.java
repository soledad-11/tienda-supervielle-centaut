package TestSuites;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import org.junit.jupiter.api.Tag;
import TestCases.LoginTest;

public class Example_TestTypeFullTest {
	static DriverManager DM;
	static Datasources data;
	static Reports report;

	@BeforeAll
	static void initAll() {
		// DriverManager
		DM = new DriverManager();
		// DataSource
		data = new Datasources();
		// Reports
		report = new Reports();
	}

	@BeforeEach
	void init() {
	}

	@Test
	@Tag("Smoke")
	@Tag("TestCaseLoginWithValidData")
	@Tag("TestSuiteLogin")
	void loginWithValidData() {
		// DEFINITIONS
		LoginTest tc = new LoginTest();
		String name = "Login with valid data";
		report.addTestCaseToGeneralReport(tc.Test(data, report, DM, 1, name), name, "");
		report.saveTestCaseReport(name);
	}

	@AfterEach
	void tearDown() {

	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("Execution finished");
		report.saveGeneralReport();
	}

}
