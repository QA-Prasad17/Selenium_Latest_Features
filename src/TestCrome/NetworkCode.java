package TestCrome;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.Request;
import org.openqa.selenium.devtools.v120.network.model.Response;


public class NetworkCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Program Files/Grid/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.addListener(Network.requestWillBeSent(), request ->
		{
			Request req = request.getRequest();
			//System.out.println(req.getUrl());
			//System.out.println(req.getHeaders());

		});
		
		//Event will be fire
		devTools.addListener(Network.responseReceived(), response ->
		{
			Response res = response.getResponse();
		    // System.out.println(res.getUrl());
			//System.out.println(res.getStatus());
			
			if(res.getStatus().toString().startsWith("4"))
			{
				System.out.println(res.getUrl()+"status code is failing"+res.getStatus());
			}
		});
		
		 driver.get("https://rahulshettyacademy.com/angularAppdemo");
		 driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-landingpage[1]/div[1]/button[1]")).click();
				
				
		

	}

}
