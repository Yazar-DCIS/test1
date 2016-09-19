package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ3_2 extends WizardPage {

	private YesNo cardStatus;
	private Name_FirstMiddleLast otherName;

	public SQ3_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_2 nameChange(Properties data, String answer) {
		if (!answer.equalsIgnoreCase("na")) {
			cardStatus = new YesNo(driver, "formSpecific.hasNameChanged");

			if (answer.equalsIgnoreCase("yes")) {
				
				cardStatus.yes();
				otherName = new Name_FirstMiddleLast(driver, "applicationData",
						"formSpecific.nameAppearedOnGC");
				otherName.setFirstNameField(data.getProperty("FirstName"));
				otherName.setMiddleNameField(data.getProperty("MiddleName"));
				otherName.setLastNameField(data.getProperty("LastName"));
			}

			else if (answer.equalsIgnoreCase("no")) {
				cardStatus.no();
			}

			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}
