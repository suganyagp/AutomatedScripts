package teazzers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import teazzers.api.ProjSpecificMethods;

public class AddServiceTechnicianpage extends ProjSpecificMethods {
	

	public AddServiceTechnicianpage(RemoteWebDriver driver,ExtentTest eachNode) {
		this.driver = driver;
		this.eachNode = eachNode;
	}
	
	public AddServiceTechnicianpage clickParent() {
		WebElement eleClikParnt = locateElement("xpath",prop.getProperty("addservtechn.clickparnt.xpath"));
		click(eleClikParnt);
		return this;
	}
	
	public AddServiceTechnicianpage enterSearch(String searchname) {
		WebElement eleSeacrhParnt = locateElement("xpath",prop.getProperty("addservtechn.entersearch.xpath"));
		clearAndType(eleSeacrhParnt, searchname);
		return this;
	}
	
	public AddServiceTechnicianpage clickSearchParnt() {
		WebElement eleClikSearch = locateElement("id",prop.getProperty("addservtechn.clicksearch.id"));
		click(eleClikSearch);
		return this;
	}

	public AddServiceTechnicianpage clickReqRadio(String searchname) {
		WebElement desrec = driver.findElement(By.xpath("//input[@data-name='"+searchname+"']"));
		desrec.click();
		return this;
	}
	
	

}
