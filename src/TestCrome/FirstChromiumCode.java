package TestCrome;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.emulation.Emulation;

public class FirstChromiumCode {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/Program Files/Grid/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//send command to CDP Methods  -> CDP methods will invoke and get access to chrome dev tools
		
	    devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		long startTime = System.currentTimeMillis();

	    driver.get("https://rahulshettyacademy.com/angularAppdemo");
//	    driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/nav[1]/button[1]")).click();
//	    Thread.sleep(3000);
	    
	    driver.findElement(By.linkText("Library")).click();
	    long endtTime = System.currentTimeMillis();
		System.out.println(endtTime - startTime);
	    
	    
	    
	    
	}

}
