package teazzers.testcases.parentcompanies;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;

public class TEAZ08ParentCompany_AddNewParntWitNoOwner extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Add New Parent Owner in Parent Company Module";
		testCaseDescription = "Adding new Parent Owner record and verifying whether it is added successfully";
		author = "Suganya";
		excelfile="TEAZ008_AddNewParent_NoOwner";
	}
	@Test(dataProvider = "getdata")
	public void AddParentCompany(String url,String uName, String Pwd,String searchname, String tradename, String phone) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().
		clickAddbtn().enterName(searchname);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).unCheckOwnerOperator().clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().enterSearchKeyword(searchname).clickSearchIcon().getSearchResults().clickDesireRec()
		.verifyNamendTradenme(searchname, tradename);
}
	
}
