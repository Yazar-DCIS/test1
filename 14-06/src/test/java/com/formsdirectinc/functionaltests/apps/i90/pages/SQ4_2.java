package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_2 extends WizardPage {

	private AdditionalInfoFields explain;
	private YesNo abandonedStatus;

	public SQ4_2(WebDriver driver) {
		super(driver);
	}

	public SQ4_2 abondonment(Properties data,String answer) {
					
			abandonedStatus = new YesNo(driver,"formSpecific.filedFormI407OrAbandonedPRStatus.answer");
			abandonedStatus.setYesOrNo(answer);
			if (answer.equalsIgnoreCase("yes")) {
				explain = new AdditionalInfoFields(driver,
						"applicationData-formSpecific.filedFormI407OrAbandonedPRStatus.explanation");
				explain.normalText(data.getProperty("disablity"));
			}

			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}
}
