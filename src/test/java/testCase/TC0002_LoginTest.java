package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;

public class TC0002_LoginTest extends BaseClass{
	
	@Test 
	public void verify_login() {
		
		logger.info("---------Starting TC0002_LoginTest--------");
	
		  logger.info("---------HomePage--------");
		 
		//Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("---------LoginPage--------"); 
		//Login Page
		LoginPage lp = new LoginPage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clickLoging();
		
		 logger.info("---------MyAccountPage--------"); 
		//My Account Page
		MyAccountPage macp = new MyAccountPage(driver);
		boolean targetpage = macp.isMyAccontPagExists();
		Assert.assertTrue(targetpage);
		
		}
		
		
	
		
	}


