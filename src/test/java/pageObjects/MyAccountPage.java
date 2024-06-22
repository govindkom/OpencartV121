package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	WebDriver driver;
	
	// constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	// Locator 
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	
	@FindBy(xpath="//div[@class=\"list-group\"]//a[text()='Logout']")
	WebElement btnLogout;
	
	
	public void clickOnLogout() {
		btnLogout.click();
	}
	
	public boolean isMyAccountPageExists() {
		
		try
		{
		return	(msgHeading.isDisplayed());
		} 
		catch (Exception e)
		{
			return false;
		}
		
	}
	
	
}
