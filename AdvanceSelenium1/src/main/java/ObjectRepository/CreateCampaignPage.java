package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	WebDriver driver;
	
	public CreateCampaignPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(name="campaignName")
	private WebElement cname;
	
	@FindBy(name="targetSize")
	private WebElement size;
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement createbtn;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement msg;
	
	
	@FindBy(name="expectedCloseDate")
	private WebElement expectedCloseDate;

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getMsg() {
		return msg;
	}

	public WebElement getCname() {
		return cname;
	}

	public WebElement getSize() {
		return size;
	}

	public WebElement getCreatebtn() {
		return createbtn;
	}
	
	
	public void createcampaign(String CNAME,String SIZE)
	{
		cname.sendKeys(CNAME);
		size.sendKeys(SIZE);
	}
	
	
	
	
	
	
	
	

}
