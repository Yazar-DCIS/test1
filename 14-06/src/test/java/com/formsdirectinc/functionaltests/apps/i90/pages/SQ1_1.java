package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1 extends WizardPage {

	private Name_FirstMiddleLast nameTag;
	private Gender gender;

	public SQ1_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1 nameandgender(Properties data, String haveMiddleName,String genderIs) {

		nameTag = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.name");
		nameTag.setFirstNameField(data.getProperty("FirstName"));
		nameTag.setLastNameField(data.getProperty("LastName"));

		if(haveMiddleName.equalsIgnoreCase("Yes"))
		{
			nameTag.setMiddleNameField(data.getProperty("MiddleName"));
		}
		else
		{
			nameTag.setNoMiddleName();
		}
		
		gender = new Gender(driver, "applicationData-applicant.sex");
		gender.setGender(genderIs);
		

		saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}
}
