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

public class TEAZ45Brokers_EditBroker extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Edit Broker Record";
		testCaseDescription = "Editing the Broker record and verifying the changes are updated";
		author = "Suganya";
		excelfile="TEAZ045Brokers_EditBroker";
	}
	@Test(dataProvider = "getdata")
	public void editBroker(String url,String uName, String Pwd, String name,String channel, String phone, String editname,String editchannel,String editphone) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickBrokers(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn();
		new AddBrokerpage(driver, eachNode).enterBrokername(name);
		new EditBrokerpage(driver, eachNode).selectChannel(channel);
		new EditParentCompanypage(driver, eachNode).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getNameBroker()
		.clickParentCompaniesTab().clickBrokers();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(name).clickSearchIcon().getSearchResults().clickDesireRecBroker()
		.verifyNameBroker(name);
		new AddBrokerpage(driver, eachNode).enterBrokername(editname);
		new EditBrokerpage(driver, eachNode).selectChannel(editchannel);
		new EditParentCompanypage(driver, eachNode).enterPhoneNum(editphone).clickUpdateBtn().getNameBroker().getPhone().clickParentCompaniesTab().clickBrokers();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(editname).clickSearchIcon().getSearchResults().clickDesireRecBroker().verifyNameBroker(editname).verifyPhone(editphone);
		
}

}
