package teazzers.testcases.contacts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ54Contacts_SearchbyFirstName extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by First Name in Contacts module";
		testCaseDescription = "Searching using first name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ054Contacts_SearchFirstName";
	}
	@Test(dataProvider = "getdata")
	public void searchFirstName(String url,String uName, String Pwd,String searchname) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickContacts(); 
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults();
	}

}
