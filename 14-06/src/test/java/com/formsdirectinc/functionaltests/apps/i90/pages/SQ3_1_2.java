package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ3_1_2 extends WizardPage {

	private MultiRadioOptions cardStatus;
	private Name_FirstMiddleLast name;

	public SQ3_1_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_1_2 applicationType(Properties data, String answer) {
		if (!answer.equalsIgnoreCase("na")) {

			cardStatus = new MultiRadioOptions(driver,
					"applicationData-formSpecific.cardStatusConditionalResident");

			if (answer.equalsIgnoreCase("cardLost")) {
				cardStatus.selectOption(1);
			}

			else if (answer.equalsIgnoreCase("cardNeverReceived")) {
				cardStatus.selectOption(2);
			}

			else if (answer.equalsIgnoreCase("cardMutilated")) {
				cardStatus.selectOption(3);
			}

			else if (answer.equalsIgnoreCase("cardHasIncorrectData")) {
				cardStatus.selectOption(4);
			}

			else if (answer.equalsIgnoreCase("nameChanged")) {
				
				cardStatus.selectOption(5);
				name = new Name_FirstMiddleLast(driver, "applicationData",
						"formSpecific.nameAppearedOnGC");
				name.setFirstNameField(data.getProperty("FirstName"));
				name.setLastNameField(data.getProperty("LastName"));
				name.setMiddleNameField(data.getProperty("LastName"));
			}

			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}
