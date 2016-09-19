package com.formsdirectinc.functionaltests.apps.acquisitionmaintenance;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.payment.PaymentSuccess;
import com.formsdirectinc.functionaltests.apps.registration.Registration;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

public class Acquisitionmaintenance extends Step {

	public Acquisitionmaintenance(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void test(String product, String flowname) throws Exception {

	
		Sites site = Sites.valueOf(System.getProperty("site.name"));

		PropertyResource propertyFile = new PropertyResource();
		Properties prop = propertyFile.loadProperty("acquisition");
		
		
		if(site == Sites.AIC)
		{
			driver.get(site.getBaseURL()+"?referrer=testScriptReferrer");
		
		}
		else if (site == Sites.FR)
		{
			driver.get(site.getBaseURL()+"?refe=testScriptReferrer");
		}
		else{
			driver.get(site.getBaseURL()+"?r=testScriptReferrer");
		}
		
		driver.get(site.getBaseURL()+"?gclid=test");
		
		driver.get("https://www.yahoo.com");
		driver.findElement(By.cssSelector("#UHSearchBox")).sendKeys(site.getBaseURL());
		driver.findElement(By.cssSelector("#UHSearchWeb")).click();			
		driver.findElement(By.linkText(	prop.getProperty("searchLink" + site))).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		
						
			
	
	
	}

}
