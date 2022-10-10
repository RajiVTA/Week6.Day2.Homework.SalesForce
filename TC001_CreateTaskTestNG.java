package week6.day2.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC001_CreateTaskTestNG extends BaseClassSalesForce {
	
	@Test
	public void createTask() throws InterruptedException
	{
//		12. Click on Tasks tab 
		
		WebElement opp = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[4]"));
		driver.executeScript("arguments[0].click()", opp);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//div[@class='slds-context-bar__label-action slds-p-left--none'])[3]")).click();
		Thread.sleep(5000);
		
		//13. Click New Task under drop down icon
					
		WebElement newTask = driver.findElement(By.xpath("//one-app-nav-bar-menu-item[@class='slds-dropdown__item']/a/span//span"));
		driver.executeScript("arguments[0].click()", newTask);

		Thread.sleep(7000);
				
		//14. Enter subject as Bootcamp
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Bootcamp");
		
		//15.Select status as 'Waiting on someone else'
		driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
		Thread.sleep(3000);
		WebElement stat = driver.findElement(By.xpath("(//li[contains(@class,'uiRadioMenuItem')])[5]"));
		driver.executeScript("arguments[0].click()", stat);
		
		WebElement stat1 = driver.findElement(By.xpath("(//li[contains(@class,'uiRadioMenuItem')])[5]/a"));
		driver.executeScript("arguments[0].click()", stat1);
		
		//16. Save and create a Task verified message
		
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		String taskVerify = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[4]")).getAttribute("title");
		System.out.println("Task name is "+taskVerify);
		if(taskVerify.contains("Bootcamp"))
		{
			System.out.println("Task name is verified");
		}
		else
		{
			System.out.println("Task name is not verified");
		}	
	
	}

}
