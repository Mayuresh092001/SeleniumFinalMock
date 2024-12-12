package TestCase;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.crm.FileUtility.AccessExcelTwitter;
import com.crm.baseClass.DWSBaseClass;
import com.crm.pom.TwitterAccount;

@Listeners(com.crm.Listerners.screenShotListerners.class)
public class TwitterTestCase extends DWSBaseClass{
@Test
public void createAccount() throws InterruptedException, EncryptedDocumentException, IOException {
String parent = driver.getWindowHandle();

TwitterAccount cr = new TwitterAccount(driver);
cr.twitter().click();
Thread.sleep(1000);

Actions act = new Actions(driver);
act.keyDown(Keys.PAGE_DOWN);
act.keyDown(Keys.PAGE_DOWN);

Set<String> twitterHandle = driver.getWindowHandles();
for (String str : twitterHandle) {
driver.switchTo().window(str);
}
Thread.sleep(2000);
cr.create_account().click();
Thread.sleep(1000);
AccessExcelTwitter exc = new AccessExcelTwitter();
String sheetdata = exc.orgInfo("Sheet1", 1, 5);
cr.name().sendKeys(sheetdata);

String sheetemail = exc.orgInfo("Sheet1", 1, 6);
cr.email().sendKeys(sheetemail);

Select sel = new Select(cr.month());
sel.selectByVisibleText("Maya");

Select sel1 = new Select(cr.day());
sel1.selectByVisibleText("15");

Select sel2 = new Select(cr.year());
sel2.selectByVisibleText("2002");
Thread.sleep(2000);

driver.switchTo().window(parent);
Thread.sleep(2000);
}

}