package TestCrome;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Program Files/Grid/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("Prasad Gorivale");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test123@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys("test@123");
		driver.findElement(By.xpath("//label[@for='exampleCheck1']")).click();
		driver.findElement(By.xpath("//*[@id=\"exampleFormControlSelect1\"]/option[1]")).click();
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.name("bday")).sendKeys("12/02/1992");
		driver.findElement(By.cssSelector(".btn-success")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		driver.close();


		
		
		
		





		

	}

}
