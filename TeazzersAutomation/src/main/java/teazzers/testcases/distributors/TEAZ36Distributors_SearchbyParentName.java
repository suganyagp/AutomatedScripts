package teazzers.testcases.distributors;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.AddServiceTechnicianpage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ36Distributors_SearchbyParentName extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Parent Name in Distributors Module";
		testCaseDescription = "Searching using Parent name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ036_Distri_SearchParent";
	}
	@Test(dataProvider = "getdata")
	public void searchParentName(String url,String uName, String Pwd,String name,String tradename, String parentname) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickDistributors(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename);
		new AddServiceTechnicianpage(driver, eachNode).clickParent().enterSearch(parentname).clickSearchParnt().clickReqRadio(parentname);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(parentname).clickSearchIcon().getSearchResults().clickDesireRecDistrib()
		.verifyNamendTradenme(name, tradename);
	}

}
