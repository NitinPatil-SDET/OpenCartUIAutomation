package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC0003_DDTLogin extends BaseClass {
	
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_DDTLogin(String email, String pwd, String exp) {
		
		logger.info  ("----Starting TC0003------");
		
		try {
		//Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//Login Page
		LoginPage lp = new LoginPage(driver);
		lp.setemail(p.getProperty(email));
		lp.setpassword(p.getProperty(pwd));
		lp.clickLoging();
		
		
		//My Account Page
		MyAccountPage macp = new MyAccountPage(driver);
		boolean targetpage = macp.isMyAccontPagExists();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetpage==true) {
				macp.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetpage==true) {
				macp.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e) {
			Assert.assertTrue(false);
		}
		
		
		logger.info("----Finish TC0003");
		
	}

}
