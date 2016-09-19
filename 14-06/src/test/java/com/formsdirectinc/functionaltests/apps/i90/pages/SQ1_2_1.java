package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_2_1 extends WizardPage {


	public SQ1_2_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_2_1 haveARN(Properties data, String haveARN,String noARNreason) {

		Numbers arNumber=new Numbers(driver, "applicationData-applicant.ARN");
		if(haveARN.equalsIgnoreCase("YES"))
		{
			arNumber.setAlienRegistrationNumber(data.getProperty("ARN"));
		}
		else 
		{
			arNumber.setNumberUnknown();
			
			MultiRadioOptions reasons=new MultiRadioOptions(driver, "applicationData-applicant.whyUnableToGetARN");
			if(noARNreason.equalsIgnoreCase("cardlost"))
			{
				reasons.selectOption(1);
			}
			else if(noARNreason.equalsIgnoreCase("cardDamaged"))
			{
				reasons.selectOption(2);
			}
			else if(noARNreason.equalsIgnoreCase("cardNeverReceived"))
			{
				reasons.selectOption(3);
			}
			
		}
		saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}
}
