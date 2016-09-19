package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_1 extends WizardPage {

	private MultiRadioOptions agreeToAcknowledgements;

	public SQ5_1(WebDriver driver) {
		super(driver);
	}

	public SQ5_1 agreeToSubmit(String agreeToAcknowledgement) {

			agreeToAcknowledgements = new MultiRadioOptions(driver,	"applicationData-applicant.acknowledgements");

			if (agreeToAcknowledgement.equalsIgnoreCase("yes")) {
				agreeToAcknowledgements.selectOption(1);
			}

			else if (agreeToAcknowledgement.equalsIgnoreCase("no")) {
				agreeToAcknowledgements.selectOption(2);
			}

		saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}
}
