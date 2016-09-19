package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ2_1 extends WizardPage {
	private DateTag datePermanentResidency;

	public EQ2_1(WebDriver driver) {
		super(driver);
	}

	public EQ2_1 dateSelection(Properties data, String answer) {
	
		if (!answer.equalsIgnoreCase("NA")) {
			Sites site = Sites.valueOf(System.getProperty("site.name"));
			datePermanentResidency = new DateTag(driver, "quiz.cprExpiryDate");

			if (answer.equalsIgnoreCase("set_expiryDate1")) {
				datePermanentResidency.selectDateAsSingle(data
						.getProperty("I90_PR1"));
			}

			else if (answer.equalsIgnoreCase("set_expiryDate2")) {
				datePermanentResidency.selectDateAsSingle(data
						.getProperty("I90_PR2"));
			}

			else if (answer.equalsIgnoreCase("set_expiryDate3")) {
				datePermanentResidency.selectDateAsSingle(data
						.getProperty("I90_PR3"));
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
