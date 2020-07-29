package teazzers.testcases.parentcompanies;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;

public class TEAZ02ParentCompany_SearchbyName extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Name in Parent Company Module";
		testCaseDescription = "Searching using name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ002_SearchbyName";
	}
	@Test(dataProvider = "getdata")
	public void searchName(String url,String uName, String Pwd,String searchname,String tradename,String phone){
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().
		clickAddbtn().enterName(searchname);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).unCheckOwnerOperator().clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().enterSearchKeyword(searchname).clickSearchIcon().getSearchResults().clickDesireRec()
		.verifyNamendTradenme(searchname, tradename);
	}

}
