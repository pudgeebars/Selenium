package com.herokuapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends BasePage {

	public CheckBoxPage(WebDriver driver, Logger log) {
		super(driver,log);
	}

	private By checkbox1 = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
	private By checkbox2 = By.xpath("//*[@id=\"checkboxes\"]/input[2]");
	
	public void clickCheckBox1() {
		find(checkbox1).click();
	}
	
	public void clickCheckBox2() {
		find(checkbox2).click();
	}
	
	public boolean checkbox1IsSelected() {
		return find(checkbox1).isSelected();
	}
	
	public boolean checkbox2IsSelected() {
		return find(checkbox2).isSelected();
	}
}
