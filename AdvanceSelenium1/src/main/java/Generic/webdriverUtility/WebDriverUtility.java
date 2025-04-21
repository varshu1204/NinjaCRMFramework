package Generic.webdriverUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPagetoLoad(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void switchToBrowser(WebDriver driver) {
		String parentid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		allid.remove(parentid);
		for (String windowid : allid) {
			driver.switchTo().window(windowid);
		}
		

	}
    
	public void switchBack(WebDriver driver)
	{
		String parentid = driver.getWindowHandle();
         driver.switchTo().window(parentid);
	}
	
	public void frame(WebDriver driver, int index)

	{
		driver.switchTo().frame(index);
	}

	public void frame(WebDriver driver, String nameId)

	{
		driver.switchTo().frame(nameId);
	}

	public void frame(WebDriver driver, WebElement element)

	{
		driver.switchTo().frame(element);
	}

	public void alertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void alertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void select(WebElement element, int index)

	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void select(WebElement element, String text)

	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void mouseHover(WebDriver driver, WebElement element)

	{

		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();

	}

}
