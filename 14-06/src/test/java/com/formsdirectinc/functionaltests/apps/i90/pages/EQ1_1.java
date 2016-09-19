package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for EQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class EQ1_1 extends WizardPage {
	public MultiRadioOptions residentStatus;

	public EQ1_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_1 customerStatus(String answer) {
		Sites site = Sites.valueOf(System.getProperty("site.name"));
		residentStatus = new MultiRadioOptions(driver,"applicationData-quiz.typeOfApplicant");

			if (answer.equalsIgnoreCase("PermanentResident")) {
				residentStatus.selectOption(1);
			}

			else if (answer.equalsIgnoreCase("ConditionalPR")) {
				residentStatus.selectOption(2);
			}

			else if (answer.equalsIgnoreCase("noGreenCard")) {
				residentStatus.selectOption(3);
			}
			if(site==Sites.FR)
			{
				clickContinueInEQFR();
			}
			else
			{
				saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInEQ();
			}
		return this;
	}


}
