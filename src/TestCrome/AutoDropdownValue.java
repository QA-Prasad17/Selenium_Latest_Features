package TestCrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoDropdownValue {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Program Files/Grid/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement Dropbox = driver.findElement(By.id("autocomplete"));
		Dropbox.click();
		Dropbox.sendKeys("British Indian Ocean Territory");
		Thread.sleep(2000);
		WebElement select = driver.findElement(By.xpath("//*[@id=\"ui-id-1\"]"));
		select.click();
		driver.close();
	}

}
