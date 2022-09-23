package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class IntialSetUp {

	// private static final CharSequence Keys = null;//dont know how I got this line
	By ALLButton = By.xpath("(//span[text()='All'])[2]");
	By searchfield = By.xpath("//input[@type='text']");
    By Players=By.xpath("//span[text()='MP3 & MP4 Players']");
    By Message=By.xpath("(//span[@class='a-truncate-cut'])[1]");
	public void setup() {
		//WebDriverManager.chromedriver().setup();
		 System .setProperty("webdriver.chrome.driver","C:\\Users\\kiran\\OneDrive\\Documents\\selenium\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		driver.findElement(searchfield).sendKeys("ipod");
		driver.findElement(searchfield).sendKeys(Keys.ENTER);
		driver.findElement(Players).click();
		
		String Expected_value ="80 hrs long battery life with just 1.5hrs charging";
		String Actual_value= driver.findElement(Message).getText();
		
		if(Actual_value.equalsIgnoreCase(Expected_value)) {
			System.out.println("The text is matching");
			
		}else
			System.out.println("The text is NOT matching");
		
		
		
//		
//		// driver.findElement(searchfield).sendKeys("Iphone14").click();error why
//		driver.findElement(searchfield).sendKeys("Iphone14");
//
//		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
//		//wait.until(ExpectedConditions.visibilityofElementlocated(name));
//
//		driver.findElement(searchfield).sendKeys(Keys.ENTER);
//		// driver.findElement(ALLButton).click();
//		String ExpectedValue = "https://www.amazon.com/s?k=Iphone14&crid=25VKWDGCRBSNF&sprefix=iphone14%2Caps%2C62&ref=nb_sb_noss_2";
//		String ActualValue = driver.getCurrentUrl();
//		System.out.println(ActualValue);
//		if (ActualValue.equals(ExpectedValue)) {
//			System.out.println("We have landed on correct page");
//		} else {
//			System.out.println("We have landed on incorrect page");
//		}

	}
}