package com.automation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class AmazomAutomation {
	By searchfield1 = By.xpath("//input[@type='text']");
	By Backpack = By.xpath("//span[text()='Backpacks']");
	By buyNow = By.xpath("//input[@id='buy-now-button']");
	
	By HikingBackpack = By.xpath("//span[contains(text(),'Inch Laptop Backpack For Women')]");
	By backpack = By.xpath("//span[@class='a-color-state a-text-bold']");
	By Email=By.xpath("//input[@name='email']");
	By Createaccount=By.xpath("//a[@id='createAccountSubmit']");
	By dropdown=By.xpath("//span[@class='a-button-text a-declarative']");
	By afghan=By.xpath("//a[@id='auth-country-picker_0']");
	

	public void setup() {
		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kiran\\OneDrive\\Documents\\selenium\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.findElement(searchfield1).sendKeys("school backpack");
		driver.findElement(searchfield1).sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(backpack));
		
		
		String ExpectedValue = "\"school backpack\"";
//		String value = " \"ROM\" ";

		System.out.println(ExpectedValue);

		String ActualValue =driver.findElement(backpack).getText() ;
		System.out.println(ActualValue);
		if(ActualValue.equals(ExpectedValue)) {	                                       			
			System.out.println("we are on the same page");
	
			}else {
				System.out.println("we are on wrong page");

			}
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		driver.findElement(HikingBackpack).click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(buyNow));

		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String actual : handles) {
			if (!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
				driver.findElement(buyNow).click();
				driver.findElement(Email).sendKeys("\"2346859\"");
				driver.findElement(Createaccount).click();
				driver.findElement(dropdown).click();
				 wait.until(ExpectedConditions.visibilityOfElementLocated(afghan));
				driver.findElement(afghan).click();
				driver.close();
				
				
				
			}
			//wait.until(ExpectedConditions.visibilityOfElementLocated(buyNow));
			

		}
		
	}

}
