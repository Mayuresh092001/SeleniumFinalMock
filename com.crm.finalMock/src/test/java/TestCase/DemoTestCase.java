package TestCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.FileUtility.accessOrgName;
import com.crm.pom.OrganizationsRepo;
@Listeners(com.crm.Listerners.screenShotListerners.class)
public class DemoTestCase extends com.crm.baseClass.BaseClass{
	@Test
	public void org_page() throws EncryptedDocumentException, IOException, InterruptedException {
		String actual_url = driver.getCurrentUrl();
		OrganizationsRepo or = new OrganizationsRepo(driver);
		
		assertEquals(expected_url, actual_url);
		System.out.println("VTiger verified!!!");
		
		or.organizationsTab().click();
		Thread.sleep(2000);
		or.createButton().click();
		Thread.sleep(2000);
		
		accessOrgName org = new accessOrgName();
		String sheetData = org.orgInfo("Sheet1", 1, 2);
		String orgdata = sheetData + Math.random();
		or.orgName().sendKeys(orgdata);
		String website = org.orgInfo("Sheet1", 1, 3);
		or.website().sendKeys(website);
		String phone = org.orgInfo("Sheet1", 1, 4);
		or.phone().sendKeys(phone);
		
		//or.saveButton().click();
		or.saveButton().click();

		String name_header = or.organizationHeader().getText();
		assertTrue(name_header.contains(orgdata));
		System.out.println("New organization is created");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}