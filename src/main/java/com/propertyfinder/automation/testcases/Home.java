package com.propertyfinder.automation.testcases;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.propertyfinder.automation.utils.WindowDriverFactory;


public class Home    
{
	private ITestContext context;
	private WebDriver driver;
	
	@BeforeClass
	@Parameters({ "platform","browser", "nodeURL"})
	public void setup(String platform,String browser, String nodeURL, ITestContext context) {
		try {
			driver = WindowDriverFactory.getWebDriver(platform, browser, nodeURL);
			context.setAttribute("driver", driver);
			driver.get("http://propertyfinder.qa");
		} catch (Exception e) {
			// TODO Auto-generated catch block
            throw new WebDriverException(e.getMessage());
		}
	}

	@Test
	public void Filter_Agent_Count() throws InterruptedException {
		driver.navigate().to("http://propertyfinder.ae");
		driver.findElement(By.cssSelector(".js-find-agent")).click();
		driver.findElement(By.cssSelector(".search-filter:nth-child(2)")).click();
		driver.findElement(By.cssSelector(".ms-drop.multiple li:nth-child(4)")).click();
		driver.findElement(By.cssSelector(".ms-drop.multiple li:nth-child(13)")).click();
		driver.findElement(By.cssSelector(".ms-drop.multiple li:nth-child(14)")).click();
		driver.findElement(By.cssSelector(".search-filter:nth-child(2)")).click();
		driver.findElement(By.cssSelector(".submit")).click();
		String agents = driver.findElement(By.cssSelector(".serp-h1")).getText();
		System.out.println("agents" + agents);
		driver.findElement(By.xpath("//*[@id='find-an-agent']/form/div[1]/div/div/div[2]/div[3]/div/button")).click();
		driver.findElement(By.xpath("//*[@id='find-an-agent']/form/div[1]/div/div/div[2]/div[3]/div/div/ul/li[31]")).click();
		Thread.sleep(2000);
		String indianagents = driver.findElement(By.cssSelector(".serp-h1")).getText();
		Assert.assertEquals(agents, indianagents);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}