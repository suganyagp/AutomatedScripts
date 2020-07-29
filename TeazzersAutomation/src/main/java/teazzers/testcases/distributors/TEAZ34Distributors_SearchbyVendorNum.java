package teazzers.testcases.distributors;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ34Distributors_SearchbyVendorNum extends ProjSpecificMethods{
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Vendor Number in Distributors Module";
		testCaseDescription = "Searching using Vendor Number and getting the required records";
		author = "Suganya";
		excelfile="TEAZ003_SearchbyAccNum";
	}
	@Test(dataProvider = "getdata")
	public void searchVendorNum(String url,String uName, String Pwd,String name,String tradename) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getAccnum().getName().getTradenme()
		.clickParentCompaniesTab().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).enterSearchAccnum().clickSearchIcon().getSearchResults().clickDesireRecDistrib()
		.verifyNamendTradenme(name, tradename);
	}

}
