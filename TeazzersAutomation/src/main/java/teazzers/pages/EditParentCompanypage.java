package teazzers.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import teazzers.api.ProjSpecificMethods;

public class EditParentCompanypage extends ProjSpecificMethods {
	
	public EditParentCompanypage(RemoteWebDriver driver,ExtentTest eachNode) {
		this.driver=driver;
		this.eachNode = eachNode;
		
	}
	
	public EditParentCompanypage getUniqueNum() {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleContains("TeaWorld - Edit"));
			String text = driver.getCurrentUrl();
		 	uniquenum = text.replaceAll("[^0-9]", "");
			return this;
	}
	
	public EditParentCompanypage getAccnum() {
		WebElement eleAccnum = locateElement("xpath",prop.getProperty("editparntcmpy.getaccnum.xpath"));
		Accnum = eleAccnum.getAttribute("value");
		//System.out.println("Account number"+Accnum);
		return this;
		
	}
	
	public EditParentCompanypage getName() {
		WebElement eleName = locateElement("id",prop.getProperty("addnewparntcmpy.entrname.id"));
		Name = eleName.getAttribute("value");
		//System.out.println("Nmae"+Name);
		return this;
		
	}
	public EditParentCompanypage getNameBroker() {
		WebElement eleName = locateElement("id",prop.getProperty("addbroker.entername.id"));
		Name = eleName.getAttribute("value");
		//System.out.println("Nmae"+Name);
		return this;
		
	}
	
	public EditParentCompanypage getTradenme() {
		WebElement eleTradeName = locateElement("id",prop.getProperty("editparntcmpy.entrtradename.id"));
		Tradename = eleTradeName.getAttribute("value");
		//System.out.println("TradeNmae"+Tradename);
		return this;
		
	}
	public EditParentCompanypage getPhone() {
		WebElement elePhoneno = locateElement("id",prop.getProperty("editparntcmpy.entrphone.id"));
		Phone = elePhoneno.getAttribute("value");
		//System.out.println("TradeNmae"+Tradename);
		return this;
		
	}
	
	
	public EditParentCompanypage verifyNamendTradenme(String searchname, String tradenme) {
		Assert.assertEquals(searchname, Name, "names are not matching");
		Assert.assertEquals(tradenme, Tradename, "Tradenames are not matching");
		System.out.println("Names are verified successfully");
		return this;
	}
	
	public EditParentCompanypage verifyNameBroker(String searchname) {
		Assert.assertEquals(searchname, Name, "names are not matching");
		System.out.println("Names are verified successfully");
		return this;
	} 
	public EditParentCompanypage verifyNameSuppilers(String searchname) {
		Assert.assertEquals(searchname, Name, "names are not matching");
		System.out.println("Names are verified successfully");
		return this;
	}
	
	public EditParentCompanypage getAddrtype() {
		WebElement eleAddrtype = locateElement("xpath",prop.getProperty("editparntcmpy.getaddrtye.xpath"));
		Addrtype = eleAddrtype.getText();
		//System.out.println("Addtype"+Addrtype);
		return this;
		
	}
	
	public EditParentCompanypage getAddrline() {
		WebElement eleAddrline = locateElement("xpath",prop.getProperty("editparntcmpy.getaddrline.xpath"));
		Addrline = eleAddrline.getText();
		//System.out.println("Addrline"+Addrline);
		return this;
		
	}
	
	public EditParentCompanypage getCity() {
		WebElement eleCity = locateElement("xpath",prop.getProperty("editparntcmpy.getcity.xpath"));
		City = eleCity.getText();
		//System.out.println("Addrline"+City);
		return this;
		
	}
	
	public EditParentCompanypage getState() {
		WebElement eleState = locateElement("xpath",prop.getProperty("editparntcmpy.getstate.xpath"));
		State = eleState.getText();
		//System.out.println("Addrline"+City);
		return this;
	}
	public EditParentCompanypage getState_distributr() {
		WebElement eleState = locateElement("xpath",prop.getProperty("editparntcmpy.getstate.distri.xpath"));
		State = eleState.getText();
		//System.out.println("Addrline"+City);
		return this;
	}
	
	public EditParentCompanypage verifyAddrtypendAddr(String addrtype, String addrline) {
		Assert.assertEquals(addrtype, Addrtype, "Address Types are not matching");
		Assert.assertEquals(addrline, Addrline, "Address lines are not matching");
		System.out.println("Addresses are verified successfully");
		return this;
	}
	
	public EditParentCompanypage verifyCity(String city) {
		Assert.assertEquals(city, City,"Cities are not matching");
		System.out.println("Cities are verified successfully");
		return this;
	}
	public EditParentCompanypage verifyState(String state) {
		Assert.assertEquals(state, State,"States are not matching");
		System.out.println("States are verified successfully");
		return this;
	}
	public EditParentCompanypage verifyPhone(String phone) {
		Assert.assertEquals(phone, Phone,"Phone numbers are not matching");
		System.out.println("Phone numbers are verified successfully");
		return this;
	}
	
	public ManageParentCompaniespage clickParentCompaniesTab() {
		WebElement eleParntCmpy = locateElement("xpath",prop.getProperty("editparntcmpy.clkparntcmpy.xpath"));
		click(eleParntCmpy);
		return new ManageParentCompaniespage(driver,eachNode);
	}
	
	public EditParentCompanypage enterTradeName(String tradenme ) {
		WebElement eleTradName = locateElement("id",prop.getProperty("editparntcmpy.entrtradename.id"));
		clearAndType(eleTradName, tradenme);
		return this;
	}
	public EditParentCompanypage enterPhoneNum(String phne) {
		WebElement elePhoneNum = locateElement("id",prop.getProperty("editparntcmpy.entrphone.id"));
		clearAndType(elePhoneNum, phne);
		return this;
		
	}
	
	public EditParentCompanypage clickUpdateBtn() {
		WebElement eleUpdateBtn = locateElement("xpath",prop.getProperty("editparntcmpy.clkupdate.xpath"));
		click(eleUpdateBtn);
		return this;
	}
	
	public EditParentCompanypage clickCreateUnderAddress() throws InterruptedException {
		WebElement eleClkAddr = locateElement("id",prop.getProperty("editparntcmpy.clkcreateaddr.id"));
		click(eleClkAddr);
		Thread.sleep(2000);
		return this;
	}
	
	public EditParentCompanypage clickAddressdrpdwnBilling(String value) {
		
		WebElement addr = locateElement("xpath",prop.getProperty("editparntcmpy.seldrpwn.xpath"));
		selectDropDownUsingText(addr, value);
		return this;
		
	}
	
	public EditParentCompanypage enterAddressLine1(String addressline) {
		WebElement eleAddrLine = locateElement("id",prop.getProperty("editparntcmpy.entraddr.id"));
		clearAndType(eleAddrLine, addressline);
		return this;
	}
	
	public EditParentCompanypage enterCity(String city) {
		WebElement eleCity = locateElement("id",prop.getProperty("editparntcmpy.entrcity.id"));
		clearAndType(eleCity, city);
		return this;
	}
	
	public EditParentCompanypage enterState(String state) {
		WebElement eleState = locateElement("id",prop.getProperty("editparntcmpy.entrstate.id"));
		clearAndType(eleState, state);
		return this;
	}

	public EditParentCompanypage enterZipcode(String zipcode) {
		WebElement eleZipcode = locateElement("id",prop.getProperty("editparntcmpy.enterzip.id"));
		clearAndType(eleZipcode, zipcode);
		return this;
	}
	
	public EditParentCompanypage clickSaveChangesBtn() throws InterruptedException {
		WebElement eleSaveChge = locateElement("id",prop.getProperty("editparntcmpy.savechanges.id"));
		click(eleSaveChge);
		Thread.sleep(2000);
		return this;
	}
	
	
}
