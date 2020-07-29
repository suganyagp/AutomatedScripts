package teazzers.testcases.locations;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ22Location_SearchbyPrimaryDisturbutor extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Primary Disturbutor in Location module";
		testCaseDescription = "Searching using Primary Disturbutor and getting the required records";
		author = "Suganya";
		excelfile="TEAZ022_LocSearchPrimryDisturbtr";
	}
	@Test(dataProvider = "getdata")
	public void searchPrimaryDisturbutor(String url,String uName, String Pwd,String searchname) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickLocation(); 
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults();
	}

}
