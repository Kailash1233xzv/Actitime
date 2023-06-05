package com.Actitime.TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.POM.Home_Page;
import com.Actitime.POM.TaskPage;

public class Create_Customer extends BaseClass {
	@Test
	public void create_Customer() {
		Home_Page hp =new Home_Page(driver);
		hp.getTasktab().click();
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcust().click();
		FileLibrary f1=new FileLibrary();
		String customer = f1.readDataFromExcel("Data", 2, 1);
		tp.getCustomer().sendKeys(customer);
		String description = f1.readDataFromExcel("Data", 3, 2);
		tp.getCustname().sendKeys(description);
		tp.getCreatebtn().click();
		String expectedresult = customer;
		String actualresult = driver.findElement(By.xpath("(//div[.='"+customer+"'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualresult, expectedresult);
		
	}

}
