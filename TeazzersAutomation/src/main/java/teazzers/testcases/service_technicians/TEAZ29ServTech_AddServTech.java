package teazzers.testcases.service_technicians;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ29ServTech_AddServTech extends ProjSpecificMethods{
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Add New Service Technician";
		testCaseDescription = "Adding new Service Technician record and verifying whether it is added successfully";
		author = "Suganya";
		excelfile="TEAZ008_AddNewParent_NoOwner";
	}
	@Test(dataProvider = "getdata")
	public void AddServTechn(String url,String uName, String Pwd,String searchname, String tradename, String phone) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(searchname);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults().clickDesireRecServTec()
		.verifyNamendTradenme(searchname, tradename);
}

}
