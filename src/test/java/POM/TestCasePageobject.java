package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePageobject {

	public WebDriver BrowserDriver;	
	
	TestCasePageobject(WebDriver BrowserDriver){
		//BrowserDriver=this.BrowserDriver;
		PageFactory.initElements(BrowserDriver, this);
	}
	
	@FindAll({@FindBy(css="input[placeholder='Username']"),@FindBy(name="username")})
	private WebElement Username;
	public WebElement getUsername() {
		return Username;
	}
	@FindBy(css="input[placeholder='Password']")
	private WebElement Password;
	public WebElement getPassword() {
		return Password;
		
	}
	@FindBy(css="button[type='submit']")
	private WebElement Login;
	public WebElement getLogin() {
		return Login;
	}
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement BackIcon;
	public WebElement getBackIcon() {
		return BackIcon;
	}
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement Logout;
	public WebElement getLogout() {
		return Logout;
		
	}
}
