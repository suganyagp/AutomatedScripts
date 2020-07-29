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

public class TEAZ44Brokers_AddBroker extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Add New Broker";
		testCaseDescription = "Adding new Broker record and verifying whether it is added successfully";
		author = "Suganya";
		excelfile="TEAZ044Broker_AddBroker";
	}
	@Test(dataProvider = "getdata")
	public void AddBroker(String url,String uName, String Pwd,String name,String terr1,String terr2,String terr3) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickBrokers(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn();
		new AddBrokerpage(driver, eachNode).enterBrokername(name);
		new EditBrokerpage(driver, eachNode).enterterritories(terr1).enterterritories(terr2).enterterritories(terr3);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getNameBroker()
		.clickParentCompaniesTab().clickBrokers();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(name).clickSearchIcon().getSearchResults().clickDesireRecBroker()
		.verifyNameBroker(name);
}

}
