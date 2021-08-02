import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyTestDemo {
	
	static WebDriver driver;
	
	/*
	@Before
	public void setup() throws MalformedURLException{
		System.out.println("Running Test in docker Container <<Chrome>>");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
							cap.setPlatform(Platform.WINDOWS);
							cap.setVersion("");
//		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/webdriver/chromedriver.exe");
		driver = new ChromeDriver();
	}*/
	
	
	@Before
	public void setup() throws MalformedURLException{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/webdriver/chromedriver.exe");

		//Creating an object of ChromeDriver
		//WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Deleting all the cookies
		driver.manage().deleteAllCookies();

		//Specifiying pageLoadTimeout and Implicit wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//launching the specified URL
		driver.get("https://www.google.com/");

		//Locating the elements using name locator for the text box
		driver.findElement(By.name("q")).sendKeys("YouTube");

		//name locator for google search button
		WebElement searchIcon = driver.findElement(By.name("btnK"));
		searchIcon.click();
	}
	
	@org.junit.Test
	public void navigationTest() throws Exception{
		MyScreenRecorder.startRecording("navigationTest");
		
		driver.get("http://www.google.com");
		driver.navigate().to("http://www.facebook.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		
		MyScreenRecorder.stopRecording();
	}
	
	@org.junit.Test
	public void navigation_FeatureTest() throws Exception{
		MyScreenRecorder.startRecording("navigation_FeatureTest");
		
		driver.get("http://www.amazon.com");
		driver.navigate().to("http://www.rediff.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();

		
		MyScreenRecorder.stopRecording();
	}
	
	
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	

}
