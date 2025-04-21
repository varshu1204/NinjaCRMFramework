package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.webdriverUtility.WebDriverUtility;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(linkText="Campaigns")
	private WebElement campaign;
	
	@FindBy(linkText="Contacts")
	private WebElement contacts;
	
	@FindBy(linkText="Leads")
	private WebElement leads;
	
	@FindBy(linkText="Opportunities")
	private WebElement opp;
	
	@FindBy(linkText="Products")
	private WebElement product;
	
	@FindBy(linkText="Quotes")
	private WebElement quote ;
	
	@FindBy(linkText="Purchase Order")
	private WebElement PO;
	
	@FindBy(linkText="Sales Order")
	private WebElement SO;
	
	@FindBy(linkText="Invoice")
	private WebElement invoice;
	
	@FindBy(linkText="Admin Console")
	private WebElement adminconsole;
	
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement createcampaign;
	
	@FindBy(xpath="//div[@class='dropdown-item logout']")
	private WebElement logout;

	@FindBy(xpath="//button[@aria-label='close']")
	private WebElement close;
	
	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getLeads() {
		return leads;
	}

	public WebElement getOpp() {
		return opp;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getQuote() {
		return quote;
	}

	public WebElement getPO() {
		return PO;
	}

	public WebElement getSO() {
		return SO;
	}

	public WebElement getInvoice() {
		return invoice;
	}

	public WebElement getAdminconsole() {
		return adminconsole;
	}

	public WebElement getCreatecampaign() {
		return createcampaign;
	}
	
	public WebElement getLogout() {
		return logout;
	}
	
	public WebElement getClose() {
		return close;
	}
	
	
	
	public void campaign() throws InterruptedException {
		Thread.sleep(5000);
		campaign.click();
		createcampaign.click();
		
		
	}
	
	public void logoutApp() {
		WebDriverUtility wlib=new WebDriverUtility();
		WebElement ele = driver.findElement(By.xpath("//div[@class='user-icon']"));
		wlib.mouseHover(driver, ele);
		logout.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
