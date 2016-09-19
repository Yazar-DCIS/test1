package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_1_2 extends WizardPage {

	private Address addressFields;
	private YesNo mailAddress;
	private AdditionalInfoFields careOfNameText;
	private MultiRadioOptions careOfNameFR;

	public SQ1_1_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_2 setAddressFields(Properties data, String sameAsMailingAddress,String hasInCareOfAgent) {

		addressFields = new Address(driver,
				"applicationData-formSpecific.residenceAddress");
		addressFields.setStreetName(data.getProperty("StreetName"));
		addressFields.setCity(data.getProperty("City"));
		addressFields.setState(data.getProperty("State"));
		addressFields.setZipcode(data.getProperty("Zipcode"));

		mailAddress = new YesNo(driver, "formSpecific.sameAsMailingAddress");

		if (sameAsMailingAddress.equalsIgnoreCase("yes")) {
			mailAddress.yes();
		}

		else if (sameAsMailingAddress.equalsIgnoreCase("no")) {
			mailAddress.no();
			addressFields = new Address(driver,
					"applicationData-applicant.homeAddressInCareOf");

			addressFields.setStreetName(data.getProperty("StreetName"));
			addressFields.setCity(data.getProperty("City"));
			addressFields.setState(data.getProperty("State"));
			addressFields.setZipcode(data.getProperty("Zipcode"));
		}

		careOfNameFR = new MultiRadioOptions(driver,
				"applicationData-formSpecific.residenceAddress.hasInCareOfAgent");

		if (hasInCareOfAgent.equalsIgnoreCase("no")) {
			careOfNameFR.selectOption(1);

		}

		else if (hasInCareOfAgent.equalsIgnoreCase("yes")) {
			careOfNameFR.selectOption(2);
			careOfNameText = new AdditionalInfoFields(driver,

			"applicationData-formSpecific.residenceAddress.inCareOfAgentName");
			careOfNameText.isStatusOther(data.getProperty("Mail_CareOf"));
		}

		saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}
