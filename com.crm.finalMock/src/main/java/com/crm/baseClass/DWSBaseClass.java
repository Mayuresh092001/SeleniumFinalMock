package com.crm.baseClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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


import com.crm.FileUtility.DWSAccessURLandBrowser;
import com.crm.pom.DWSLogin;
import com.crm.pom.DWSLogout;




public class DWSBaseClass {
public static WebDriver driver = null;
public static Properties prop;
public static DWSAccessURLandBrowser browser;
public static String expected_url = "https://demowebshop.tricentis.com/";

@BeforeSuite
public void  beforeSuite()
{
System.out.println("BeforeSuite");
}

@BeforeTest
public void beforeTest()
{
System.out.println("BeforeTest");
}

@AfterTest
public void afterTest()
{
driver.quit();
}

@BeforeClass
public static void preCondition() throws IOException {

browser = new DWSAccessURLandBrowser();
String br = browser.accessBrowser("browser");


if(br.equalsIgnoreCase("Chrome"))
{
driver = new ChromeDriver();
}
else if(br.equalsIgnoreCase("Edge"))
{
driver = new EdgeDriver();
}
else if(br.equalsIgnoreCase("Firefox"))
{
driver = new FirefoxDriver();
}
else
{
driver = new ChromeDriver();
}

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

String url = browser.accessBrowser("url");
driver.get(url);
}


@BeforeMethod
public static void login() throws  IOException
{
assertEquals(expected_url, driver.getCurrentUrl());
DWSLogin lp = new DWSLogin(driver);
lp.login();

}

@AfterMethod
public static void aftermethod() throws InterruptedException
{
Thread.sleep(2000);
DWSLogout lr = new DWSLogout(driver);
lr.logout().click();
}

@AfterClass
public static void postCondition() throws InterruptedException
{
driver.close();
Thread.sleep(2000);
}

@AfterSuite
public void  afterSuite()
{
System.out.println("AfterSuite");
}
}
