package com.formsdirectinc.functionaltests.apps;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;

public class ElementLocator {
	static Properties property;

	public ElementLocator(String mapFile) {
		property = new Properties();
	
	try {
		
		FileInputStream Master = new FileInputStream("src/test/resources/Properties/"+mapFile+".properties");
		property.load(Master);
		
		Master.close();
	} catch (IOException e) {
		
		System.out.println(e.getMessage());
	}
	}

	public By getLocator(String ElementName) {
	
		String locator = property.getProperty(ElementName);

		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		System.out.println(locatorValue);

		if (locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if (locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return By.className(locatorValue);
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return By.tagName(locatorValue);
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return By.linkText(locatorValue);
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return By.cssSelector(locatorValue);
		else if (locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else
			try {
				
				throw new Exception("Cannot find elements when the selector is null" + locatorType
						+ "' not defined!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.FIELD, ElementType.TYPE})
	public @interface FindBy {
	  How how() default How.UNSET;
	  	  
	  
	  String using() default "";  
	  
	  String id() default "";

	  String name() default "";

	  String className() default "";

	  String css() default "";

	  String tagName() default "";

	  String linkText() default "";

	  String partialLinkText() default "";

	  String xpath() default "";
	  
	  

		
		
		

	  
	}
	
	
}
