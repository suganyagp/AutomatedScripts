package teazzers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;
import teazzers.api.ProjSpecificMethods;
import teazzers.util.Timestamp;

public class AddNewParentCompanyPage extends ProjSpecificMethods {
	

	public AddNewParentCompanyPage(RemoteWebDriver driver,ExtentTest eachNode) {
		this.driver = driver;
		this.eachNode = eachNode;
	}
	
	public AddNewParentCompanyPage enterName(String name) {
		WebElement eleEntrName = locateElement("id",prop.getProperty("addnewparntcmpy.entrname.id"));
		clearAndType(eleEntrName, name);
		return this;
	}
	
	public AddNewParentCompanyPage enterTradename(String tradename) {
		WebElement eleTradName = locateElement("id",prop.getProperty("editparntcmpy.entrtradename.id"));
		clearAndType(eleTradName, tradename);
		return this;
		
	}
	
	public AddNewParentCompanyPage unCheckOwnerOperator() {
		WebElement eleUnChkOpr = locateElement("xpath",prop.getProperty("addnewparntcmpy.uncheckowner.xpath"));
		click(eleUnChkOpr);
		return this;
	}
	
	public EditParentCompanypage clickSaveBtn() {
		WebElement eleClkSave = locateElement("xpath",prop.getProperty("addnewparntcmpy.clksave.xpath"));
		click(eleClkSave);
		System.out.println("Record is created on "+Timestamp.format());
		return new EditParentCompanypage(driver,eachNode);
	}

}
