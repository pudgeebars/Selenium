package DemoTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// This class shows how TestNG configuration annotation works

public class ConfigurationAnnotations_1_DatePickers {

	@Test(groups= {"smoke"})
	public void test1_BootstrapDatePicker () {
		System.out.println("     (5)Test Method 1:Bootstrap Date Picker");
	}
	
	@Test(groups= {"regression","e2e"})
	public void test2_JQueryDatePicker () {
		System.out.println("     (5)Test Method 2:JQuery Date Picker");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("    (4)Executed before each test method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("    (4)Executed after each test method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("   (3)Executed before each class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("   (3)Executed after each class");
	}
	

	
}
