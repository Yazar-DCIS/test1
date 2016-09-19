package com.formsdirectinc.functionaltests.newtags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.tags.SelectElement;

/**
 * Wizard: Base class for all wizard pages
 *@author Orina
 * Revision: $Rev$
 */
public class WizardPage {
	
	protected WebDriver driver;

	public WizardPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public WizardPage clickContinueInSQ() {
		//
		// TODO: currently to ALL SQ
		//
		SelectElement continueButton = new SelectElement(driver,
				"//button[contains(text(),'Next')]");
		continueButton.selectElementUsingXPath();

		return PageFactory.initElements(driver, WizardPage.class);
	}

	public WizardPage clickContinueInEQ() {
		//
		// TODO: currently to ALL EQ
		//
		SelectElement continueButton = new SelectElement(driver,
				"span[class='button-text']");
		continueButton.selectElementUsingCSS();

		return PageFactory.initElements(driver, WizardPage.class);
	}

	public String questionTitle(WebElement questionTitle) {
		
		WebElement questionTitleLabel = questionTitle.findElement(By.className("Question-title"));
		
		String actualquestionTitleLabel=questionTitleLabel.getText();
		
		return actualquestionTitleLabel;
	}
	
	public String questionInstruction(WebElement questionInstruction) {
		
		WebElement questionInstructionLabel = questionInstruction.findElement(By.className("Question-instructions"));
		
		String actualquestionInstructionLabel=questionInstructionLabel.getText();
		
		return actualquestionInstructionLabel;
	}

	public String learnMore(WebElement learnMore,String learnMoreID) {
		
		WebElement learnMoreLabel = learnMore.findElement(By.className("LearnMoreLink"));
		
		Actions builder = new Actions(driver);
		Action mouseOver = builder.moveToElement(learnMoreLabel).build();
		mouseOver.perform();

		WebElement explainThisCopy = driver.findElement(By
				.cssSelector(("div[id='" + learnMoreID + "']")));
		String actualLearnMoreText = explainThisCopy.getText();
		
		return actualLearnMoreText;
	}

}
