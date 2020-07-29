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

public class TEAZ43Brokers_SearchbyFrequency extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Frequency in brokers Module";
		testCaseDescription = "Searching using frequency and getting the required records";
		author = "Suganya";
		excelfile="TEAZ043_Brokers_SearchFrequency";
	}
	@Test(dataProvider = "getdata")
	public void searchFrequency(String url,String uName, String Pwd,String name,String frequency) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickBrokers(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn();
		new AddBrokerpage(driver, eachNode).enterBrokername(name);
		new EditBrokerpage(driver, eachNode).selectfrequency(frequency);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getNameBroker()
		.clickParentCompaniesTab().clickBrokers();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(frequency).clickSearchIcon().getSearchResults().clickDesireRecBroker()
		.verifyNameBroker(name);
	}

}
