package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
	private  WebElement UN;
	 
	@FindAll({@FindBy(id="inputPassword"),@FindBy(name="password")})
	private WebElement PW;

	
//	@FindBys({@FindBy(id="inputPassword"),@FindBy(name="password")})
//	private WebElement PW;
//	
	@FindBy(xpath="//button[text()='Sign In']")
	 private WebElement loginbtn;
	
	@FindBy(linkText="Forgot password?")
	 private WebElement FPWD;

	public WebElement getUN() {
		return UN;
	}

	public WebElement getPW() {
		return PW;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getFPWD() {
		return FPWD;
	}
	
	
	public void login(String username,String password) {
		
		
		UN.sendKeys(username);
		PW.sendKeys(password);
		loginbtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
