package com.formsdirectinc.functionaltests.tags;

/**
 * <--EQ_Success:Script for JVM common to all sites-->
 * @author:Orina <br>
 * Revision: $Rev$
 */
import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;

public class EQ_Success extends WizardPage {

	public EQ_Success(WebDriver driver) {
		super(driver);

	}

	public EQ_Success startApplication(String product) {

		
		Sites site = Sites.valueOf(System.getProperty("site.name"));
		if (product == Products.I751.name()) 
		{
				SelectElement startApplication=new SelectElement(driver, 
						"//span[text()='Start the Application Now']");
				startApplication.selectInvisibleElementUsingXpath();
		} 
		
		else if(product==Products.N400.name()&&site==Sites.AIC)
		{
			SelectElement startApplication = new SelectElement(driver,
					"Start the Application Now");
			startApplication.selectElementUsingLinkText();
			
		}
		
		else if(product==Products.I90.name()&&site==Sites.FR)
		{
			SelectElement startApplication=new SelectElement(driver, 
					"//div[text()='Start the Application Now']");
			startApplication.selectElementUsingXPath();
			
		}
		
		else {
			SelectElement startApplication = new SelectElement(driver,
					"span[class='button-text']");
			startApplication.selectElementUsingCSS();
		}

		return this;

	}

}
