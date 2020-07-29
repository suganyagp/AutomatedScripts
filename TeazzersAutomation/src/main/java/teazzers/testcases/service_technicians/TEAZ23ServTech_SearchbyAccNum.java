package teazzers.testcases.service_technicians;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ23ServTech_SearchbyAccNum extends ProjSpecificMethods{
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Account Number in Service Technician module";
		testCaseDescription = "Searching using Account Number and getting the required records";
		author = "Suganya";
		excelfile="TEAZ003_SearchbyAccNum";
	}
	@Test(dataProvider = "getdata")
	public void searchAccNum(String url,String uName, String Pwd,String name,String tradename) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getAccnum().getName().getTradenme()
		.clickParentCompaniesTab().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).enterSearchAccnum().clickSearchIcon().getSearchResults().clickDesireRecServTec()
		.verifyNamendTradenme(name, tradename);
		
	}

}
