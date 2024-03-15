package TestCrome;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.ConnectionType;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Program Files/Grid/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTools.send(
				Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));
		devTools.addListener(Network.loadingFailed(), loadingfailed ->
		{
			System.out.println(loadingfailed.getErrorText());
			System.out.println(loadingfailed.getTimestamp());
		});
		long startTime = System.currentTimeMillis();

		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		// driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/nav[1]/button[1]")).click();

		driver.findElement(By.linkText("Library")).click();

		long endtTime = System.currentTimeMillis();
		System.out.println(endtTime - startTime);
		driver.close();

	}

}
