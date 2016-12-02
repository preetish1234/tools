package Page;




import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilitys.ExcelDataConfig;
import Utilitys.WriteExcel;
import Utilitys.log.Log;
import Utilitys.util;



public class loginPage {
	
	
	WebDriver driver;
	
	
	public loginPage(WebDriver driver){
    //Initialize my object in this page
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.XPATH,using="//a[contains(.,'AccountMy Account')]")
	public  WebElement MyAccount;
	
	
	    public void My_Account(WebDriver driver){
	      
	       util.highLightElement(driver, MyAccount);
	       MyAccount.click();
	       util.captureScreenShot(driver, "MyAccount");
	
}
	    //Login functionality
	    @FindBy(how = How.XPATH,using="//input[@id='log'][@name='log']")
        public WebElement username;
	    
	    @FindBy(how=How.XPATH,using="//input[@id='pwd'][@name='pwd']")
	    public WebElement password;
	    
	    @FindBy(how = How.XPATH,using="//input[@id='login'][@name='submit']")
	    public WebElement LoginBottom;
	    
	  //Login functionality
	    public void Login(WebDriver driver) throws Exception{

	        
	    ExcelDataConfig excel = new ExcelDataConfig("C:\\Preetish\\onlineproject\\src\\test\\java\\excel\\data.xlsx");	
	    	  util.highLightElement(driver, username);
	    	  
	          username.sendKeys(excel.getData(0, 1, 0));
	          WriteExcel.write1(1, 3 , "preetih");
	          
	          
	          String user = "preetish1234";
	       
	         
	       try {
				  AssertJUnit.assertTrue("invalid username-" + username , user.contains("preetish1234"));
		   	} catch (Exception e) {
				
				e.printStackTrace();
			}
	    	  Log.info("User can type on the user field");
	    	 
	    	  util.highLightElement(driver, password);
	    	  password.sendKeys(excel.getData(0, 1, 1));
	    	  
	    	  String pass = "mili21sep@preetish";
	          try {
				AssertJUnit.assertTrue("invalid password-"+pass, pass.contains("mili21sep@preetish"));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	    	  Log.info("user can type in the password field");
	    	  
	    	  util.highLightElement(driver, LoginBottom);
	    	  LoginBottom.click();
	       	  Log.info("click on loginbuttom");
	    	
	    	
	    }
	    
	    
}