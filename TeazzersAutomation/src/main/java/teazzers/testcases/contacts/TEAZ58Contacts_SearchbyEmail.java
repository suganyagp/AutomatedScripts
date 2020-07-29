package teazzers.testcases.contacts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ58Contacts_SearchbyEmail extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by mail id in Contacts module";
		testCaseDescription = "Searching using mail id and getting the required records";
		author = "Suganya";
		excelfile="TEAZ058Contacts_SearchMail";
	}
	@Test(dataProvider = "getdata")
	public void searchEmail(String url,String uName, String Pwd,String searchname) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickContacts(); 
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults();
	}

}
