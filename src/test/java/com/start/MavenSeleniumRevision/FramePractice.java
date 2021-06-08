package com.start.MavenSeleniumRevision;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javafx.scene.control.Alert;

public class FramePractice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "Resource\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/package-summary.html");
		//driver.get("http://output.jsbin.com/usidix/1");
		driver.get("https://jqueryui.com/droppable/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		/*//switching First frame//

		WebElement firstframe = driver.findElement(By.xpath("//iframe[@name='packageListFrame']"));
		driver.switchTo().frame(firstframe);
		driver.findElement(By.xpath("//a[text()='org.openqa.selenium.chromium']")).click();

		//switching second frame//

		driver.switchTo().defaultContent();
		WebElement secondframe = driver.findElement(By.xpath("//iframe[@name='classFrame']"));
		driver.switchTo().frame(secondframe);
		driver.findElement(By.xpath("//a[text()='Tree']")).click();

		//switching third frame//

		driver.switchTo().defaultContent();
		WebElement thirdframe = driver.findElement(By.xpath("//iframe[@name='packageFrame']"));
		driver.switchTo().frame(thirdframe);
		driver.findElement(By.xpath("//a[text()='ChromiumDriver']")).click();
*/
		
		// Alert Example
		  /*driver.findElement(By.xpath("//input[@type='button']")).click();
		  Thread.sleep(3000);
		 org.openqa.selenium.Alert alert = driver.switchTo().alert();
		 alert.accept();
		Thread.sleep(3000);
		driver.quit(); */
		
		// Drag and drop example
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement drageble = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropeble = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(drageble, dropeble).perform();
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}

}
