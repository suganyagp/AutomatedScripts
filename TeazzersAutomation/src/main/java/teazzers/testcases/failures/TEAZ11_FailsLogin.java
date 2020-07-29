package teazzers.testcases.failures;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;

public class TEAZ11_FailsLogin extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Login Failure";
		testCaseDescription = "Login testCase using invalid credentials";
		author = "Suganya";
		excelfile="TEAZ011_FailLogin";
	}
	@Test(dataProvider = "getdata")
	public void loginfn(String url,String uName, String Pwd) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickUsername().clickLogOut();
	}

}
