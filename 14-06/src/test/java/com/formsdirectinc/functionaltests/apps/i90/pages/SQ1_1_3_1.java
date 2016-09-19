package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_1_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1_3_1 extends WizardPage {

	private YesNo receiveNotifications;

	public SQ1_1_3_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_3_1 contactDetails(Properties data, String wishToReceiveEmailNotification) {
		
			PhoneNumber contactNumber = new PhoneNumber(driver,"applicationData-applicant.contactMethods");
			contactNumber.setDayTimeNumber(data.getProperty("Phone1"),data.getProperty("Phone2"));
			contactNumber.setEveningTimeNumber(data.getProperty("Phone1"),data.getProperty("Phone2"));
		
			receiveNotifications = new YesNo(driver,"formSpecific.wishToReceiveEmailNotification");
			receiveNotifications.setYesOrNo(wishToReceiveEmailNotification);

			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}
}
