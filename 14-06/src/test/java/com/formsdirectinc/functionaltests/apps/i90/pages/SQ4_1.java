package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ4_1 extends WizardPage {

	private AdditionalInfoFields explain;
	private YesNo excludedStatus;

	public SQ4_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_1 proceedings(Properties data, String answer) {
		

		if (!answer.equalsIgnoreCase("na")) {
			
			excludedStatus = new YesNo(driver,"formSpecific.inRemovalProceedings.answer");
			excludedStatus.setYesOrNo(answer);
			if (answer.equalsIgnoreCase("yes")) {
				explain = new AdditionalInfoFields(driver,
						"applicationData-formSpecific.inRemovalProceedings.explanation");
				explain.normalText(data.getProperty("disablity"));
			}
			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}
