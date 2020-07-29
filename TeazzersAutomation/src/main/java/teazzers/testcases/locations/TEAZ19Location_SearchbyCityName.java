package teazzers.testcases.locations;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ19Location_SearchbyCityName extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by City in Location Module";
		testCaseDescription = "Searching using  city name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ019_LocSearchCity";
	}
	@Test(dataProvider = "getdata")
	public void searchCityName(String url,String uName, String Pwd,String searchname) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickLocation(); 
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults();
	}

}
