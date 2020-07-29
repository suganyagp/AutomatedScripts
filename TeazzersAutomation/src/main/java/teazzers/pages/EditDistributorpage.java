package teazzers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;
import teazzers.api.ProjSpecificMethods;

public class EditDistributorpage extends ProjSpecificMethods {
	
	public EditDistributorpage(RemoteWebDriver driver,ExtentTest eachNode) {
		this.driver=driver;
		this.eachNode = eachNode;
	}
	
	public EditDistributorpage enterVendorNum(String vendorno) {
		WebElement eleVendornum = locateElement("id",prop.getProperty("editdistributor.entervendornum.id"));
		clearAndType(eleVendornum, vendorno);
		return this;
	}
	
	public EditDistributorpage clickParentName() {
		WebElement eleParentName = locateElement("id",prop.getProperty("editdistributor.clickparent.id"));
		click(eleParentName);
		return this;
	}
	
	public EditDistributorpage enterParentname(String parentname) {
		WebElement eleEnterParent = locateElement("id",prop.getProperty("editdistributor.enterparent.id"));
		clearAndType(eleEnterParent, parentname);
		return this;
	}
	
	public EditDistributorpage clickSearchParnticon() throws InterruptedException {
		WebElement eleSearchicon = locateElement("id",prop.getProperty("editdistributor.clicksearchicon.id"));
		click(eleSearchicon);
		Thread.sleep(1000);
		 return this;
	}
	
	public EditDistributorpage clickfirstParentrec() {
		WebElement eleClickFstRec = locateElement("xpath",prop.getProperty("editdistributor.clickfirsrec.xpath"));
		click(eleClickFstRec);
		return this;
	}
	
	public EditDistributorpage clickAdressTab() {
		WebElement eleClickAddress = locateElement("xpath",prop.getProperty("editdistributor.clickAdresstab.xpath"));
		click(eleClickAddress);
		 return this;
	}
	
}
