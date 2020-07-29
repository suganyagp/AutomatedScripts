package teazzers.testcases.service_technicians;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ30ServTech_EditServTechDetails extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Edit Service Technician Record";
		testCaseDescription = "Editing the Service Technician record and verifying the changes are updated";
		author = "Suganya";
		excelfile="TEAZ009_EditParentWitDetails";
	}
	@Test(dataProvider = "getdata")
	public void editServTechn(String url,String uName, String Pwd, String searchname,String tradename, String phone,String edittradenme, String editphone) throws InterruptedException {
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(searchname);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename).enterPhoneNum(phone);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName().getTradenme()
		.clickParentCompaniesTab().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().clickDesireRecServTec()
		.verifyNamendTradenme(searchname, tradename);
		new EditParentCompanypage(driver, eachNode).enterTradeName(edittradenme).enterPhoneNum(editphone).clickUpdateBtn()
		.getTradenme().clickParentCompaniesTab().clickServiceTechn();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(searchname).clickSearchIcon().getSearchResults()
		.clickDesireRecServTec().verifyNamendTradenme(searchname, edittradenme);
		
}

}
