package teazzers.testcases.locations;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ13Location_VerifyGrid extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Verify Grid in Location Module";
		testCaseDescription = "Verifying the items on the page and navigating to first record";
		author = "Suganya";
		excelfile="TC001_Login";
	}
	@Test(dataProvider = "getdata")
	public void verifyGrid(String url,String uName, String Pwd) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickLocation();
		new ManageParentCompaniespage(driver,eachNode).getItemsCount().clickFirstRecInNameColumn();
	}

}
