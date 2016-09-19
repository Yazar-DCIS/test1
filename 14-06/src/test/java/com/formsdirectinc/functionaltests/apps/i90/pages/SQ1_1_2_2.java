package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_1_2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1_2_2 extends WizardPage {

	private CheckBox addressFields;
	
	public SQ1_1_2_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_2_2 setAddressFields(Properties data, String addressType) {

		
		if(addressType.equalsIgnoreCase("useMyAddress"))
		{
			addressFields = new CheckBox(driver,
					"applicationData-formSpecific.sureAboutMyPhisicalAddress");
			addressFields.check();
			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		}
	
		return this;
	}

}
