package com.start.MavenSeleniumRevision;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class DragAndDrop_TestNg {
	
    WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "Resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void f() {

		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement drageble = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropeble = driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions act = new Actions(driver);
		act.dragAndDrop(drageble, dropeble).perform();	
	}
	

	@AfterMethod
	public void afterMethod() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();
	}

}
