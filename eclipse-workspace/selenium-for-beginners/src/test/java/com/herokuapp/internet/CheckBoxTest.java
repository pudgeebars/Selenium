package com.herokuapp.internet;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.internet.base.TestUtilities;
import com.herokuapp.internet.pages.CheckBoxPage;
import com.herokuapp.internet.pages.WelcomePage;

public class CheckBoxTest extends TestUtilities {
	
	@Test
	public void verifyCheckBoxFunction() {
		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();
		CheckBoxPage checkboxPage = welcomePage.clickCheckboxesLink();
		
		if (!checkboxPage.checkbox1IsSelected())
			checkboxPage.clickCheckBox1();
		if (!checkboxPage.checkbox2IsSelected())
			checkboxPage.clickCheckBox2();
		
		Assert.assertTrue((checkboxPage.checkbox1IsSelected() && checkboxPage.checkbox2IsSelected()) , "Both Checkboxes are selected");
		
	}
}
