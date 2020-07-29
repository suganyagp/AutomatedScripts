package teazzers.testcases.service_technicians;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ27ServTech_SearchbyPhoneNum extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Phone Number in Service Technician Module";
		testCaseDescription = "Searching using phone number and getting the required records";
		author = "Suganya";
		excelfile="TEAZ007_SearchbyPhoneNum";
	}
	@Test(dataProvider = "getdata")
	public void searchPhoneNum(String url,String uName, String Pwd,String name,String tradename, String phone) throws InterruptedException {
		
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getPhone()
		.clickParentCompaniesTab().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(phone).clickSearchIcon().getSearchResults().clickDesireRecServTec()
		.verifyPhone(phone);
	}

}
