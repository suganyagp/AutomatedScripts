package teazzers.testcases.distributors;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ62_Distributors_SearchbyPhone extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Phone Number in Distributors Module";
		testCaseDescription = "Searching using phone number and getting the required records";
		author = "Suganya";
		excelfile="TEAZ062_Distributor_SearchbyPhone";
	}
	@Test(dataProvider = "getdata")
	public void searchPhoneNum(String url,String uName, String Pwd,String name,String tradename, String phone) throws InterruptedException {
		
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getPhone()
		.clickParentCompaniesTab().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(phone).clickSearchIcon().getSearchResults().clickDesireRecDistrib().verifyPhone(phone);
	}

}

