package teazzers.selenium.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import teazzers.configuration.Config;
import teazzers.util.Reporter;


public class SeleniumBase extends Reporter  {

	public RemoteWebDriver driver;
	public static Properties prop;
	
	public void loadObjects() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(Config.getProperty("object_values"))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void unloadObjects() {
		prop = null;
	}
	
	


	public void startApp() {
		try {
			System.setProperty("webdriver.chrome.driver",Config.getProperty("driverpath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			reportStep("The browser: Chrome launched successfully", "PASS");
		} catch (WebDriverException e) {			
			reportStep("The browser: Chrome could not be launched", "FAIL");
		}
	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			case "id"	 : return driver.findElementById(locValue);
			case "class" : return driver.findElementByClassName(locValue);
			case "name" : return driver.findElementByName(locValue);
			case "link" : return driver.findElementByLinkText(locValue);
			case "partialLink" : return driver.findElementByPartialLinkText(locValue);
			case "tagname" : return driver.findElementByTagName(locValue);
			case "xpath" : return driver.findElementByXPath(locValue);
			case "cssSelect" : return driver.findElementByCssSelector(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "FAIL");
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}


	public List<WebElement> locateElements(String type, String locValue) {
		try {
			switch(type) {
			case "id"	 : return driver.findElementsById(locValue);
			case "class" : return driver.findElementsByClassName(locValue);
			case "name" : return driver.findElementsByName(locValue);
			case "link" : return driver.findElementsByLinkText(locValue);
			case "partialLink" : return driver.findElementsByPartialLinkText(locValue);
			case "tagname" : return driver.findElementsByTagName(locValue);
			case "xpath" : return driver.findElementsByXPath(locValue);
			case "cssSelect" : return driver.findElementsByCssSelector(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+type+" not found.","FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+type+" with the value "+locValue, "FAIL");
		}
		return null;
	}

	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data: "+data+" entered successfully in the field", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field:"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}
	}
	
	public void type(WebElement ele, String data) throws InterruptedException{
		try {
			ele.sendKeys(data);
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);
			reportStep("The data: "+data+" entered successfully in the field", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field:"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}
	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			ele.click();			
			reportStep("The element :"+text+"  is clicked.", "PASS", false);
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "FAIL", false);
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :","FAIL", false);
		} 
	}


	public void click(WebElement ele) {
		String text = "";
		try {			
			ele.click();
			reportStep("The element "+text+" is clicked", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		} 
	}

	public String getTitle() {		
		String bReturn = "";
		try {
			bReturn =  driver.getTitle();
		} catch (WebDriverException e) {
			reportStep("Unknown Exception Occured While fetching Title", "FAIL");
		} 
		return bReturn;
	}


	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			reportStep("The dropdown is selected with text "+value,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			reportStep("The dropdown is selected with index "+index,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		} 
	}


	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			new Select(ele).selectByValue(value);
			reportStep("The dropdown is selected with text "+value,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
	}

	public boolean verifyTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(title)) {
				reportStep("The title of the page matches with the value :"+title,"PASS");
				bReturn= true;
			}else {
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		} 
		return bReturn;
	}

	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".png"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

	public void closeBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed","PASS", false);
		} catch (Exception e) {
			reportStep("The browser could not be closed","FAIL", false);
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed","PASS", false);
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","FAIL", false);
		}
	}


	public void append(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			reportStep("The Data :"+data+" entered Successfully", "PASS");
		} catch (ElementNotInteractableException e) {
			reportStep("The Element "+ele+" is not Interactable", "FAIL");
		}		
	}


	public void clear(WebElement ele) {
		try {
			ele.clear();
			reportStep("The field is cleared Successfully", "PASS");
		} catch (ElementNotInteractableException e) {
			reportStep("The field is not Interactable", "FAIL");
		}		
	}


	public String getElementText(WebElement ele) {
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
		return bReturn;	
	}


	
		
		
					
			

}
					
				
			
			
		


