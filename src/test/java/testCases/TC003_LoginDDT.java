package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	
	
	@Test(groups="Datadriven",dataProvider = "LoginData", dataProviderClass=DataProviders.class)  // getting data provider from different class
	public void TC003_VerifyloginDDT(String email, String pwd, String res) {
		logger.info("*******starting TC003 DDT Login************");
		
		try
		{
			

		//HomePage object
				HomePage hp= new HomePage(driver);
				hp.clickMyAccount();
				hp.clickOnLogin();
				
				// LoginPage object
				LoginPage lp= new LoginPage(driver);
				lp.setEmail(email);
				lp.setPassword(pwd);
				
				lp.clickLogin();
				
				// MyAccount Page
				MyAccountPage myaa= new MyAccountPage(driver);
				boolean targetpage= myaa.isMyAccountPageExists();
				
				
				if(res.equalsIgnoreCase("valid")) {
					if(targetpage==true) {
						Assert.assertTrue(true);
						myaa.clickOnLogout();
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				if(res.equalsIgnoreCase("Invalid")) {
					if(targetpage==true) {
						myaa.clickOnLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
		}catch(Exception e){
			Assert.fail();
		}
		
		logger.info("*******finished TC003 DDT Login************");
	}

}
