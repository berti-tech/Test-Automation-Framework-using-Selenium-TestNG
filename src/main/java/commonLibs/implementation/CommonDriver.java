package commonLibs.implementation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonDriver {
	
	private WebDriver driver;
	
	private int pageLoadTimeout;
	
	private int elementDetectionTimeout;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	private String currentWorkingDirectory;
	
	public CommonDriver(String browserType) throws Exception {
		pageLoadTimeout = 10;
		elementDetectionTimeout = 10;
		currentWorkingDirectory = System.getProperty("user.dir");
		// Invoking Browser
		if(browserType.equalsIgnoreCase("chrome")) {
			
			// Invoke the chrome browser
			System.setProperty("webdriver.chrome.driver", currentWorkingDirectory + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver", currentWorkingDirectory + "/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("Invalid Browser Type" + browserType);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	public void closeAllBrowser() {
		driver.quit();
	}
	
	public String getTitleOfThePage() {
		return driver.getTitle();
	}
	
	public void navigateToURL(String url) {
		// Setting the timeout and navigating to a URL
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));
		
		driver.get(url);
	}
}
