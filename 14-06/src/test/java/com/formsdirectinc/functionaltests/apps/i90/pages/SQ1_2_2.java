package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_2_2 extends WizardPage {

	private Numbers securityNumber;

	public SQ1_2_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_2_2 haveSSN(Properties data, String haveSSN) {

		securityNumber = new Numbers(driver, "applicationData-applicant.SSN");
		if(haveSSN.equalsIgnoreCase("Yes"))
		{
			securityNumber.setSocialSecurityNumberI90(data.getProperty("SSN_1"),
					data.getProperty("SSN_2"), data.getProperty("SSN_3"));
		}
		else
		{
			securityNumber.setNumberUnknown();
		}
		
		saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}
}
