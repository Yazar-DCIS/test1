package com.formsdirectinc.functionaltests.apps.i90;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1_2_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1_3;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1_3_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1_4;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1_5;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_2_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_2_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_3;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_3_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_3_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_3_3;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_3_3_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_3_4;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_4;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ3_1_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ3_1_3;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ4_3;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ5_1_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ5_1_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ5_2;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product I90 SimpleQuestions
 */
public class SimpleQuestions  extends Step {
	

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	String appName = Products.I90.name();

	public void test(String product, String flowname)
			throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i90Sheet = "I90";
		readFromExcelSheet.initializeWorkbook(i90Sheet);
		Integer fieldContent = readFromExcelSheet
				.getRowNumberUsingContent(flowname);

		PropertyResource propertyFile=new PropertyResource();
		Properties i90data = propertyFile.loadProperty("name");
		Sites site = Sites.valueOf(System.getProperty("site.name"));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();
		
		
		// SQ Section :

		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.nameandgender(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 5),
				readFromExcelSheet.getCellStringContent(fieldContent, 6));

		SQ1_1_2 sq1_1_2 = PageFactory.initElements(driver, SQ1_1_2.class);
		sq1_1_2.setAddressFields(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 7),
				readFromExcelSheet.getCellStringContent(fieldContent, 8));

		SQ1_1_2_1 sq1_1_2_1 = PageFactory.initElements(driver, SQ1_1_2_1.class);
		sq1_1_2_1.postalAddress(readFromExcelSheet.getCellStringContent(fieldContent, 9));

		SQ1_1_3 sq1_1_3 = PageFactory.initElements(driver, SQ1_1_3.class);
		sq1_1_3.personalInfo(i90data);

		SQ1_1_3_1 sq1_1_3_1 = PageFactory.initElements(driver, SQ1_1_3_1.class);
		sq1_1_3_1.contactDetails(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 10));

		SQ1_1_4 sq1_1_4 = PageFactory.initElements(driver, SQ1_1_4.class);
		sq1_1_4.setParentName(i90data);

		SQ1_1_5 sq1_1_5 = PageFactory.initElements(driver, SQ1_1_5.class);
		sq1_1_5.physicalTraits(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 11),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 12),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 13),
				readFromExcelSheet.getCellStringContent(fieldContent, 14));

		SQ1_2_1 sq1_2_1 = PageFactory.initElements(driver, SQ1_2_1.class);
		sq1_2_1.haveARN(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 15),
				readFromExcelSheet.getCellStringContent(fieldContent, 16));

		SQ1_2_2 sq1_2_2 = PageFactory.initElements(driver, SQ1_2_2.class);
		sq1_2_2.haveSSN(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 17));

		SQ1_3 sq1_3 = PageFactory.initElements(driver, SQ1_3.class);
		sq1_3.originApplication(
				readFromExcelSheet.getCellStringContent(fieldContent, 18),
				readFromExcelSheet.getCellStringContent(fieldContent, 19));

		SQ1_3_1 sq1_3_1 = PageFactory.initElements(driver, SQ1_3_1.class);
		sq1_3_1.immigrantVisaInfo(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 20));

		SQ1_3_2 sq1_3_2 = PageFactory.initElements(driver, SQ1_3_2.class);
		sq1_3_2.adjustmentOfStatusInfo(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 21));

		SQ1_3_3 sq1_3_3 = PageFactory.initElements(driver, SQ1_3_3.class);
		sq1_3_3.setDateOfAdmission(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 22));

		SQ1_3_3_1 sq1_3_3_1 = PageFactory.initElements(driver, SQ1_3_3_1.class);
		sq1_3_3_1.setDateOfAdmission(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 23));

		SQ1_3_4 sq1_3_4 = PageFactory.initElements(driver, SQ1_3_4.class);
		sq1_3_4.classOfAdmission(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 24));

		SQ1_4 sq1_4 = PageFactory.initElements(driver, SQ1_4.class);
		sq1_4.setPlaceOfEntry(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 25));

		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.yourStatus(
				readFromExcelSheet.getCellStringContent(fieldContent, 26),
				readFromExcelSheet.getCellStringContent(fieldContent, 27));

		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.applicationType(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 28),
				readFromExcelSheet.getCellStringContent(fieldContent, 29),
				readFromExcelSheet.getCellStringContent(fieldContent, 30),
				readFromExcelSheet.getCellStringContent(fieldContent, 31));

		SQ3_1_2 sq3_1_2 = PageFactory.initElements(driver, SQ3_1_2.class);
		sq3_1_2.applicationType(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 32));
		
		SQ3_1_3 sq3_1_3 = PageFactory.initElements(driver, SQ3_1_3.class);
		sq3_1_3.waitToFileApplication(readFromExcelSheet.getCellStringContent(fieldContent, 33));

		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.nameChange(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 34));

		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.proceedings(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 35));

		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.abondonment(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 36));

		SQ4_3 sq4_3 = PageFactory.initElements(driver, SQ4_3.class);
		sq4_3.accommodations(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 37),
				readFromExcelSheet.getCellStringContent(fieldContent, 38));

		SQ5_1_1 sq5_1_1 = PageFactory.initElements(driver, SQ5_1_1.class);
		sq5_1_1.interpreterInfo(readFromExcelSheet.getCellStringContent(fieldContent, 39));

		SQ5_1_2 sq5_1_2 = PageFactory.initElements(driver, SQ5_1_2.class);
		sq5_1_2.preparerInfo(readFromExcelSheet.getCellStringContent(fieldContent, 40),
				readFromExcelSheet.getCellStringContent(fieldContent, 41),
				readFromExcelSheet.getCellStringContent(fieldContent, 42));

		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.agreeToSubmit(readFromExcelSheet.getCellStringContent(fieldContent, 43));
		
		if(site==Sites.FR)
		{
			SQ5_2 sq5_2 = PageFactory.initElements(driver, SQ5_2.class);
			sq5_2.applicantCertification();
		}
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}
		readFromExcelSheet.closeWorkbook();

	}

}
