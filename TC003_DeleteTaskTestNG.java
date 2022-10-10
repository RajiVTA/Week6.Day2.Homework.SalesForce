package week6.day2.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC003_DeleteTaskTestNG  extends BaseClassSalesForce{
	
	@Test
	public void deleteTask() throws InterruptedException
	{
//		4. Click on Tasks tab 
		
		WebElement opp = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[4]"));
		driver.executeScript("arguments[0].click()", opp);
		Thread.sleep(5000);
		
//		5.Click on Dropdown icon available under tasks and select value as Recently viewed
		
		driver.findElement(By.xpath("//div[@class='slds-dropdown-trigger slds-dropdown-trigger_click']")).click();
		Thread.sleep(5000);
		
		//5.1 select Edit
		driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]")).click();
		Thread.sleep(2000);

//		6. Click the Dropdown for Bootcamp task and select Edit
		driver.findElement(By.xpath("(//div[@class='uiPopupTrigger'])[2]")).click();
		Thread.sleep(6000);
		
		//6.1 Select 'Delete'
		//driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		
		
// 		7. Verfiy the Task is Deleted 
		//Thread.sleep(9000);
		Thread.sleep(5000);
		//WebElement verifyMsg = driver.findElement(By.xpath("//div[@id='toastDescription5789:0']/span"));
		//WebElement verifyMsg = driver.findElement(By.xpath("//div[@role='alertdialog']//div"));
		//WebElement verifyMsg = driver.findElement(By.xpath("//div[@role='alertdialog']//div//span"));
		WebElement verifyMsg = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		//verifyMsg.click();
		String text = verifyMsg.getText();
		System.out.println("Confirmation message after deletion :"+text);
		Thread.sleep(9000);
		
		
		
		
		
	}

}
