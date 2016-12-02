package Utilitys;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserFactory 
      {
      static WebDriver driver;
       
		public static WebDriver startBrowser(String browserName)
		{
			if (browserName.equalsIgnoreCase("firefox"))
			{
				driver =new FirefoxDriver();
				
			}
			else if(browserName.equalsIgnoreCase("crome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\preetish\\Downloads\\Compressed\\chromedriver.exe");
				driver= new ChromeDriver();
			}
			else if (browserName.equalsIgnoreCase("ie"))
			{
		
				
 System.setProperty("webdriver.edge.driver", "C:\\Users\\preetish\\Downloads\\Compressed\\MicrosoftWebDriver.exe");
			    DesiredCapabilities capabilities = DesiredCapabilities.edge();
			    driver = new EdgeDriver(capabilities);
			}
			
			driver.manage().window().maximize();
			driver.get("http://store.demoqa.com/");
			return driver;

            }
		}
