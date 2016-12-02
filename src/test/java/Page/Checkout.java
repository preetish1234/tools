package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilitys.util;

public class Checkout {
	
	WebDriver driver;
	
	public Checkout(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//a[@class='go_to_checkout']")
	public WebElement checkOut_link;
	
	

	public void CheckOut(WebDriver driver){
	
    util.SwitchWindow(driver);
	
	util.explicitWait(driver, "//a[@class='go_to_checkout']");
	util.highLightElement(driver, checkOut_link);
	checkOut_link.click();
	}
	
	@FindBy(how = How.XPATH,using="//a [@class='step2'][@href='#']")
	public WebElement Continous_Bottom;
	
	
	   public void cLickB0ttom(WebDriver driver){
		util.highLightElement(driver, Continous_Bottom);
		Continous_Bottom.click();
		
		
		
	}
	

}
