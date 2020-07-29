package teazzers.testcases.suppliers;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ48Suppliers_SearchbyName extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Name in Suppliers module";
		testCaseDescription = "Searching using name and getting the required records";
		author = "Suganya";
		excelfile="TEAZ048Suppliers_SearchbyName";
	}
	@Test(dataProvider = "getdata")
	public void searchName(String url,String uName, String Pwd,String name) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickSuppliers(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName()
		.clickParentCompaniesTab().clickSuppliers();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(name).clickSearchIcon().getSearchResults().clickDesireRecSupplier()
		.verifyNameSuppilers(name);
	}

}
