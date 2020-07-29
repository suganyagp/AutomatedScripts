package teazzers.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;
import teazzers.api.ProjSpecificMethods;

public class ManageDistributorspage extends ProjSpecificMethods {
	
	public ManageDistributorspage(RemoteWebDriver driver,ExtentTest eachNode) {
		this.driver=driver;
		this.eachNode = eachNode;
	}

}
