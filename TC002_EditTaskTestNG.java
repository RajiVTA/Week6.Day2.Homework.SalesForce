package week6.day2.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC002_EditTaskTestNG  extends BaseClassSalesForce{
	
	
	@Test
	public void editTask() throws InterruptedException
	{
//	4. Click on Tasks tab 
		
	WebElement opp = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[4]"));
	driver.executeScript("arguments[0].click()", opp);
	Thread.sleep(5000);
	
//	5.Click on Dropdown icon available under tasks and select value as Recently viewed
	
	driver.findElement(By.xpath("//div[@class='slds-dropdown-trigger slds-dropdown-trigger_click']")).click();
	Thread.sleep(5000);
	
	//5.1 select Edit
	driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]")).click();
	Thread.sleep(2000);

//	6. Click the Dropdown for Bootcamp task and select Edit
	driver.findElement(By.xpath("(//div[@class='uiPopupTrigger'])[2]")).click();
	Thread.sleep(6000);
	
	//6.1 Select 'Edit'
	driver.findElement(By.xpath("//a[@title='Edit']")).click();
	
	//driver.findElement(By.xpath("//div[@title='Edit']")).click();
	Thread.sleep(3000);
		
//	7. Select todays date as Due date

	driver.findElement(By.xpath("//div[@class='panel slds-modal slds-fade-in-open']")).click();
	Thread.sleep(13000);

	WebElement due = driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));
	due.clear();
	due.sendKeys("10/10/2022");

	Thread.sleep(7000);
	
//	8. Select Priority as low
	
	driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
	driver.findElement(By.xpath("//a[@title='Low']")).click();
	
//	10. Click save and verify Subject
	
	driver.findElement(By.xpath("//span[text()='Save']")).click();
	
		
	WebElement verifySubject = driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grid itemBody']/span/span)[2]"));
	String verSub = verifySubject.getText();
	System.out.println("Task name is "+verSub);
	
	Thread.sleep(8000);
	WebElement verifyDue = driver.findElement(By.xpath("//div[@class='slds-form-element slds-form-element_readonly slds-form-element_edit slds-grow slds-hint-parent override--slds-form-element']//div[@class='runtime_sales_activitiesTaskDateOverride']//span[@class='uiOutputDate']"));
	//WebElement verifyDue = driver.findElement(By.xpath("//span[@class='test-id__field-value slds-form-element__static slds-grow ']//div[@class='runtime_sales_activitiesTaskDateOverride']/span"));
	String verDue = verifyDue.getText();
	System.out.println("Due date is "+verDue);
	
	if(verSub.contains("Bootcamp"))
	{
		System.out.println("Task name is verified");
	}
	else
	{
		System.out.println("Task name is not verified");
	}	
	
	Thread.sleep(3000);
	WebElement verify = driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow ']/span)[2]"));
	String v = verify.getText();
	System.out.println("Verify subject :"+v);
	}

}
