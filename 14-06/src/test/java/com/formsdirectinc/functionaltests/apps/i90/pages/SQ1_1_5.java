package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.PhysicalTraits;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_1_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1_5 extends WizardPage {

	private MultiRadioOptions  hairColor, eyeColor;
	private YesNo hispanicLatino;
	private PhysicalTraits applicantHeight,applicantWeight;
	
	public SQ1_1_5(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_5 physicalTraits(Properties data, String race,
									int hairColour,int eyeColour,String hispanicorLatino) {

		applicantHeight = new PhysicalTraits(driver, "applicationData",
				"applicant.height");
		applicantHeight.selectHeightinFeet_i90(data.getProperty("Feet"));
		applicantHeight.selectHeightinInches_i90(data.getProperty("Inches"));

		applicantWeight=new PhysicalTraits(driver,  "applicationData",
				"applicationData-applicant.weight");
		applicantWeight.setWeightinPounds(data.getProperty("Weight"));
		
		// What is your race?
		PhysicalTraits setRace=new PhysicalTraits(driver);
		setRace.setRaceOptions("applicant", race);
	
		hairColor = new MultiRadioOptions(driver,
				"applicationData-applicant.hairColor");
		hairColor.selectOption(hairColour);

		eyeColor = new MultiRadioOptions(driver,
				"applicationData-applicant.eyeColor");
		eyeColor.selectOption(eyeColour);

		hispanicLatino = new YesNo(driver, "applicant.hispanicorLatino");
		hispanicLatino.yes();

		saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}
}
