package com.formsdirectinc.functionaltests.newtags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.formsdirectinc.functionaltests.tags.BaseTag;


/**
 * Address_Tag: Selenium page model for Address_Tag Address Details
 * 
 * @author:Orina<br> Revision: $Rev$
 */
public class Address extends BaseTag {

	protected String streetExpression = "%s-street";
	protected String streetNameExpression = "%s-streetName";
	protected String stateTextExpression = "%s.state-statetext";
	protected String countyExpression = "%s-county";
	protected String aptNumExpression = "%s-apartmentNum";
	protected String secondaryUnitExpression="%s-secondaryUnitType";
	protected String cityExpression = "%s-city";
	protected String cityEnteredExpression = "%s.cityEntered";
	protected String cityVisaExpression = "%s.city";
	protected String cityOfBirthExpression = "%s.cityOfBirth";
	protected String stateExp765 = "%s-state";
	protected String stateExpression = "%s.state-state";
	protected String zipcodeExpression = "%s-zipCode";
	protected String countryExpression = "%s-country";
	protected String countryLabelExpression = "%s-label";
	protected String careOfExpression = "%s-careof";
	protected String stateExp = "%s-state";
	protected String placeOfEntryCity = "%s.cityOfLastEntry";
	protected String placeOfEntryState = "%s.stateOfLastEntry-state";
	protected String placeOfEntryManner = "%s.mannerOfLastEntry";
	protected WebElement streetTextField;
	protected WebElement countyTextField;
	protected WebElement streetNameTextField;
	protected WebElement aptNumTextField;
	protected WebElement cityTextField;
	protected WebElement cityVisaField;
	protected WebElement cityOfBirthField;
	protected WebElement cityEnteredField;
	protected WebElement stateTextBoxField;
	protected WebElement stateTextField;
	protected WebElement zipcodeTextField;
	protected WebElement countryTextField;
	protected WebElement careOfTextField;
	protected WebElement countryDropDownField;

	
	String questionTitleFieldExpression = "New_Address_US-%s";
	WizardPage checkQuestions=new WizardPage(driver);
	
	public Address(WebDriver driver, String property) {
		super(driver, property);

	}
	
	public String checkQuestionTitleLabel() {
		
		WebElement questionTitle = driver.findElement(By.id(String.format(
				questionTitleFieldExpression, property)));
		
		checkQuestions.questionTitle(questionTitle);
			
		return checkQuestions.questionTitle(questionTitle);
	}

	public String checkQuestionInstructionLabel() {
		
		WebElement questionInstruction = driver.findElement(By.id(String.format(
				questionTitleFieldExpression, property)));
		
		checkQuestions.questionInstruction(questionInstruction);
		
		return checkQuestions.questionInstruction(questionInstruction);
	}
	
	public String checkLearnMoreLabel(String learnMoreID) {
		
		WebElement learnMore = driver.findElement(By.id(String.format(
				questionTitleFieldExpression, property)));
		
		checkQuestions.learnMore(learnMore, learnMoreID);
		
		return checkQuestions.learnMore(learnMore, learnMoreID);
	}


	public String checkStreetNameLabel() {
		WebElement streetNameLabel = driver.findElement(By.className(String.format(
				streetNameExpression, property)));
		String actualStreetNameLabel=streetNameLabel.getText();
		return actualStreetNameLabel;
	}

	public Address setStreetName(String street) {
		streetNameTextField = driver.findElement(By.id(String.format(
				streetNameExpression, property)));
		streetNameTextField.clear();
		streetNameTextField.sendKeys(street);
		return this;
	}
	
	public String checkStreetLabel() {
		WebElement streetNameLabel = driver.findElement(By.className(String.format(
				streetExpression, property)));
		String actualStreetNameLabel=streetNameLabel.getText();
		return actualStreetNameLabel;
	}
	
	public Address setStreet(String street) {
		streetTextField = driver.findElement(By.id(String.format(
				streetExpression, property)));
		streetTextField.clear();
		streetTextField.sendKeys(street);
		return this;
	}

	public String checkApartmentTypeLabel() {
		WebElement aptNameLabel = driver.findElement(By.className(String.format(
				secondaryUnitExpression, property)));
		String actualAptNameLabel=aptNameLabel.getText();
		return actualAptNameLabel;
	}
	
	public Address setAptNum(String aptNum) {
		aptNumTextField = driver.findElement(By.id(String.format(
				aptNumExpression, property)));
		aptNumTextField.clear();
		aptNumTextField.sendKeys(aptNum);
		return this;
	}
	
	public String checkCityLabel() {
		WebElement cityNameLabel = driver.findElement(By.className(String.format(
				cityExpression, property)));
		String actualcityNameLabel=cityNameLabel.getText();
		return actualcityNameLabel;
	}
	
	public Address setCity(String city) {
		cityTextField = driver.findElement(By.id(String.format(cityExpression,
				property)));
		cityTextField.clear();
		cityTextField.sendKeys(city);
		return this;
	}
	
	public String checkStateLabel() {
		WebElement stateNameLabel = driver.findElement(By.className(String.format(
				stateExpression, property)));
		String actualstateNameLabel=stateNameLabel.getText();
		return actualstateNameLabel;
	}
	public Address setState(String state) {
		stateTextField = driver.findElement(By.id(String.format(
				stateExpression, property)));
		Select stateSelect = new Select(stateTextField);
		stateSelect.selectByValue(state);
		return this;
	}
	
	public String checkZipcodeLabel() {
		WebElement zipcodeLabel = driver.findElement(By.className(String.format(
				zipcodeExpression, property)));
		String actualzipcodeLabel=zipcodeLabel.getText();
		return actualzipcodeLabel;
	}
	
	public Address setZipcode(String zipcode) {
		zipcodeTextField = driver.findElement(By.id(String.format(
				zipcodeExpression, property)));
		zipcodeTextField.clear();
		zipcodeTextField.sendKeys(zipcode);
		return this;
	}
	
	
	public String checkCountryLabel() {
		WebElement countryNameLabel = driver.findElement(By.className(String.format(
				countryExpression, property)));
		String actualcountryNameLabel=countryNameLabel.getText();
		return actualcountryNameLabel;
	}
	
	public Address setCountry(String country) {
		countryTextField = driver.findElement(By.id(String.format(
				countryExpression, property)));
		countryTextField.sendKeys(country);
		return this;
	}

	
	public Address setCounty(String county) {
		streetTextField = driver.findElement(By.id(String.format(
				countyExpression, property)));
		streetTextField.clear();
		streetTextField.sendKeys(county);
		return this;
	}


	public Address setCityOfBirth(String city) {
		cityOfBirthField = driver.findElement(By.id(String.format(
				cityOfBirthExpression, property)));
		cityOfBirthField.clear();
		cityOfBirthField.sendKeys(city);
		return this;
	}

	public Address setCityEntered(String city) {
		cityEnteredField = driver.findElement(By.id(String.format(
				cityEnteredExpression, property)));
		cityEnteredField.clear();
		cityEnteredField.sendKeys(city);
		return this;
	}

	public Address setVisaCity(String city) {
		cityVisaField = driver.findElement(By.id(String.format(
				cityVisaExpression, property)));
		cityVisaField.clear();
		cityVisaField.sendKeys(city);
		return this;
	}

	
	

	public Address setState765(String state) {
		stateTextField = driver.findElement(By.id(String.format(stateExp765,
				property)));
		stateTextField.clear();
		stateTextField.sendKeys(state);
		return this;
	}

	public Address setStateText(String state) {
		stateTextBoxField = driver.findElement(By.id(String.format(
				stateTextExpression, property)));
		stateTextBoxField.clear();
		stateTextBoxField.sendKeys(state);
		return this;
	}

	
	public Address setCountryDropDown(String country) {
		countryDropDownField = driver.findElement(By.id(String.format(
				countryExpression, property)));
		Select countryDropDownSelect = new Select(countryDropDownField);
		countryDropDownSelect.selectByValue(country);
		return this;

	}

	public Address setBirthState(String state) {
		stateTextField = driver.findElement(By.id(String.format(stateExp,
				property)));
		stateTextField.sendKeys(state);
		return this;
	}

	public Address setCityPlaceOfEntry(String city) {
		cityTextField = driver.findElement(By.id(String.format(
				placeOfEntryCity, property)));
		cityTextField.clear();
		cityTextField.sendKeys(city);
		return this;
	}

	public Address setStatePlaceOfEntry(String state) {
		stateTextField = driver.findElement(By.id(String.format(
				placeOfEntryState, property)));
		Select stateSelect = new Select(stateTextField);
		stateSelect.selectByValue(state);
		return this;
	}

	public Address setMannerPlaceOfEntry(String manner) {
		stateTextField = driver.findElement(By.id(String.format(
				placeOfEntryManner, property)));
		Select stateSelect = new Select(stateTextField);
		stateSelect.selectByValue(manner);
		return this;
	}

}