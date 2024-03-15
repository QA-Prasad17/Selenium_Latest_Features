package TestCrome;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.fetch.Fetch;
import org.openqa.selenium.devtools.v120.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/Program Files/Grid/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*jpg*", "*.css*")));
		long startTime = System.currentTimeMillis();
		//System.out.println(startTime);
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.findElement(By.linkText("Browse Products")).click();
		
//		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-landingpage[1]/div[1]/p[2]/a[1]")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
//		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.cssSelector(".btn-success")).click();
		driver.findElement(By.id("InputName")).sendKeys("Prasad");
		driver.findElement(By.id("LastName")).sendKeys("Gorivale");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("test@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("password@1234");
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-checkoutform[1]/div[1]/form[1]/div[5]/label[1]")).click();
		driver.findElement(By.cssSelector(".btn-primary")).click();


		long endtTime = System.currentTimeMillis();
		System.out.println(endtTime - startTime);

		
		
		
		
	}

}
