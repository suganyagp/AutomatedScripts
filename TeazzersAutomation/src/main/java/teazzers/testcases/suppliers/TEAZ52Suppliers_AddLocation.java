package teazzers.testcases.suppliers;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditBrokerpage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ52Suppliers_AddLocation extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Add Location in Suppliers Record";
		testCaseDescription = "Adding location in suppliers Record and verifying whether it is added successfully";
		author = "Suganya";
		excelfile="TEAZ046Broker_AddLocations";
	}
	@Test(dataProvider = "getdata")
	public void AddLocationSupplier(String url,String uName, String Pwd, String name, String addrtype,String addressline1, String city, String state, String zipcode) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickSuppliers(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName()
		.clickParentCompaniesTab().clickSuppliers();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(name).clickSearchIcon().getSearchResults().clickDesireRecSupplier()
		.verifyNameSuppilers(name);
		new EditBrokerpage(driver, eachNode).clickAddress();
		new EditParentCompanypage(driver, eachNode).clickCreateUnderAddress().clickAddressdrpdwnBilling(addrtype).enterAddressLine1(addressline1)
		.enterCity(city).enterState(state).enterZipcode(zipcode).clickSaveChangesBtn();
		new EditBrokerpage(driver, eachNode).clickAddress();
		new EditParentCompanypage(driver, eachNode).getAddrtype().getAddrline().verifyAddrtypendAddr(addrtype, addressline1);
		
}

}
