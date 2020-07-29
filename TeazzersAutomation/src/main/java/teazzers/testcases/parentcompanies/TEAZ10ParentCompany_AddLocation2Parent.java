package teazzers.testcases.parentcompanies;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ10ParentCompany_AddLocation2Parent extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Add Location in Parent Record";
		testCaseDescription = "Adding location in Parent Record and verifying whether it is added successfully";
		author = "Suganya";
		excelfile="TEAZ010_AddLocation2Parent";
	}
	@Test(dataProvider = "getdata")
	public void addLocation(String url,String uName, String Pwd, String searchname,String tradename, String phone,String addrtype,String addressline1, String city, String state, String zipcode) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().
		clickAddbtn().enterName(searchname);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).unCheckOwnerOperator().clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().enterSearchKeyword(searchname).clickSearchIcon().getSearchResults().clickDesireRec()
		.verifyNamendTradenme(searchname, tradename).clickCreateUnderAddress().clickAddressdrpdwnBilling(addrtype).enterAddressLine1(addressline1)
		.enterCity(city).enterState(state).enterZipcode(zipcode).clickSaveChangesBtn().getAddrtype().getAddrline().verifyAddrtypendAddr(addrtype, addressline1);
		
		
		
		
		
		
		
}

}
