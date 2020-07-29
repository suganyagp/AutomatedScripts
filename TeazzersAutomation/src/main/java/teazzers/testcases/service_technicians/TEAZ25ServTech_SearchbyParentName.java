package teazzers.testcases.service_technicians;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.AddServiceTechnicianpage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ25ServTech_SearchbyParentName extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Parent Name in Service Technician Module";
		testCaseDescription = "Searching using Parent name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ025_ServTec_SearchParent";
	}
	@Test(dataProvider = "getdata")
	public void searchParentName(String url,String uName, String Pwd,String name,String tradename, String parentname) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickServiceTechn(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename);
		new AddServiceTechnicianpage(driver, eachNode).clickParent().enterSearch(parentname).clickSearchParnt().clickReqRadio(parentname);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(parentname).clickSearchIcon().getSearchResults().clickDesireRecServTec()
		.verifyNamendTradenme(name, tradename);
	}

}
