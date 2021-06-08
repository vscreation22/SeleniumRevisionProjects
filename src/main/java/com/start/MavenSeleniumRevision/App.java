package com.start.MavenSeleniumRevision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App 
{
	public static void main( String[] args ) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "Resource\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String parentwin = driver.getWindowHandle();

		Set<String> multiplewindow = driver.getWindowHandles();

		for(String win : multiplewindow)
		{
			driver.switchTo().window(win);
			System.out.println(driver.getTitle());

			if(! "Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com".equals(driver.getTitle()))
			{
				driver.close();
			}
		}

		driver.switchTo().window(parentwin);

		System.out.println(driver.getTitle());
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='wdgt-action-btn ']"))).click();


		js.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//a[@title='Create Job Alert']")).click(); // ElementClickInterceptedException()


		// ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles()); 
		// if (!availableWindows.isEmpty()) { 
		// driver.switchTo().window(availableWindows.get(1)); 
		
		Set<String> availableWindows = driver.getWindowHandles();
		for(String win1 : availableWindows)
		{
			if(!parentwin.equals(win1))
			{
				driver.switchTo().window(win1);
				driver.findElement(By.xpath("//input[@id='Sug_kwdsugg']")).sendKeys("selenium");
			}
		}

		Thread.sleep(3000);
		driver.quit();

	}
}
