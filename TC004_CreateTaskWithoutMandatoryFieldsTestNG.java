package week6.day2.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC004_CreateTaskWithoutMandatoryFieldsTestNG  extends BaseClassSalesForce{
	
	@Test
	public void createTaskWithoutMandatory() throws InterruptedException
	{
		// 13.Click on Tasks -> New Task
		
			driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[3]")).click();
			Thread.sleep(3000);
			
			WebElement newTask = driver.findElement(By.xpath("(//span[@class='slds-truncate'])[6]/lightning-icon/following::span"));
			driver.executeScript("arguments[0].click()", newTask);
			//driver.findElement(By.xpath("//span[text()='New Task']")).click();
			Thread.sleep(4000);
			
			// 14. Select Name from Dropdown

			Thread.sleep(4000);
			
			//driver.findElement(By.xpath("//input[@id='combobox-input-323']")).click();
			
			//driver.findElement(By.xpath("//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']")).click();
			driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']")).click();
			
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//div[@title='Security User']")).click();
			driver.findElement(By.xpath("//span[@class='pillText' and text()='Ramkumar Ramaiah']")).click();
			
			Thread.sleep(5000);
			
			
			driver.findElement(By.xpath("(//div[@class='autocompleteWrapper slds-grow']/input)[2]")).click();
			//driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']")).click();
			driver.findElement(By.xpath("//div[@title='Babu Manickam']")).click();
			
			// 15. Enter Coments as SALES FORCE Automation Using Selenium
			WebElement textArea = driver.findElement(By.xpath("//textarea[@class='textarea textarea uiInput uiInputTextArea uiInput--default uiInput--textarea']"));
			
			textArea.sendKeys("SALES FORCE Automation Using Selenium");
			
			// 16. Click on Save 
			driver.findElement(By.xpath("//button[@title='Save']")).click();
			Thread.sleep(5000);
			
			
			//17.Get the text of Error message Displayed and Verify the message
			
			WebElement generalError = driver.findElement(By.xpath("//div[@class='genericNotification']/span"));
			String genError = generalError.getText();
			System.out.println("General Error Message  :"+genError);
			
			WebElement error = driver.findElement(By.xpath("//ul[@class='errorsList']/li"));
			String err = error.getText();
			System.out.println("Specific Error message :"+err);
		
	}

}
