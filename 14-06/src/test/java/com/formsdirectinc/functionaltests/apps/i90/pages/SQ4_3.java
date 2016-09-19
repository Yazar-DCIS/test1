package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DisabilitiesInfo;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ4_3 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_3 extends WizardPage {

	
	public SQ4_3(WebDriver driver) {
		super(driver);
	}

	public SQ4_3 accommodations(Properties data, String haveDisabilityOrImpairment,	String disability) {
		
		YesNo disabilityOrImpairment = new YesNo(driver,"formSpecific.disabilityOrImpairment");

			if (haveDisabilityOrImpairment.equalsIgnoreCase("no")) {
				disabilityOrImpairment.no();
			}

			if (haveDisabilityOrImpairment.equalsIgnoreCase("yes")) {
				disabilityOrImpairment.yes();

				MultiRadioOptions disabilityOptions = new MultiRadioOptions(driver,"applicationData-formSpecific.disabilityList");
				
				DisabilitiesInfo accomodate=new DisabilitiesInfo(driver, "applicationData-formSpecific");

					if (disability.equalsIgnoreCase("deaf")) {
					
						disabilityOptions.selectOption(1);
						accomodate.setHearingImpairedAccomodation(data.getProperty("hearingImpaired"));
					}

					else if (disability.equalsIgnoreCase("blind")) {
						disabilityOptions.selectOption(2);
						accomodate.setSightDisabilityAccomodation(data.getProperty("sightDisability"));
					}

					else if (disability.equalsIgnoreCase("other")) {
						disabilityOptions.selectOption(3);
						accomodate.setOtherDisabilityAccomodation(data.getProperty("otherDisability"));
					}
				}
			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}
}
