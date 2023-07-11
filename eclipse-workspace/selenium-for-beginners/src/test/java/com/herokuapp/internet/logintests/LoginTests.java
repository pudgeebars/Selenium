package com.herokuapp.internet.logintests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.LoginPage;
import com.herokuapp.internet.pages.SecureAreaPage;
import com.herokuapp.internet.pages.WelcomePage;

public class LoginTests extends TestUtilities {

	@Test(priority = 1, groups = { "regression", "smoke", "positive" })
	public void positiveLoginTest() {
		log.info("Start positive login test");

		// open test page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// go to login page
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		// enter user name and password, then click on login
		SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");

		// verifications:
		// new url
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl(),
				"Actual page URL is not the same as expected URL");

		// logout button is visible

		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "log out button is not visible");

		// successful login message
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = secureAreaPage.getSuccessMessageText();
		// Assert.assertEquals(expectedMessage, actualMessage, "actual message is not
		// the same as expected Message");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"actual message is not the same as expected message.\nActual Message:" + actualMessage
						+ "\nExpected Message:\n" + expectedMessage);

		secureAreaPage.logout();

		log.info("End login test");
	}

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 2, groups = { "regression", "smoke", "negative" })
	public void negativeLoginTest(String username, String password, String expectedMessage) {

		log.info("Starting negative login test with:\n" + username + "\n" + password);

		// open test page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		log.info("Page is opened");

		// go to login page
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		
		// enter user name and password, then click on login
		loginPage.negativeLogin(username, password);

		// test for incorrect username
		// if (driver.getCurrentUrl() == "https://the-internet.herokuapp.com/login") {
		// log.info("Still in login page");
	
		String actualFlashMessage = loginPage.getFlashMessage();
		// String invalidUsernameMessage = "Your username is invalid!";
		// String invalidPasswordMessage = "Your password is invalid!";
		Assert.assertTrue(actualFlashMessage.contains(expectedMessage), "Incorrect error message\nActual message:\n"
				+ actualFlashMessage + "\nExpected Message:\n" + expectedMessage + "\n");
		/*
		 * Assert.assertFalse(actualFlashMessage.contains(invalidPasswordMessage),
		 * "The password you entered is invalid\nActual message:\n" + actualFlashMessage
		 * + "\nExpected Message:\n" + invalidPasswordMessage + "\n");
		 */

		sleep(500);

		// end test
		log.info("End invalid login test");

	}

}
