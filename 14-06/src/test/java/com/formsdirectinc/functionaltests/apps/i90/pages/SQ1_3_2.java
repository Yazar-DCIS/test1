package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_3_2 extends WizardPage {

	public SQ1_3_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_3_2 adjustmentOfStatusInfo(Properties data, String visitThisPage) {
	
			if (visitThisPage.equalsIgnoreCase("yes")) {
				
				AdditionalInfoFields adjustmentOfStatusInfo = new AdditionalInfoFields(driver,"applicationData-formSpecific");
				adjustmentOfStatusInfo.setCityLivedAdjustmentOfStatus(data.getProperty("City"));
				adjustmentOfStatusInfo.setUSCISOffice("ALBANY NY FIELD OFFICE");
				saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
			}


		return this;
	}
}
