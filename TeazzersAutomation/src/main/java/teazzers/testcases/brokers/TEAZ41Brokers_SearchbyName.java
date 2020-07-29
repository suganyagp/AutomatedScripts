package teazzers.testcases.brokers;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddBrokerpage;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ41Brokers_SearchbyName extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Name in Brokers module";
		testCaseDescription = "Searching using name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ041Brokers_SearchName";
	}
	@Test(dataProvider = "getdata")
	public void searchName(String url,String uName, String Pwd,String name,String phone) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickBrokers(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn();
		new AddBrokerpage(driver, eachNode).enterBrokername(name);
		new EditParentCompanypage(driver, eachNode).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getNameBroker()
		.clickParentCompaniesTab().clickBrokers();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(name).clickSearchIcon().getSearchResults().clickDesireRecBroker()
		.verifyNameBroker(name);
	}

}
