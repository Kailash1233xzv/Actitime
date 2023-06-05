package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.POM.Login_Page;

public class BaseClass {
	FileLibrary fl=new FileLibrary();
	public static WebDriver driver;
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("Database connected",true);
	}
	@BeforeClass
	public void launchbrowser() throws IOException {
	driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	String actitime = fl.readDataFromProprtyFile("url");
	
	driver.get("actitime");
	Reporter.log("browser lainched",true);
	}
	@BeforeMethod
	public void login() throws IOException {
		Login_Page lp=new Login_Page(driver);
      String un = fl.readDataFromProprtyFile("username");
      String pw = fl.readDataFromProprtyFile("password");
		lp.getUntbx().sendKeys(un);
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		Reporter.log("LOGGED IN SUCCESSFULLY",true);
	}
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("LOGGED IN SUCCESSFULLY",true);
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("Browser Closed",true);	
	}
	@AfterSuite
	public void closeddatabaseConnection() {
		Reporter.log("database disconnection",true);
	}
}
