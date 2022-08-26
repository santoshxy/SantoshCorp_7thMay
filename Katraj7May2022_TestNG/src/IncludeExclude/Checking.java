package IncludeExclude;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Checking {
	static WebDriver driver;
	@BeforeTest 
	public void BrowserLunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\selinium\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();}
	
	@Test(priority=1)
	public void verifyUrlOfPge() {
		String url= driver.getCurrentUrl();
		SoftAssert SoftAssert= new SoftAssert();
		SoftAssert.assertEquals(url, "https://www.flipkart.com/","verifying url");
        System.out.println("next after softassert");
        SoftAssert.assertAll();}
	
	@Test(priority=2)
	public void verifyingTitleOfPage() {
		String pagetext= driver.findElement(By.cssSelector("._36KMOx")).getText();
		SoftAssert SoftAssert= new SoftAssert();
		SoftAssert.assertEquals(pagetext, "Login","verfying text");
		System.out.println("next after softassert");
		SoftAssert.assertAll();}
	
	@Test(priority=3)
	public void verifyingUpperIconGlosary() {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		String pagetext= driver.findElement(By.xpath("//*[text()='Grocery']")).getText();
		Assert.assertEquals(pagetext, "Grocery","Icon is present");
	}
	@Test(priority=4)
	public void verifyingUpperIconTopOffer() {
		String pagetext= driver.findElement(By.xpath("//*[text()='Top Offers']")).getText();
		Assert.assertEquals(pagetext, "Top Offers","Icon is present");
	}
      @AfterTest
	public void tearDown() {
		driver.quit();
		
	}

}
