package teazzers.testcases.contacts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ55Contacts_SearchbyLastName extends ProjSpecificMethods {
	
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Last Name in Contacts Module";
		testCaseDescription = "Searching using Last name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ055_Contacts_SearchLastName";
	}
	
	@Test(dataProvider = "getdata")
	public void searchLastName(String url,String uName, String Pwd,String searchname) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickContacts();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults();
	}

}
