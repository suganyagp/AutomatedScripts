package teazzers.testcases.distributors;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditDistributorpage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ61_Distributors_SearchbyState extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by State in Distributors module";
		testCaseDescription = "Searching using state name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ006_SearchbyState";
	}
	@Test(dataProvider = "getdata")
	public void searchStateName(String url,String uName, String Pwd,String name, String tradename,String addrtype,String addressline1,String city,String state,String zipcode) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(name).clickSearchIcon().clickDesireRecDistrib()
		.verifyNamendTradenme(name, tradename);
		new EditDistributorpage(driver, eachNode).clickAdressTab();
		new EditParentCompanypage(driver, eachNode).clickCreateUnderAddress().clickAddressdrpdwnBilling(addrtype).enterAddressLine1(addressline1)
		.enterCity(city).enterState(state).enterZipcode(zipcode).clickSaveChangesBtn();
		new EditDistributorpage(driver, eachNode).clickAdressTab();
		new EditParentCompanypage(driver, eachNode).getState_distributr().clickParentCompaniesTab().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(state).clickSearchIcon().getSearchResults().clickDesireRecDistrib().verifyState(state);
	}

}

