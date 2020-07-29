package teazzers.testcases.parentcompanies;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;

public class LoginTC001 extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Login and LoginOut";
		testCaseDescription = "Login testCase using valid credentials and LogOut";
		author = "Suganya";
		excelfile="TC001_Login";
	}
	@Test(dataProvider = "getdata")
	public void loginfn(String url,String uName, String Pwd) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickUsername().clickLogOut();
	}

}
