package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1_4 extends WizardPage {

	public SQ1_1_4(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_4 setParentName(Properties data) {

		Name_FirstMiddleLast parentName = new Name_FirstMiddleLast(driver,
				"applicationData", "applicant");
		parentName.setFatherNameField(data.getProperty("FatherName"));
		parentName.setMotherNameField(data.getProperty("MotherName"));

		saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}
}
