package TestCrome;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Program Files/Grid/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		WebElement table = driver.findElement(By.id("product"));

        // Count the number of rows in the table
        int rowCount = table.findElements(By.tagName("tr")).size();
        int columnCount = table.findElements(By.tagName("th")).size();

        System.out.println(rowCount);
        System.out.println(columnCount);
     //  driver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[3]/td[1]"));
        String secondRow = driver.findElement(By.xpath("//*[@id=\"product\"]/tbody/tr[3]")).getText();
        System.out.println(secondRow);
      
        driver.close();


	}
}
     
	


