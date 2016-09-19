package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_1_3 extends WizardPage {

	private Address birthPlace;
	private DateTag dateOfBirth;

	public SQ1_1_3(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_3 personalInfo(Properties data) {

		dateOfBirth = new DateTag(driver, "applicant.birth.dateOfBirth");
		dateOfBirth.selectDate(data.getProperty("DOB"));

		birthPlace = new Address(driver,"applicationData-applicant.birth");
		birthPlace.setCountryOffBirth(data.getProperty("DOB_Country"));
		birthPlace.setCityOfBirth(data.getProperty("DOB_Nation"));
		
		saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}
}
