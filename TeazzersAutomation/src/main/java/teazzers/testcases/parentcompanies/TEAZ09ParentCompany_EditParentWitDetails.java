package teazzers.testcases.parentcompanies;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;

public class TEAZ09ParentCompany_EditParentWitDetails extends ProjSpecificMethods
{
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Edit Parent Record in Parent Company Module";
		testCaseDescription = "Editing the Prent record and verifying the changes are updated";
		author = "Suganya";
		excelfile="TEAZ009_EditParentWitDetails";
	}
	@Test(dataProvider = "getdata")
	public void editParentCompany(String url,String uName, String Pwd, String searchname,String tradename, String phone,String edittradenme, String editphone){
	
		
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().
		clickAddbtn().enterName(searchname);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).unCheckOwnerOperator().clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().enterSearchKeyword(searchname).clickSearchIcon().clickDesireRec()
		.verifyNamendTradenme(searchname, tradename);
		new EditParentCompanypage(driver, eachNode).enterTradeName(edittradenme).enterPhoneNum(editphone).clickUpdateBtn()
		.getTradenme().clickParentCompaniesTab().enterSearchKeyword(searchname).clickSearchIcon().getSearchResults()
		.clickDesireRec().verifyNamendTradenme(searchname, edittradenme);
	
		
		
		
		
}
	
}
