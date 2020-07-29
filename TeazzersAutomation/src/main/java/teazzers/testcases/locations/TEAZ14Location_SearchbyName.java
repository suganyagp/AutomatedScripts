package teazzers.testcases.locations;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ14Location_SearchbyName extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Name in Location module";
		testCaseDescription = "Searching using name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ014_LocSearchName";
	}
	@Test(dataProvider = "getdata")
	public void locSearchName(String url,String uName, String Pwd,String searchname) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickLocation();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults();
	}

}
