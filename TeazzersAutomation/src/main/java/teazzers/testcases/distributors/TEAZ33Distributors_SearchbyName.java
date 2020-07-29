package teazzers.testcases.distributors;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ33Distributors_SearchbyName extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Name in Distributors module";
		testCaseDescription = "Searching using name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ002_SearchbyName";
	}
	@Test(dataProvider = "getdata")
	public void searchName(String url,String uName, String Pwd,String name,String tradename, String phone) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickDistributors(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(name).clickSearchIcon().getSearchResults().clickDesireRecDistrib()
		.verifyNamendTradenme(name, tradename);
	}

}
