package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ3_1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ3_1_3 extends WizardPage {


	public SQ3_1_3(WebDriver driver) {
		super(driver);
	}

	public SQ3_1_3 waitToFileApplication(String visitThisPage) {
	
		if (visitThisPage.equalsIgnoreCase("yes")) {

			CheckBox waitToFileApplication = new CheckBox(driver,
					"applicationData-formSpecific.waitToFileApplication");

			waitToFileApplication.check();
			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}
