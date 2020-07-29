package teazzers.testcases.parentcompanies;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import teazzers.api.ProjSpecificMethods;
import teazzers.pages.AddNewParentCompanyPage;
import teazzers.pages.EditParentCompanypage;
import teazzers.pages.LoginPage;

public class TEAZ03ParentCompany_SearchbyAccNum extends ProjSpecificMethods{
	@BeforeTest
	public void setecelfile() {
		testCaseName = "Search by Account Number";
		testCaseDescription = "Searching using Account Number and getting the required records";
		author = "Suganya";
		excelfile="TEAZ003_SearchbyAccNum";
	}
	@Test(dataProvider = "getdata")
	public void searchAccNum(String url,String uName, String Pwd,String name,String tradename){
		
		new LoginPage(driver, eachNode).launchURL(url).enterUsername(uName).enterPassword(Pwd).clickLogin().clickPartners().
		clickAddbtn().enterName(name);
		new EditParentCompanypage(driver, eachNode).enterTradeName(tradename);
		new AddNewParentCompanyPage(driver, eachNode).unCheckOwnerOperator().clickSaveBtn().getUniqueNum().getAccnum().getName().getTradenme()
		.clickParentCompaniesTab().enterSearchAccnum().clickSearchIcon().getSearchResults().clickDesireRec()
		.verifyNamendTradenme(name, tradename);
		 
	}

}
