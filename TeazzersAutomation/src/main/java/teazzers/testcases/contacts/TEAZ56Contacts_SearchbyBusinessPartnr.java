package teazzers.testcases.contacts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ56Contacts_SearchbyBusinessPartnr extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Business Partner in Contacts Module";
		testCaseDescription = "Searching using business partner and getting the required records";
		author = "Suganya";
		excelfile="TEAZ056Contacts_SearchBusinessPartnr";
	}
	@Test(dataProvider = "getdata")
	public void searchBusinessPartner(String url,String uName, String Pwd,String searchname) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickContacts(); 
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults();
	}

}
