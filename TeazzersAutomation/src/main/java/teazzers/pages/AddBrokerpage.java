package teazzers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;
import teazzers.api.ProjSpecificMethods;

public class AddBrokerpage extends ProjSpecificMethods{
	
	public AddBrokerpage(RemoteWebDriver driver,ExtentTest eachNode) {
		this.driver = driver;
		this.eachNode = eachNode;
	}
	
	public AddBrokerpage enterBrokername(String name) {
			WebElement eleEntrName = locateElement("id",prop.getProperty("addbroker.entername.id"));
			clearAndType(eleEntrName, name);
			return this;
	}
	
	
	
	

}
