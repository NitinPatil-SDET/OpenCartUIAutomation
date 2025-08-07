package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class accountRegisterPage extends BasePage {

	public accountRegisterPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txttelephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtconfirmpassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdpolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	

	
	
	
	public void setFirstName(String fname) {
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtlastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setTelephone(String telephone) {
		txttelephone.sendKeys(telephone);
	}
	
	public void setPassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void setconfirmPassword(String password) {
		txtconfirmpassword.sendKeys(password);
	}
	
	public void setPrivacyPolicy() {
		chkdpolicy.click();
	}
	
	public void clickContinue() {
		//btnContinue.click();
		
		//btnContinue.submit();
		
		Actions act = new Actions(driver);
		act.moveToElement(btnContinue).click().perform(); 
		
	}
		
public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	}
	catch(Exception e) {
		return (e.getMessage());
	}
}
	
	
}
