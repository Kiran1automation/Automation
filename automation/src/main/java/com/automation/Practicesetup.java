package com.automation;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class Practicesetup {

	By searchfield = By.xpath("//input[@type='text']");
	By Freeshipping = By.xpath("//span[text()='Eligible for Free Shipping']");
	By computersandtablets = By.xpath("//span[text()='Computers & Tablets']");
	By Iphone14 = By.xpath("//*[contains(text(),'Apple iPhone 11')]");
	By BuyNow = By.xpath("//input[@title='Add to Shopping Cart']");
	By Proceed =By.xpath("(//input[@type='submit'])[22]");
	public void setup() {
		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kiran\\OneDrive\\Documents\\selenium\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.findElement(searchfield).sendKeys("iphone 11");
		driver.findElement(searchfield).sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Iphone14));
		
		driver.findElement(Iphone).click();
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(BuyNow));
		
		String currentHandle= driver.getWindowHandle();
		Set<String> handles= driver.getWindowHandles();
		for(String actual: handles) {
		if(!actual.equalsIgnoreCase(currentHandle)) {
		driver.switchTo().window(actual);
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BuyNow));
		
		driver.findElement(BuyNow).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Proceed));
		driver.findElement(Proceed).click();
		
		}
		
		

		
		
		
		
		
		
		// driver.findElement(Freeshipping).click();
		//driver.findElement(computersandtablets).click();

	}
}