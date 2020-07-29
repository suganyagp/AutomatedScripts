package teazzers.testcases.service_technicians;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ26ServTech_SearchbyCityName extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by City in Service Technician Module";
		testCaseDescription = "Searching using  city name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ005_SearchbyCity";
	}
	@Test(dataProvider = "getdata")
	public void searchCityName(String url,String uName, String Pwd,String name, String tradename,String addrtype,String addressline1,String city,String state,String zipcode) throws InterruptedException {
		
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode) .enterSearchKeyword(name).clickSearchIcon().clickDesireRecServTec()
		.verifyNamendTradenme(name, tradename).clickCreateUnderAddress().clickAddressdrpdwnBilling(addrtype)
		.enterAddressLine1(addressline1).enterCity(city).enterState(state).enterZipcode(zipcode).clickSaveChangesBtn()
		.getCity().clickParentCompaniesTab().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(city).clickSearchIcon().getSearchResults()
		.clickDesireRecServTec().verifyCity(city);
}
}