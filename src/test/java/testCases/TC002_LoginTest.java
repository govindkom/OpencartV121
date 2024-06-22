package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	
	
	@Test(groups={"sanity", "master"})
	public void Verify_Login() {
		logger.info("********starting TC002_ Login test****************");
		
		
		try
		{
	
		//HomePage object
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickOnLogin();
		
		// LoginPage object
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("ghjkkjhg@gmail.com"));
		lp.setPassword(p.getProperty("ghjkkjhg@gmail.com"));
		
		lp.clickLogin();
		
		// MyAccount Page
		MyAccountPage myaa= new MyAccountPage(driver);
		boolean targetpage= myaa.isMyAccountPageExists();
		
		Assert.assertTrue(targetpage);
		//Assert.assertEquals(targetpage, true, "Login Failed");
		}
		catch (Exception e) 
		{
			//Assert.fail();
		}
		
		logger.info("********finished TC002_ Login test****************");
		
	}

}
