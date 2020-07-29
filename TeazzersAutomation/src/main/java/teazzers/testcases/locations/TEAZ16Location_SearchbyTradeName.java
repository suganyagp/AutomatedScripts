package teazzers.testcases.locations;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ16Location_SearchbyTradeName extends ProjSpecificMethods {
	
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Trade Name in Location Module";
		testCaseDescription = "Searching using Trade name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ016_LocSearchTradename";
	}
	@Test(dataProvider = "getdata")
	public void searchTradeName(String url,String uName, String Pwd,String searchname) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickLocation(); 
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults();
	}

}
