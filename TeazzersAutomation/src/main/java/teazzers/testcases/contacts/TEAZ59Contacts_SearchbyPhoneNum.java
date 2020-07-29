package teazzers.testcases.contacts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ59Contacts_SearchbyPhoneNum extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Phone Number in Contacts Module";
		testCaseDescription = "Searching using phone number and getting the required records";
		author = "Suganya";
		excelfile="TEAZ059_Contacts_SearchbyPhone";
	}
	@Test(dataProvider = "getdata")
	public void searchPhoneNum(String url,String uName, String Pwd,String searchname) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickContacts(); 
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults();
	}

}
