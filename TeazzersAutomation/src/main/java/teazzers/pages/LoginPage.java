package teazzers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;
import teazzers.api.ProjSpecificMethods;

public class LoginPage extends ProjSpecificMethods{
	public LoginPage(RemoteWebDriver driver,ExtentTest eachNode) {
		this.driver=driver;	
		this.eachNode = eachNode;
		
	}
	public LoginPage launchURL(String url) {
		driver.get(url);
		return this;
	}
	 public LoginPage enterUsername(String usrname) {
		 WebElement eleUserName = locateElement("id", prop.getProperty("login.username.id"));
			clearAndType(eleUserName, usrname);
			return this;
		 
	 }
	 public LoginPage enterPassword(String pwd) {
		 WebElement elePassword = locateElement("id", prop.getProperty("login.password.id"));
			clearAndType(elePassword, pwd);
			return this;
		 
	 }
	 public Dashboardpage clickLogin() {
		  
		 WebElement eleLogin = locateElement("xpath", prop.getProperty("login.loginbtn.xpath"));
			click(eleLogin);
			 return new Dashboardpage(driver,eachNode);
	 }

}
