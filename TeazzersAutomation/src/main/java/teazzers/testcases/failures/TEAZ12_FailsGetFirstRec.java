package teazzers.testcases.failures;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.LoginPage;

public class TEAZ12_FailsGetFirstRec extends ProjSpecificMethods {
	
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Fails to get the record details";
		testCaseDescription = "Unable to navigate to the record details which has been searched ";
		author = "Suganya";
		excelfile="TEAZ009_EditParentWitDetails";
	}
	@Test(dataProvider = "getdata")
	public void editParentCompany(String url,String uName, String Pwd, String searchname,String tradename, String phone) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().
		enterSearchKeyword(searchname).clickSearchIcon().failclickSearchFirstRec().enterTradeName(tradename).enterPhoneNum(phone).
		clickUpdateBtn().clickParentCompaniesTab().enterSearchKeyword(searchname).clickSearchIcon();
		
}

}
