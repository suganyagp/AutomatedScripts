package teazzers.testcases.parentcompanies;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;

public class TEAZ05ParentCompany_SearchbyCityName extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by City in Parent Company Module";
		testCaseDescription = "Searching using  city name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ005_SearchbyCity";
	}
	@Test(dataProvider = "getdata")
	public void searchCityName(String url,String uName, String Pwd,String name, String tradename,String addrtype,String addressline1,String city,String state,String zipcode) throws InterruptedException{
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().
		clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename);
		new AddNewParentCompanyPage(driver, eachNode).unCheckOwnerOperator().clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().enterSearchKeyword(name).clickSearchIcon().clickDesireRec()
		.verifyNamendTradenme(name, tradename).clickCreateUnderAddress().clickAddressdrpdwnBilling(addrtype).enterAddressLine1(addressline1)
		.enterCity(city).enterState(state).enterZipcode(zipcode).clickSaveChangesBtn().getCity().clickParentCompaniesTab()
		.enterSearchKeyword(city).clickSearchIcon().getSearchResults().clickDesireRec().verifyCity(city);
		
		
	
	}

}
