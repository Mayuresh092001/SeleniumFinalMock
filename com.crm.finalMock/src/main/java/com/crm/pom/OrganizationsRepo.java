package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsRepo {
	public OrganizationsRepo(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement organizations_tab;
	public WebElement organizationsTab()
	{
		return organizations_tab;
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement create_button;
	public WebElement createButton() {
		return  create_button;
	}
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement org_name;
	public WebElement orgName() {
		return org_name;
	}
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement save_button;
	public WebElement saveButton() {
		return save_button;
	}
	@FindBy(xpath="//div[@class='small']/table/tbody/tr/td/span")
	private WebElement organization_header;
	public WebElement organizationHeader() {
		return organization_header;
	}
	
	
	@FindBy(xpath = "(//input[@class='detailedViewTextBox'])[2]")
	private WebElement website;
	public WebElement website() {
		return website;
	}
	
	@FindBy(xpath = "(//input[@class='detailedViewTextBox'])[3]")
	private WebElement phone;
	public WebElement phone() {
		return phone;
	}
	
	


}