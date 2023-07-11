package DemoTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//This class also shows how TestNG configuration annotation works but the test annotation is on a class level

@Test(groups="smoke")
public class ConfigurationAnnotations_2_ListBox {
	
	public void test1_BootstrapListBox () {
		System.out.println("     (5)Test Method 3:Bootstrap List Box");
	}
	
	
	public void test1_JQueryListBox () {
		System.out.println("     (5)Test Method 4:JQuery List Box");
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
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("  (2)Executed before each test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("  (2)Executed after each test");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println(" (1)Executed before each suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println(" (1)Executed after each suite");
	}
	
	@BeforeGroups(groups= {"regression","smoke"})
	public void beforeGroup() {
		System.out.println("Executed before group:");
	}
	
	@AfterGroups(groups= {"regression","smoke"})
	public void afterGroup() {
		System.out.println("Executed after group:");
	}
}






