package teazzers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;
import teazzers.api.ProjSpecificMethods;
import teazzers.util.Timestamp;

public class ManageParentCompaniespage extends ProjSpecificMethods {
	public static String noOfItems;
	
	public ManageParentCompaniespage(RemoteWebDriver driver,ExtentTest eachNode) {
		this.driver=driver;
		this.eachNode = eachNode;
	}
	
	public ManageParentCompaniespage getItemsCount() {
		WebElement eleItmCount = locateElement("xpath",prop.getProperty("ManageParntCmpy.itemscount.xpath"));
		System.out.println("Items displayed are:"+getElementText(eleItmCount));
		return this;
	
	}
	
	public EditParentCompanypage clickFirstRecInNameColumn() {
		WebElement eleClkName = locateElement("xpath",prop.getProperty("ManageParntCmpy.frstrecinname.xpath"));
		click(eleClkName);
		return new EditParentCompanypage(driver,eachNode);
	}
	
	public EditParentCompanypage clickReqRec(String searchname) {
		driver.findElementByLinkText(searchname).click();
		return new EditParentCompanypage(driver, eachNode);
	}
	
	public EditParentCompanypage clickDesireRec( ){
		
		WebElement desrec = driver.findElement(By.xpath("//a[@href='/Customers/ViewCustomer/"+uniquenum+"']"));
		/*int samp =3862;
		WebElement desrec = driver.findElement(By.xpath("//a[@href='/Customers/ViewCustomer/"+samp+"']"));
		*/
		desrec.click(); 
		return new EditParentCompanypage(driver, eachNode);	
	}
	
public EditParentCompanypage clickDesireRecServTec( ){
		
		WebElement desrecser = driver.findElement(By.xpath("//a[@href='/ServiceTechnicians/ViewServicetechnician/"+uniquenum+"']"));
		desrecser.click(); 
		return new EditParentCompanypage(driver, eachNode);	
	}
	public EditParentCompanypage clickDesireRecDistrib( ){
		WebElement desrecdistri = driver.findElement(By.xpath("//a[@href='/Distributors/ViewDistributor/"+uniquenum+"']"));
		desrecdistri.click(); 
		return new EditParentCompanypage(driver, eachNode);	
	}
	public EditParentCompanypage clickDesireRecBroker( ){
		WebElement desrecbrok = driver.findElement(By.xpath("//a[@href='/Brokers/ViewBroker/"+uniquenum+"']"));
		desrecbrok.click(); 
		return new EditParentCompanypage(driver, eachNode);	
	}
	public EditParentCompanypage clickDesireRecSupplier( ){
		WebElement desrecsupp = driver.findElement(By.xpath("//a[@href='Suppliers/ViewSupplier/"+uniquenum+"']"));
		desrecsupp.click(); 
		return new EditParentCompanypage(driver, eachNode);	
	}
	
	public ManageParentCompaniespage enterSearchKeyword(String searchnme) {
		WebElement eleSearch = locateElement("name",prop.getProperty("ManageParntCmpy.enteresearch.name"));
		clearAndType(eleSearch, searchnme);
		return this;
	}
	
	public ManageParentCompaniespage enterSearchAccnum() {
		WebElement eleSearch = locateElement("name",prop.getProperty("ManageParntCmpy.enteresearch.name"));
		clearAndType(eleSearch, Accnum);
		return this;
	}
	
	public ManageParentCompaniespage clickSearchIcon(){
		WebElement eleClkSearch = locateElement("xpath",prop.getProperty("ManageParntCmpy.clksearch.xpath"));
		click(eleClkSearch);
		return this;
		
	}
	  
	public ManageParentCompaniespage getSearchResults() {
		WebElement showRes=locateElement("xpath",prop.getProperty("ManageParntCmpy.showRes.xpath"));
		String  myString=getElementText(showRes);
		myString = myString.trim();
		String[] wordList = myString.split("\\s+");
		noOfItems = wordList[wordList.length-2];
		System.out.println("****************************************");
		if(noOfItems.equalsIgnoreCase("to")) {
			System.out.println("No records were displayed");	
		}
		else {
			String timstmp = Timestamp.format();
			searval =noOfItems+" records displayed on "+timstmp;
			System.out.println("Current run displays the following no.of.records:"+noOfItems+" on "+Timestamp.format());
		}
		return this;
		
	}
	
	
	
	public AddNewParentCompanyPage clickAddbtn() {
		WebElement eleClkAdd = locateElement("id",prop.getProperty("ManageParntCmpy.clkaddbtn.id"));
		click(eleClkAdd);
		return new AddNewParentCompanyPage(driver,eachNode);
	}
	
	public EditParentCompanypage clickSearchFirstRec() {
		WebElement eleClkFstRec = locateElement("xpath",prop.getProperty("ManageParntCmpy.clkfrstsearchrec.xpath"));
		click(eleClkFstRec);
		return new EditParentCompanypage(driver,eachNode);
	}
	
	public EditParentCompanypage failclickSearchFirstRec() {
		WebElement eleFAILClkFstRec = locateElement("xpath",prop.getProperty("ManageParntCmpy.failclkfrstrec.xpath"));
		click(eleFAILClkFstRec);
		return new EditParentCompanypage(driver,eachNode);
	}
	
	public ManageLocationspage clickLocation() {
		WebElement eleClkLoc = locateElement("xpath",prop.getProperty("ManageParntCmpy.clklocatn.xpath"));
		click(eleClkLoc);
		return new ManageLocationspage(driver, eachNode);
	}
	
	public ManageServiceTechnicianspage clickServiceTechn() {
		WebElement eleClkServTec = locateElement("xpath",prop.getProperty("ManageParntCmpy.clkservtech.xpath"));
		click(eleClkServTec);
		return new ManageServiceTechnicianspage(driver, eachNode);
	}
	
	public ManageDistributorspage clickDistributors() {
		WebElement eleClkDistribtr = locateElement("xpath",prop.getProperty("ManageParntCmpy.clkdistribtr.xpath"));
		click(eleClkDistribtr);
		return new ManageDistributorspage(driver, eachNode);
	}
	
	public ManageBrokerspage clickBrokers() {
		WebElement eleClkBroker = locateElement("xpath",prop.getProperty("ManageParntCmpy.clkbroker.xpath"));
		click(eleClkBroker);
		return new ManageBrokerspage(driver, eachNode);
	}
	
	public ManageSupplierspage clickSuppliers() {
		WebElement eleClkSupplier = locateElement("xpath",prop.getProperty("ManageParntCmpy.clksuppiler.xpath"));
		click(eleClkSupplier);
		return new ManageSupplierspage(driver, eachNode);
	}
	
	public ManageContactspage clickContacts() {
		WebElement eleContact = locateElement("xpath",prop.getProperty("ManageParntCmpy.clkContacts.xpath"));
		click(eleContact);
		return new ManageContactspage(driver, eachNode);
	}
	
	

}
