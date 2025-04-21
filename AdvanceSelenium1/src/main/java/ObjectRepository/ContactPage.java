package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	WebDriver driver;
	public ContactPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Create Contact']")
	private WebElement createContct;
	
	@FindBy(name="organizationName")
	private WebElement org;
	
	@FindBy(name="title")
	private WebElement title;
	
	@FindBy(name="contactName")
	private WebElement cname1;
	
	@FindBy(name="mobile")
	private WebElement mobile;
	
    @FindBy(xpath="(//button[@type='button'])[2]")
    private WebElement button;
    
    @FindBy(xpath="//button[text()='Create Contact']")
    private WebElement createContactButton;

	public WebElement getCreateContct() {
		return createContct;
	}

	public WebElement getOrg() {
		return org;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getCname1() {
		return cname1;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getButton() {
		return button;
	}

	public WebElement getCreateContactButton() {
		return createContactButton;
	}

	public WebDriver getDriver() {
		return driver;
	}







}
