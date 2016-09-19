package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_1_2 extends WizardPage {

	private MultiRadioOptions someOneAssistYou,preparerAnAttorney,attorneyExtendBeyond;

	public SQ5_1_2(WebDriver driver) {
		super(driver);
	}

	public SQ5_1_2 preparerInfo(String someOneAssisting,String isPreparerAnAttorney,String didAttorneyExtendBeyond) {

		if (someOneAssisting.equalsIgnoreCase("Yes")
				|| someOneAssisting.equalsIgnoreCase("No")) {

			someOneAssistYou = new MultiRadioOptions(driver,
					"applicationData-applicant.preparerInfo.someOneAssistYou");

			if (someOneAssisting.equalsIgnoreCase("no")) {
				someOneAssistYou.selectOption(1);
			}

			else if (someOneAssisting.equalsIgnoreCase("yes")) {
				someOneAssistYou.selectOption(2);
				
				preparerAnAttorney = new MultiRadioOptions(driver,
						"applicationData-applicant.preparerInfo.isPreparerAnAttorney");
				if(isPreparerAnAttorney.equalsIgnoreCase("yes"))
				{
					preparerAnAttorney.selectOption(1);
					
					attorneyExtendBeyond = new MultiRadioOptions(driver,
							"applicationData-applicant.preparerInfo.didAttorneyExtendBeyond");
					
					if(didAttorneyExtendBeyond.equalsIgnoreCase("yes"))
					{
						attorneyExtendBeyond.selectOption(1);
					}
					else if(didAttorneyExtendBeyond.equalsIgnoreCase("no"))
					{
						attorneyExtendBeyond.selectOption(2);
					}
					
				}
				else if(isPreparerAnAttorney.equalsIgnoreCase("no"))
				{
					preparerAnAttorney.selectOption(2);
				}
				
				Name_FirstMiddleLast preparerName=new Name_FirstMiddleLast(driver, "applicationData", 
															"applicant.preparerInfo.nameOfPreparer");
				preparerName.setFirstNameField("Orina");
				preparerName.setLastNameField("Moorthy");
				
				Address addressOfPreparer=new Address(driver);
				addressOfPreparer.setAddressWithoutCountry("i90", "applicant.preparerInfo.addressOfPreparer");
				
				PhoneNumber contactInfo=new PhoneNumber(driver, "applicationData-applicant.preparerInfo.daytimePhoneOfPreparer");
				contactInfo.setPhoneCode("123");
				contactInfo.setPhoneNumber("1234567");
				
			}

			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}
