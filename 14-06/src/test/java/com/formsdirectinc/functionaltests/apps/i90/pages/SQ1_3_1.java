package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_3_1 extends WizardPage {

	public SQ1_3_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_3_1 immigrantVisaInfo(Properties data, String visitThisPage) {
			
			if (visitThisPage.equalsIgnoreCase("yes")) {
				
				AdditionalInfoFields immigrantVisaInfo = new AdditionalInfoFields(driver,"applicationData-formSpecific");
				immigrantVisaInfo.setCityLivedAsImmigrant(data.getProperty("City"));
				immigrantVisaInfo.setConsulateVisaIssued("ADANA");
				
				saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
				
			}
			return this;
	}
}
