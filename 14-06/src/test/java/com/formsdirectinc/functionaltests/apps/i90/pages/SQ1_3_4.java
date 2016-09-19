package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_3_4 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_3_4 extends WizardPage {

	private AdditionalInfoFields classOfAdmission;

	public SQ1_3_4(WebDriver driver) {
		super(driver);
	}

	public SQ1_3_4 classOfAdmission(Properties data, String visitThisPage) {
		
			if (visitThisPage.equalsIgnoreCase("yes")) {
				classOfAdmission = new AdditionalInfoFields(driver,
						"pdf.classOfAdmission");
				classOfAdmission.textDDM(data.getProperty("COA"));
				saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
			}
	
		return this;
	}
}
