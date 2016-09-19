package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_4 extends WizardPage {

	private AdditionalInfoFields placeOfEntry, portOfEntry;

	public SQ1_4(WebDriver driver) {
		super(driver);
	}

	public SQ1_4 setPlaceOfEntry(Properties data, String visitThisPage) {
		
			if (visitThisPage.equalsIgnoreCase("yes")) {
				placeOfEntry = new AdditionalInfoFields(driver,"applicationData-formSpecific.desitinationCity");
				placeOfEntry.textDDM(data.getProperty("PlaceOfEntry"));
				
				portOfEntry = new AdditionalInfoFields(driver,"applicationData-formSpecific.portOfEntry.name");
				portOfEntry.textDDM(data.getProperty("PortOfEntry"));

				saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}
