package com.start.MavenSeleniumRevision;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Webtable_Example {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "Resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);



		Webtable_Example.webtable(); // calling Webtable method

	}

	public static void webtable() throws InterruptedException
	{
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("admin123");
		WebElement LoginBtn = driver.findElement(By.id("btnLogin"));
		LoginBtn.click();
		WebElement Adminopt = driver.findElement(By.id("menu_admin_viewAdminModule"));
		Adminopt.click();

		WebElement admin = driver.findElement(By.id("searchSystemUser_userType"));
		Select select = new Select(admin);
		select.selectByValue("1");

		WebElement admsearchbtn = driver.findElement(By.id("searchBtn"));
		admsearchbtn.click();

		List<WebElement> tablesize = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println(tablesize.size());

		for(int i=1; i<= tablesize.size(); i++)
		{
			WebElement empname = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]"));
			System.out.println(empname.getText());

			if("John Smith".equals(empname.getText()))
			{
				WebElement usernamecheck = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]/input"));
				usernamecheck.click();
			}

		}

		Thread.sleep(3000);
		driver.quit();

	}  
}
