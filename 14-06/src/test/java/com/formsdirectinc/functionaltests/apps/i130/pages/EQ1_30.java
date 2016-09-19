package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_30 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_30 extends WizardPage {

	public YesNo permanentResidentFiveYearsAgo;

	public EQ1_30(WebDriver driver) {
		super(driver);

	}

	public EQ1_30 permanentResidentFiveYearsAgo(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

		
			permanentResidentFiveYearsAgo = new YesNo(driver,
					"quiz.permanentResidentFiveYearsAgo");

			permanentResidentFiveYearsAgo.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}
