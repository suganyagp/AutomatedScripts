package teazzers.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;
import teazzers.api.ProjSpecificMethods;

public class InstallationManagementpage extends ProjSpecificMethods {
	public InstallationManagementpage(RemoteWebDriver driver,ExtentTest eachNode) {
		this.driver=driver;	
		this.eachNode = eachNode;

}}
