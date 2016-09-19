package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_3_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_3_3_1 extends WizardPage {

	private DateTag dateOfAdmission;

	public SQ1_3_3_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_3_3_1 setDateOfAdmission(Properties data, String visitThisPage) {
		
			if (visitThisPage.equalsIgnoreCase("yes")) {
				dateOfAdmission = new DateTag(driver, "formSpecific.immigrantAdmissionDate");
				dateOfAdmission.selectDate(data.getProperty("DOA"));
				saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
			}

		return this;
	}
}
