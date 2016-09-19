package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ3_1 extends WizardPage {

	private MultiRadioOptions cardStatus;
	
	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_1 applicationType(Properties data,String visitThisPage,String statusOfCard, 
			String birthDetails,String cardExpiration) {
		
		if (visitThisPage.equalsIgnoreCase("yes")) {
			
			cardStatus = new MultiRadioOptions(driver,"applicationData-formSpecific.cardStatus");
			
			if(statusOfCard.equalsIgnoreCase("expired"))
			{
				cardStatus.selectOption(1);
				DateTag expiryDate=new DateTag(driver, "formSpecific.whenGreenCardExpire");
				expiryDate.selectDate(data.getProperty("whenGreenCardExpire"+cardExpiration));
			}
			else if(statusOfCard.equalsIgnoreCase("lost"))
			{
				cardStatus.selectOption(2);
			}
			else if(statusOfCard.equalsIgnoreCase("neverReceived"))
			{
				cardStatus.selectOption(3);
			}
			else if(statusOfCard.equalsIgnoreCase("mutilated"))
			{
				cardStatus.selectOption(4);
			}
			else if(statusOfCard.equalsIgnoreCase("USCISerror"))
			{
				cardStatus.selectOption(5);
			}
			else if(statusOfCard.equalsIgnoreCase("nameChanged"))
			{
				cardStatus.selectOption(6);
				
				Name_FirstMiddleLast legallyChangedName=new Name_FirstMiddleLast(driver, "applicationData", 
						"formSpecific.nameAppearedOnGC");
				legallyChangedName.setFirstNameField(data.getProperty("FirstName"));
				legallyChangedName.setMiddleNameField(data.getProperty("MiddleName"));
				legallyChangedName.setLastNameField(data.getProperty("LastName"));
				
			}
			else if(statusOfCard.equalsIgnoreCase("newCard"))
			{
				cardStatus.selectOption(7);
				
				MultiRadioOptions birthInfo=new MultiRadioOptions(driver, "applicationData-formSpecific.birthDetails");
				
				if(birthDetails.equalsIgnoreCase("withinPast30days"))
				{
					birthInfo.selectOption(1);
				}
				else if(birthDetails.equalsIgnoreCase("moreThanPast30days"))
				{
					birthInfo.selectOption(2);
				}
				
				else if(birthDetails.equalsIgnoreCase("celebratingSoon"))
				{
					birthInfo.selectOption(3);
				}
				
				MultiRadioOptions cardExpiryInfo=new MultiRadioOptions(driver, "applicationData-formSpecific.existingGreenCardExpireDate");
				if(cardExpiration.equalsIgnoreCase("after16thBDay"))
				{
					cardExpiryInfo.selectOption(1);
				}
				else if(cardExpiration.equalsIgnoreCase("before16thBDay"))
				{
					cardExpiryInfo.selectOption(2);
				}
			}
			else if(statusOfCard.equalsIgnoreCase("commuterStatus"))
			{
				cardStatus.selectOption(8);
				
				SelectElement commutorCity=new SelectElement(driver,
						"applicationData-formSpecific.commuterPortOfEntry-portOfEntry");
				
				commutorCity.selectValueFromDropDownUsingElementID(data.getProperty(
						"formSpecific.commuterPortOfEntry-portOfEntry"));
				if(data.getProperty("formSpecific.commuterPortOfEntry-portOfEntry").equalsIgnoreCase("Other"))
				{
					SelectElement commutorOtherCity=new SelectElement(driver,
							"applicationData-formSpecific.commuterPortOfEntry-portOfEntryTextBox");
					
					commutorOtherCity.selectValueFromDropDownUsingElementID(data.getProperty(
							"formSpecific.commuterPortOfEntry-portOfEntryTextBox"));
				}
				
			}
			else if(statusOfCard.equalsIgnoreCase("takingActualResidence"))
			{
				cardStatus.selectOption(9);
			}
			else if(statusOfCard.equalsIgnoreCase("replaceCard"))
			{
				cardStatus.selectOption(10);
			}
			else if(statusOfCard.equalsIgnoreCase("specialCategory"))
			{
				cardStatus.selectOption(11);
			}
			else if(statusOfCard.equalsIgnoreCase("none"))
			{
				cardStatus.selectOption(12);
			}
			saveScreenShot("i90", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}
