package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_3 extends WizardPage {

	
	public SQ1_3(WebDriver driver) {
		super(driver);
	}

	public SQ1_3 originApplication(String outsideUSWhileApplying, String anytimeLeftUs) {
		if (outsideUSWhileApplying.equalsIgnoreCase("yes")||outsideUSWhileApplying.equalsIgnoreCase("no")) {

			YesNo outsideUSWhileApplyingGreenCard = new YesNo(driver, "formSpecific.whereWereYou");
			
			if (outsideUSWhileApplying.equalsIgnoreCase("yes")) {
				
				outsideUSWhileApplyingGreenCard.yes();
			}

			else if (outsideUSWhileApplying.equalsIgnoreCase("no")) {
				
				outsideUSWhileApplyingGreenCard.no();

				MultiRadioOptions explainedAboutAbsence = new MultiRadioOptions(driver,

				"applicationData-formSpecific.explainedAboutAbsence");

				if (anytimeLeftUs.equalsIgnoreCase("yes")) {
					
					explainedAboutAbsence.selectOption(1);
				}

				else if (anytimeLeftUs.equalsIgnoreCase("no")) {
					explainedAboutAbsence.selectOption(2);
				}
			}

			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}
