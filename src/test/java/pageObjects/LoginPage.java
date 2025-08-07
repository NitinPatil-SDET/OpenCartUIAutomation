package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		}

	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpwd;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnlogin;
	
	
	
	public void setemail(String email) {
		txtemail.sendKeys(email);
	}
	

	public void setpassword(String password) {
		txtpwd.sendKeys(password);
	}
	
	public void clickLoging() {
		btnlogin.click();
	}
}
