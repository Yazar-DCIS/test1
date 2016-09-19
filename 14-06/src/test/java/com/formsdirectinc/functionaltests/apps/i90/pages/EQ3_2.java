package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for EQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_2 extends WizardPage {
	public MultiRadioOptions applicationReason;
	
	public EQ3_2(WebDriver driver) {
		super(driver);
	}

	public EQ3_2 prReasonForApplication(String answer) {
		
		if (!answer.equalsIgnoreCase("NA")) {
			applicationReason = new MultiRadioOptions(driver,
					"applicationData-quiz.prReasonForApplication");
			Sites site = Sites.valueOf(System.getProperty("site.name"));
			if (answer.equalsIgnoreCase("birthday")) {
				applicationReason.selectOption(1);
			}

			else if (answer.equalsIgnoreCase("commuterStatus")) {
				applicationReason.selectOption(2);
			}

			else if (answer.equalsIgnoreCase("liveinUS")) {
				applicationReason.selectOption(3);
			}

			else if (answer.equalsIgnoreCase("permanentResident1")) {
				applicationReason.selectOption(4);
			}

			else if (answer.equalsIgnoreCase("oldEditionCard")) {
				applicationReason.selectOption(5);
			}

			else if (answer.equalsIgnoreCase("none")) {
				applicationReason.selectOption(6);
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
