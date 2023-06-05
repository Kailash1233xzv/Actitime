package com.Actitime.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	//decleration
	@FindBy(xpath="//div[.='Tasks']")
	private WebElement tasktab;
	
	@FindBy(xpath="//div[.='Reports']")
	private WebElement reporttabs;
	
	@FindBy(xpath="//div[.='Users']")
	private WebElement usertab;
	
	//@FindBy(By.id("logoutLink")
	//private WebElement usert;
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getTasktab() {
		return tasktab;
	}

	public WebElement getReporttabs() {
		return reporttabs;
	}

	public WebElement getUsertab() {
		return usertab;
	}
}
