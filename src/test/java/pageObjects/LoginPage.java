package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	WebDriver driver;
	
	// constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	// >Locators
	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	WebElement txtpassword;
	
	
	@FindBy(xpath="//input[@value=\"Login\"]")
	WebElement login_btn;
	
	
	// Action Methods
	
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		login_btn.click();
	}
}
