package teazzers.testcases.brokers;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddBrokerpage;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditBrokerpage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ42Brokers_SearchbyChannel extends ProjSpecificMethods {
	
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Channel in brokers Module";
		testCaseDescription = "Searching using channel and getting the required records";
		author = "Suganya";
		excelfile="TEAZ042_Brokers_SearchChannel";
	}
	
	@Test(dataProvider = "getdata")
	public void searchChannel(String url,String uName, String Pwd,String name,String channel,String phone) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickBrokers(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn();
		new AddBrokerpage(driver, eachNode).enterBrokername(name);
		new EditBrokerpage(driver, eachNode).selectChannel(channel);
		new EditParentCompanypage(driver, eachNode).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getNameBroker()
		.clickParentCompaniesTab().clickBrokers();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(channel).clickSearchIcon().getSearchResults().clickDesireRecBroker()
		.verifyNameBroker(name);
	}

}
