package teazzers.testcases.suppliers;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ49Suppliers_SearchbyAccNum extends ProjSpecificMethods{
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Account Number in Suppliers Module";
		testCaseDescription = "Searching using Account Number and getting the required records";
		author = "Suganya";
		excelfile="TEAZ048Suppliers_SearchbyName";
	}
	@Test(dataProvider = "getdata")
	public void searchAccNum(String url,String uName, String Pwd,String name) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickSuppliers(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName().getAccnum()
		.clickParentCompaniesTab().clickSuppliers();
		new ManageParentCompaniespage(driver, eachNode).enterSearchAccnum().clickSearchIcon().getSearchResults().clickDesireRecSupplier();
		//.verifyNameSuppilers(name);
	}

}
