package teazzers.testcases.parentcompanies;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;

public class TEAZ07ParentCompany_SearchbyPhoneNum extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Phone Number in Parent Company Module";
		testCaseDescription = "Searching using phone number and getting the required records";
		author = "Suganya";
		excelfile="TEAZ007_SearchbyPhoneNum";
	}
	@Test(dataProvider = "getdata")
	public void searchPhoneNum(String url,String uName, String Pwd,String name,String tradename, String phone) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().
		clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).unCheckOwnerOperator().clickSaveBtn().getUniqueNum().getPhone()
		.clickParentCompaniesTab().enterSearchKeyword(phone).clickSearchIcon().getSearchResults().clickDesireRec()
		.verifyPhone(phone);
	}

}
