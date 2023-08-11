package com.nopcommerce.libglobal;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nopcommerce.qa.webdriver_manager.DriverManager;

public class BaseClass {

	public static Properties prop;
	public static Properties dataProp;
	private	String parentWindow;
	public BaseClass() {
		prop= new Properties();
		try {
			File confFile =new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\nopcommerce\\qa\\config\\config.properties");
			FileInputStream conFis= new FileInputStream(confFile);
			prop.load(conFis);
		}catch (Exception e) {
			e.printStackTrace();
		}
		dataProp= new Properties();
		try {
			File file= new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\nopcommerce\\qa\\testdataconfig\\TestData.properties");
			FileInputStream testDataFis= new FileInputStream(file);
			dataProp.load(testDataFis);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean elementIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public void waitForElementVisibility(WebElement element) {
		WebDriverWait wb = new WebDriverWait(DriverManager.getDriver(), 10);
		wb.until(ExpectedConditions.visibilityOf(element));
	}

	public void isAlertIsPresent() {
		WebDriverWait wb = new WebDriverWait(DriverManager.getDriver(), 10);
		wb.until(ExpectedConditions.alertIsPresent());
	}

	public void clicksOnWebElement(WebElement element) {
		waitForElementVisibility(element);
		if(elementIsDisplayed(element)) {
			element.click(); 
		}
	}

	public void sendByTextValue(WebElement element, String text) {
		waitForElementVisibility(element);
		if(elementIsDisplayed(element)) {
			element.sendKeys(text);
		}
	}


	public void selectByIndex(WebElement element, int index) {
		waitForElementVisibility(element);
		if(elementIsDisplayed(element)) {
			element.click();
			Select select = new Select(element);
			select.selectByIndex(index);
		}
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		waitForElementVisibility(element);
		if(elementIsDisplayed(element)) {
			element.click();
			Select select = new Select(element);
			select.selectByVisibleText(visibleText);
		}
	}

	public void iterateSelectAllOptions(WebElement element) {
		waitForElementVisibility(element);
		if(elementIsDisplayed(element)) {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement webElement : options) {
				System.out.println(webElement);
			}	
		}
	}

	public String getTextFromTheElement(WebElement element) {
		waitForElementVisibility(element);
		return element.getText();
	}

	public String getAttributeValue(WebElement element,String attributeName) {
		waitForElementVisibility(element);
		return element.getAttribute(attributeName);
	}

	public void handle_Alert_Accept() {
		WebDriverWait wb = new WebDriverWait(DriverManager.getDriver(), 10);
		wb.until(ExpectedConditions.alertIsPresent()).accept();
	}
	public void handle_Alert_Dismiss() {
		WebDriverWait wb = new WebDriverWait(DriverManager.getDriver(), 10);
		wb.until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public void handle_Alert_Send_Values_Accept(String text) {
		WebDriverWait wb = new WebDriverWait(DriverManager.getDriver(), 10);
		Alert until = wb.until(ExpectedConditions.alertIsPresent());
		until.sendKeys(text);
		until.accept();
	}


	public void moveToElement_Mouse_cursor(WebElement element) {
		try {
			waitForElementVisibility(element);
			if(elementIsDisplayed(element)) {
				Actions action = new Actions(DriverManager.getDriver());
				action.moveToElement(element).build().perform();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	public void right_Click_On_Mouse_Action(WebElement element) {
		try {
			waitForElementVisibility(element);
			if(elementIsDisplayed(element)) {
				Actions action = new Actions(DriverManager.getDriver());
				action.contextClick(element).build().perform();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	public void action_send_keys_using_open_new_Tab(WebElement element) {
		try {
			Actions action = new Actions(DriverManager.getDriver());
			action.contextClick(element).build().perform();
			Robot robot= new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_DOWN);
			switch_To_New_Window();
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}


	public void switch_To_New_Window() {
		parentWindow = DriverManager.getDriver().getWindowHandle();
		Set<String> windowHandles = DriverManager.getDriver().getWindowHandles();
		for (String string : windowHandles) {
			if(!parentWindow.equals(string)) {
				DriverManager.getDriver().switchTo().window(string);	
			}
		}
	}
	public void retrieve_Parent_Window() {
		try {
			DriverManager.getDriver().switchTo().window(this.parentWindow);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	public void open_New_Tab_for_any_elemnent(WebElement element) {
		action_send_keys_using_open_new_Tab(element);
		switch_To_New_Window();
	}


	public void scroll_Down_Page_On_Element(WebElement element) {

		JavascriptExecutor js =(JavascriptExecutor)DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);	

	}
}



