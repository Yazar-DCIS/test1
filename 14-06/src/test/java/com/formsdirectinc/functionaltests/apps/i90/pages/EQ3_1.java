package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_1 extends WizardPage {
	public MultiRadioOptions reasonForApplication;
	
	public EQ3_1(WebDriver driver) {
		super(driver);
	}

	public EQ3_1 reasonForApplication(String answer) {
		
		if (!answer.equalsIgnoreCase("NA")) {
			reasonForApplication = new MultiRadioOptions(driver,
					"applicationData-quiz.reasonForApplication");
			Sites site = Sites.valueOf(System.getProperty("site.name"));
			if (answer.equalsIgnoreCase("cardExpired")) {
				reasonForApplication.selectOption(1);
			}

			else if (answer.equalsIgnoreCase("cardLost")) {
				reasonForApplication.selectOption(2);
			}

			else if (answer.equalsIgnoreCase("cardNeverReceived")) {
				reasonForApplication.selectOption(3);
			}

			else if (answer.equalsIgnoreCase("cardMutilated")) {
				reasonForApplication.selectOption(4);
			}

			else if (answer.equalsIgnoreCase("cardInfoIncorrect")) {
				reasonForApplication.selectOption(5);
			}

			else if (answer.equalsIgnoreCase("cardNameChanged")) {
				reasonForApplication.selectOption(6);
			}

			else if (answer.equalsIgnoreCase("reasonUnknown")) {
				reasonForApplication.selectOption(7);
			}
			if(site==Sites.FR)
			{
				clickContinueInEQFR();
			}
			else
			{
				saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInEQ();
			}
		}

		return this;
	}
}
