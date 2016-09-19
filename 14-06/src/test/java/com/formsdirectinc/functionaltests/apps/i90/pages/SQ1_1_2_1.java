package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_1_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_1_2_1 extends WizardPage {

	public SQ1_1_2_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_2_1 postalAddress(String addressVerification) {

		SelectElement address;

		Sites site = Sites.valueOf(System.getProperty("site.name"));

		if (site == Sites.FR) {
			address = new SelectElement(driver, "USE THIS ADDRESS");
		} else {
			address = new SelectElement(driver, "Use this Address");
		}

		if (addressVerification.equalsIgnoreCase("usePostalAddress")) {

			address.selectElementUsingLinkList(0);
		}

		else if (addressVerification.equalsIgnoreCase("useOriginalAddress")) {

			address.selectElementUsingLinkList(1);
		}

		return this;
	}
}
