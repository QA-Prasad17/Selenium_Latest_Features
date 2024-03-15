package TestCrome;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class BypassCDP {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Program Files/Grid/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String,Object> DeviceMetrics = new HashMap<String,Object>();
		DeviceMetrics.put("width", 600);
		DeviceMetrics.put("height", 1000);
		DeviceMetrics.put("deviceScaleFactor", 50);
		DeviceMetrics.put("mobile", true);

		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", DeviceMetrics);
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/nav[1]/button[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Library")).click();

	}

}
