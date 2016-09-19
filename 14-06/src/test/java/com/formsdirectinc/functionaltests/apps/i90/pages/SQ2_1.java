package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_1 extends WizardPage {

	
	public SQ2_1(WebDriver driver) {
		super(driver);
	}

	public SQ2_1 yourStatus(String residentYears, String commuterStatus) {
		if (residentYears.equalsIgnoreCase("2years")||residentYears.equalsIgnoreCase("morethan2")) {
			
			MultiRadioOptions residentYearStatus = new MultiRadioOptions(driver,
					"applicationData-formSpecific.residentStatus");

			if (residentYears.equalsIgnoreCase("2years")) {
				residentYearStatus.selectOption(1);
			}

			else if (residentYears.equalsIgnoreCase("morethan2")) {
				residentYearStatus.selectOption(2);

				MultiRadioOptions commuterStatusIs = new MultiRadioOptions(driver,"applicationData-formSpecific.commuterStatus");

				if (commuterStatus.equalsIgnoreCase("regularPR")) {
					commuterStatusIs.selectOption(1);
				}

				else if (commuterStatus.equalsIgnoreCase("commuterPR")) {
					commuterStatusIs.selectOption(2);
				}
			}

			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}
