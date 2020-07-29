package teazzers.testcases.parentcompanies;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;

public class TEAZ04ParentCompany_SearchbyTradeName extends ProjSpecificMethods {
	
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Trade Name in Parent Company Module";
		testCaseDescription = "Searching using Trade name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ004_SearchbyTradename";
	}
	@Test(dataProvider = "getdata")
	public void searchTradeName(String url,String uName, String Pwd,String name,String tradename, String phone) {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().
		clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).unCheckOwnerOperator().clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().enterSearchKeyword(tradename).clickSearchIcon().getSearchResults().clickDesireRec()
		.verifyNamendTradenme(name, tradename);
		
	
		
		
	}

}
