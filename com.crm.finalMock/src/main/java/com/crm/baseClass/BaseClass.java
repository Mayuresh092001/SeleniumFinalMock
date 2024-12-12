package com.crm.baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.FileUtility.AccessUrlandBrowser;
import com.crm.pom.LoginRepo;
import com.crm.pom.LogoutRepo;

public class BaseClass {
	public static WebDriver driver = null;
	public static String expected_url="http://localhost:8888/index.php?action=index&module=Home";
	
	@BeforeClass
	public void preCondition() throws IOException {
		String browser = null;
		AccessUrlandBrowser r = new AccessUrlandBrowser();
		browser=r.accessBrowser("browser");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
		
		driver.get(r.accessBrowser("url"));
	}
	
	@BeforeSuite
	public void BeforeSuite() {
		
	}
	@BeforeTest
	public void BeforeTest() {
		
	}
	@BeforeMethod
	public void BeforeMethod() throws IOException {
		LoginRepo r = new LoginRepo(driver);
		r.login();
		
	}
	@AfterMethod
	
		public void logout() throws InterruptedException {
			LogoutRepo lr = new LogoutRepo(driver);
			Thread.sleep(2000);
			lr.logout_icon().click();
			lr.logout().click();
		}
		
		
	@AfterSuite
	public void AfterSuite() {
		
	}
	@AfterTest
	public void AfterTest() {
		
	}
	@AfterClass
	public void AfterMethod() {
		driver.quit();
		
	}

}
