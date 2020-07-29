package teazzers.testcases.service_technicians;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ24ServTech_SearchbyTradeName extends ProjSpecificMethods {
	
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Trade Name in Service Technician Module";
		testCaseDescription = "Searching using Trade name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ004_SearchbyTradename";
	}
	@Test(dataProvider = "getdata")
	public void searchTradeName(String url,String uName, String Pwd,String name,String tradename, String phone) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickServiceTechn(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(tradename).clickSearchIcon().getSearchResults().clickDesireRecServTec()
		.verifyNamendTradenme(name, tradename);
		
		
		
	}

}
