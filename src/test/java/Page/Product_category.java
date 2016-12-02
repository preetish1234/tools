package Page;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilitys.log.Log;
import Utilitys.util;

public class Product_category {
	
	WebDriver driver;
	
	public Product_category(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="html/body/div[2]/div/div/header/nav/ul/li[2]/a")
	public WebElement productcategory;
	
	@FindBy(how = How.XPATH,using ="//a[contains(text(),'Accessories')]")
    public WebElement accessories;
    
	
	
	@FindBy(how = How.XPATH,using ="html/body/div[2]/div/div/div/div/div[1]/article/div/div/div[3]/div[2]/form/div[2]/div[1]/span/input")
    public WebElement addChart;
	
	
	
	
	//Mouse hover
	//add to chart
	public void ProductAction(WebDriver driver) throws InterruptedException{
		
	   
		util.isElementPresnt(driver, "html/body/div[2]/div/div/header/nav/ul/li[2]/a", 60);
		util.highLightElement(driver, productcategory);
		util.highLightElement(driver, accessories);
		util.HoverAndClick(driver, productcategory, accessories);
		Log.info("hover and click");
		Thread.sleep(4000);
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		addChart.click();
		Log.info("Click on addchart");
		
	}
	
}
