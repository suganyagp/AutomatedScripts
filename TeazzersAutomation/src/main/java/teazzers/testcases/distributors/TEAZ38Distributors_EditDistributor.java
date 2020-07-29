package teazzers.testcases.distributors;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditDistributorpage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ38Distributors_EditDistributor extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Edit Distributor Record";
		testCaseDescription = "Editing the Distributor record and verifying the changes are updated";
		author = "Suganya";
		excelfile="TEAZ009_EditParentWitDetails";
	}
	@Test(dataProvider = "getdata")
	public void editDistributor(String url,String uName, String Pwd, String searchname,String tradename, String phone,String edittradenme, String editphone) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(searchname);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().clickDesireRecDistrib()
		.verifyNamendTradenme(searchname, tradename);
		new EditParentCompanypage(driver, eachNode).enterTradeName(edittradenme).enterPhoneNum(editphone).clickUpdateBtn()
		.getTradenme().clickParentCompaniesTab().clickDistributors();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults()
		.clickDesireRecDistrib().verifyNamendTradenme(searchname, edittradenme);
		
}

}
