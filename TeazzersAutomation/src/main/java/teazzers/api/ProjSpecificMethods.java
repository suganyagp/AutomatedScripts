package teazzers.api;



import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import teazzers.selenium.api.SeleniumBase;
import teazzers.util.ReadExcel;

public class ProjSpecificMethods extends SeleniumBase  {
	public String excelfile;
	public static String  searval;
	public static String uniquenum;
	public static String Accnum;
	public static String Name;
	public static String Tradename;
	public static String Addrtype;
	public static String Addrline;
	public static String City;
	public static String State;
	public static String Phone;
	
	
	@BeforeSuite
	public void loadObj() {
		loadObjects();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		eachNode = test.createNode(testCaseName);
		startApp();
	}
	
	@DataProvider
	public String[][] getdata() throws IOException {
		ReadExcel obj= new ReadExcel();
		String[][] readexcel = obj.readExcel(excelfile);
		return readexcel;	
	}
	
	
	@AfterMethod
	public void afterMethod() {
		closeBrowser();
	}
	
	@AfterSuite
	public void unloadObj() {
		unloadObjects();
	}

	
	
	


	

}
