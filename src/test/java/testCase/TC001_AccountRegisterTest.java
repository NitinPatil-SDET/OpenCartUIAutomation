package testCase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.accountRegisterPage;
import testbase.BaseClass;

public class TC001_AccountRegisterTest extends BaseClass {
	
	
	@Test
	public void verify_account_registration() throws InterruptedException {
		
		logger.info("***** Starting TC001_AccountRegisterTest ****");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("***** Click on My Account ****");
		
		hp.clickRegister();
		logger.info("***** Click on Register ****");
		
		accountRegisterPage regpage = new accountRegisterPage(driver);
		
		logger.info("***** Inserting the all details ****");
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String pwd = randomAlphaNumeric();
		regpage.setPassword(pwd);
		regpage.setconfirmPassword(pwd);
	
		Thread.sleep(3000);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg = regpage.getConfirmationMsg();
		AssertJUnit.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("***** Validating message ****");
		System.out.println(confmsg);
		
		logger.info("***** Finish TC001_AccountRegisterTest ****");
		
	} 

	
}
	
	

