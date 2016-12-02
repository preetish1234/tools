package frameWork;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Page.Checkout;
import Page.FinalShippingpage;
import Page.Product_category;
import Page.loginPage;
import Utilitys.BrowserFactory;
import Utilitys.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestApplication {
	
	ExtentReports report;
	ExtentTest logger;
	Logger log;
	WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	public void Logconfig()
	{
		
PropertyConfigurator.configure("C:\\Preetish\\onlineproject\\Log4j");
		 
	}
	@BeforeClass(alwaysRun=true)
	public void BrowserEngin(){
		driver = BrowserFactory.startBrowser("Firefox");
		report =new ExtentReports("C:\\Preetish\\onlineproject\\ExtentReport\\m.html");
		 logger = report.startTest("ApplicationTestCase");
		  logger.log(LogStatus.INFO, "Browser started");
		
	}

	
@Test(groups="Login",priority=1)	
		
		public void LoginTOApp() throws Exception{
			
	logger = report.startTest("LoginTest");
           loginPage account = new loginPage(driver);
		 
		    account.My_Account(driver);
		    logger.log(LogStatus.INFO, "Account click");
	
		     
		    account.Login(driver);
		    logger.log(LogStatus.PASS, "user can login sucessfully");	
		    }
@Test(groups="product",priority=2)	
public void Product() throws Exception{
	

 logger= report.startTest("ProductTest");
 
    Product_category product = new Product_category(driver);
    product.ProductAction(driver);
    logger.log(LogStatus.INFO, "Hover to product click on accessories and selected the item");
    
    Checkout product1check = new Checkout(driver);
    product1check.CheckOut(driver);
    product1check.cLickB0ttom(driver);
    logger.log(LogStatus.INFO, "click on checkout");
    
    
}
   
@Test(groups="payment",priority=3)	
    public void Shipping() throws Exception{
	
    logger= report.startTest("ShippingTest");

    FinalShippingpage select = new FinalShippingpage(driver);
    //select.CheckoutSignin(driver);
    //select.Firstname_Method(driver);
    //select.LstNme_Method(driver);
    //select.Adresstxt_Method(driver);
    //select.city_Method(driver);
    select.purchaseClick(driver);
    logger.log(LogStatus.PASS, "User purches sucessfully");
}
@AfterMethod(alwaysRun=true)
public void TearDown(ITestResult result){
	if (result.getStatus()==ITestResult.FAILURE){
String screenshot_path =	util.captureScreenShot(driver, result.getName());
String image= logger.addScreenCapture(screenshot_path);
logger.log(LogStatus.FAIL,"ScreenShot", image);

	} 			
report.endTest(logger);
report.flush();
}

@AfterClass(alwaysRun=true)
public void TearDown(){
driver.quit();	
}
}

