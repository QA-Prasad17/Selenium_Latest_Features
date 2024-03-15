package TestCrome;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.fetch.Fetch;
import org.openqa.selenium.devtools.v120.network.Network;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Program Files/Grid/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request ->
		{
			if(request.getRequest().getUrl().contains("shetty"))
			{
				String mockedurl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockedurl);
				
				devTools.send(Fetch.continueRequest(request.getRequestId(),Optional.of(mockedurl), Optional.of(request.getRequest().getMethod()), 
						Optional.empty(),Optional.empty(), Optional.empty()));
			}
			else{
				
				devTools.send(Fetch.continueRequest(request.getRequestId(),Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()), 
						Optional.empty(),Optional.empty(), Optional.empty()));
			}
			
		});
		

		 driver.get("https://rahulshettyacademy.com/angularAppdemo");
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-landingpage[1]/div[1]/button[1]")).click();
			Thread.sleep(3000);

			//driver.findElement(By.linkText("Library")).click();
			System.out.println(driver.findElement(By.cssSelector("p")).getText());
	}

}
