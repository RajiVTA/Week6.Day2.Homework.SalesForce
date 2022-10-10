package week6.day2.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClassSalesForce {
	
	
	ChromeDriver driver;
	ChromeOptions options;
	@Parameters({"url","username","password"})
	
	
	@BeforeMethod
	public void login(String url, String username, String password) throws InterruptedException
	{
		// 1.  setup the path
		WebDriverManager.chromedriver().setup();
		//ChromeDriver driver=new ChromeDriver();
		
		// 2. disable notifications
		options = new ChromeOptions();
		options.addArguments("disable-notifications");
		
		// 3. create instance
		driver=new ChromeDriver(options);
				
		// 4	Launch the browser
		driver.get(url);
		
		// 5. manage ur window
		driver.manage().window().maximize();
		
		// 6. add wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// 7. enter username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		
		// 8. Enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		
		// 9. Click login button
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		Thread.sleep(8000);
		
		// 10. Click on Global Actions SVG icon
	
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		
		//11. click View All
		//driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//button[text()='View All']/parent::lightning-button")).click();
		
		//11.1 Click 'Sales'
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
			
	}
	
	@AfterMethod
	public void close() throws InterruptedException
	{
		Thread.sleep(8000);
		driver.quit();
	}

	
	

}
