import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginAutomated {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.homes.com/");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@class='site-header site-header--page-home site-header--homepage-width site-header--theme-dark']//span[@class='icon icon--person icon--profile']")));
			Actions icon = new Actions(driver);
			icon.moveToElement(driver.findElement(By.xpath("//header[@class='site-header site-header--page-home site-header--homepage-width site-header--theme-dark']//span[@class='icon icon--person icon--profile']"))).build().perform();
	
			
		driver.findElement(By.xpath("//a[contains(text(), 'Sign In')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Sign In with Email')]")).click();
		driver.findElement(By.id("login-email")).sendKeys("stasblanar@gmail.com");
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//input[@id='login-password']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login-password")));
		driver.findElement(By.id("login-password")).sendKeys("test1234");
		driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#CTALin")));
		driver.findElement(By.cssSelector("#CTALin")).click();
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, "https://www.homes.com/myhomes/");
		System.out.println("User successfuly logged in");
		
		driver.close();
	
	}

}
