package teazzers.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;
import teazzers.api.ProjSpecificMethods;

public class EditBrokerpage extends ProjSpecificMethods{
	
	public EditBrokerpage(RemoteWebDriver driver,ExtentTest eachNode) {
		this.driver = driver;
		this.eachNode = eachNode;
	}
	
	public EditBrokerpage enterterritories(String val) throws InterruptedException {
		WebElement eleclickterr=locateElement("xpath", prop.getProperty("editbroker.selectterritories.xpath"));
		type(eleclickterr, val);
		return this;
		
	}
	
	public EditBrokerpage selectfrequency(String value) {
		WebElement eleSelFrequency = locateElement("id",prop.getProperty("editbroker.selectfrequency.id"));
		selectDropDownUsingText(eleSelFrequency, value);
		return this;
	}
	
	public EditBrokerpage selectChannel(String channel) {
		WebElement eleSelFrequency = locateElement("id",prop.getProperty("editbroker.selectchannel.id"));
		selectDropDownUsingText(eleSelFrequency, channel);
		return this;
	}
	
	public EditBrokerpage clickAddress() {
		WebElement eleClickAddress = locateElement("xpath",prop.getProperty("editbroker.clickaddr.xpath"));
		click(eleClickAddress);
		return this;
	}
	
	
	

}
