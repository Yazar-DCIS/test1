package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.Interpreter;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_1_1 extends WizardPage {

	private MultiRadioOptions knowEnglish;

	public SQ5_1_1(WebDriver driver) {
		super(driver);
	}

	public SQ5_1_1 interpreterInfo(String haveIntrepretor) {

		if (haveIntrepretor.equalsIgnoreCase("Yes")
				|| haveIntrepretor.equalsIgnoreCase("No")) {

			knowEnglish = new MultiRadioOptions(driver,
					"applicationData-applicant.certification.readAndUnderstandEnglish");

			if (haveIntrepretor.equalsIgnoreCase("no")) {
				knowEnglish.selectOption(1);
			}

			else if (haveIntrepretor.equalsIgnoreCase("yes")) {
				
				knowEnglish.selectOption(2);
				
				Interpreter interpretorInfo=new Interpreter(driver, "applicationData-applicant.certification");
				interpretorInfo.setLanguageOfInterpreter("Hindi");
				interpretorInfo.setBusinessNameOfInterpreter("dcis");
				
				Name_FirstMiddleLast interpretorName=new Name_FirstMiddleLast(driver, 
												"applicationData", "applicant.certification.nameOfinterpreter");
				interpretorName.setFirstNameField("Orina");
				interpretorName.setLastNameField("Moorthy");
				
				Address addressOfInterpretor=new Address(driver);
				addressOfInterpretor.setAddressWithoutCountry("i90", "applicant.certification.mailingAddressOfInterpreter");
				
				PhoneNumber contactInfo=new PhoneNumber(driver, "applicationData-applicant.certification.phoneOfInterpreter");
				contactInfo.setPhoneCode("123");
				contactInfo.setPhoneNumber("1234567");
				
			}

			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}
