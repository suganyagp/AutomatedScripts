package teazzers.testcases.parentcompanies;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;

public class TEAZ06ParentCompany_SearchbyStateName extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by State in Parent Company Module";
		testCaseDescription = "Searching using state name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ006_SearchbyState";
	}
	@Test(dataProvider = "getdata")
	public void searchStateName(String url,String uName, String Pwd,String name, String tradename,String addrtype,String addressline1,String city,String state,String zipcode) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().
		clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename);
		new AddNewParentCompanyPage(driver, eachNode).unCheckOwnerOperator().clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().enterSearchKeyword(name).clickSearchIcon().clickDesireRec()
		.verifyNamendTradenme(name, tradename).clickCreateUnderAddress().clickAddressdrpdwnBilling(addrtype).enterAddressLine1(addressline1)
		.enterCity(city).enterState(state).enterZipcode(zipcode).clickSaveChangesBtn().getState().clickParentCompaniesTab()
		.enterSearchKeyword(state).clickSearchIcon().getSearchResults().clickDesireRec().verifyState(state);
	}

}
