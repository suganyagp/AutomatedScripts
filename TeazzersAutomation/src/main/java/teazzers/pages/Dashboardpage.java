package teazzers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;
import teazzers.api.ProjSpecificMethods;

public class Dashboardpage extends ProjSpecificMethods {
	public Dashboardpage(RemoteWebDriver driver,ExtentTest eachNode) {
		this.driver=driver;	
		this.eachNode = eachNode;
		if (!verifyTitle("TeaWorld - Dashboard")) {
			reportStep("This is not Create Lead Page", "Fail");
		}
		}

		public Dashboardpage clickUsername() throws InterruptedException {
			Thread.sleep(2000);
			 WebElement eleUseName = locateElement("xpath",prop.getProperty("dashboard.clkusername.xpath"));
			click(eleUseName);
			return this;
		}
		
		public LoginPage clickLogOut() {
			 WebElement eleLogOut = locateElement("xpath",prop.getProperty("dashboard.clklogout.xpath"));
			click(eleLogOut);
			return new LoginPage(driver,eachNode);
		}
		
		public ManageParentCompaniespage clickPartners() {
			 WebElement eleLogOut = locateElement("xpath",prop.getProperty("dashboard.clkpartners.xpath"));
			click(eleLogOut);
			return new ManageParentCompaniespage(driver,eachNode);
		}
		
		public ManageTabletspage clickSmartBrew() {
			WebElement eleSmrtBrw = locateElement("xpath",prop.getProperty("dashboard.clksmartbrew.xpath"));
			click(eleSmrtBrw);
			return new ManageTabletspage(driver,eachNode);
		}
		
		public InstallationManagementpage clickInstall() {
			WebElement eleInstMgt = locateElement("xpath",prop.getProperty("dashboard.clkinstall.xpath"));
			click(eleInstMgt);
			return new InstallationManagementpage(driver,eachNode);
		}
		
}
