package teazzers.testcases.distributors;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditDistributorpage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ39Distributors_AddLocations extends ProjSpecificMethods{
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Add Location in Distributor Record";
		testCaseDescription = "Adding location in Distributors Record and verifying whether it is added successfully";
		author = "Suganya";
		excelfile="TEAZ010_AddLocation2Parent";
	}
	@Test(dataProvider = "getdata")
	public void AddLocationDistributor(String url,String uName, String Pwd, String searchname,String tradename, String phone,String addrtype,String addressline1, String city, String state, String zipcode) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(searchname);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults().clickDesireRecDistrib()
		.verifyNamendTradenme(searchname, tradename);
		new EditDistributorpage(driver, eachNode).clickAdressTab();
		new EditParentCompanypage(driver, eachNode).clickCreateUnderAddress().clickAddressdrpdwnBilling(addrtype).enterAddressLine1(addressline1)
		.enterCity(city).enterState(state).enterZipcode(zipcode).clickSaveChangesBtn();
		new EditDistributorpage(driver, eachNode).clickAdressTab();
		new EditParentCompanypage(driver, eachNode).getAddrtype().getAddrline().verifyAddrtypendAddr(addrtype, addressline1);
		
}

}
