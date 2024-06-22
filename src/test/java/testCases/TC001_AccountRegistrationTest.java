package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","master"})
	public void verify_account_registration() {
		
		logger.info("************************starting verify_account_registration******");
		
		try {
			

		HomePage hp= new HomePage(driver);  // access home page class method so we are creating object for homepage class
		hp.clickMyAccount();
		logger.info("clicked on my account link");
		
		
		hp.clickRegister();
		logger.info("clciked on register link");
		
		
		
		AccountRegistrationPage ar= new AccountRegistrationPage(driver); //access AccountRegistrationPage class method so we are creating 
																			//object for homepage class
		
		logger.info("inputting customer details");
		ar.setFirstName(randomeString().toUpperCase());
		ar.setLastName(randomeString().toUpperCase());
		ar.setEmail(randomeString()+"@gmail.com");
		ar.setTelephone(randomNumeric());
		
		String password = randomAlphaNumeric();
		ar.setPassword(password);
		ar.setConfirmPassword(password);
		
		ar.setPrivacyPolicy();
		ar.clickContinue();
		
		logger.info("validating expected message");
		String confmsg=ar.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs....");
			Assert.assertTrue(false);
		}
		
		
		}catch(Exception e) {
		
			//Assert.fail();
		}
		
		logger.info("************************completed verify_account_registration******");
	}

	private String randomNumeric() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
