package teazzers.testcases.suppliers;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;
import teazzers.pages.ManageParentCompaniespage;

public class TEAZ51Suppliers_EditSupplier extends ProjSpecificMethods {
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Edit Supplier Record";
		testCaseDescription = "Editing the Supplier record and verifying the changes are updated";
		author = "Suganya";
		excelfile="TEAZ051Supplier_EditSupplier";
	}
	@Test(dataProvider = "getdata")
	public void editSupplier(String url,String uName, String Pwd, String name,String editname) throws InterruptedException {
		new LoginPage(driver,eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().clickSuppliers(); 
		new ManageParentCompaniespage(driver, eachNode).clickAddbtn().enterName(name);
		new AddNewParentCompanyPage(driver, eachNode).clickSaveBtn().getUniqueNum().getName()
		.clickParentCompaniesTab().clickSuppliers();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(name).clickSearchIcon().getSearchResults().clickDesireRecSupplier()
		.verifyNameSuppilers(name);
		new AddNewParentCompanyPage(driver, eachNode).enterName(editname);
		new EditParentCompanypage(driver, eachNode).clickUpdateBtn().getName()
		.clickParentCompaniesTab().clickSuppliers();
		new ManageParentCompaniespage(driver, eachNode).enterSearchKeyword(editname).clickSearchIcon().getSearchResults().clickDesireRecSupplier()
		.verifyNameSuppilers(editname);
		
		
}

}
