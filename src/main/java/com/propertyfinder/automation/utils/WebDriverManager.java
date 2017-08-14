
package com.propertyfinder.automation.utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {

	public static WebDriver getDriver(String platform, String  browser, String nodeURL) {
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("firefox")) {
			String firefoxDriver = System.getProperty("user.dir") + File.separatorChar + "config"
					+File.separatorChar + "geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firefoxDriver);
			ProfilesIni ffProfiles = new ProfilesIni();
			FirefoxProfile profile = ffProfiles.getProfile("customfirefox");
			driver = new FirefoxDriver(profile);
		} else if (browser.equalsIgnoreCase("chrome")) {
			String chromeDriver = System.getProperty("user.dir") + File.separatorChar + "config"
					+File.separatorChar + "chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriver);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if(browser.equalsIgnoreCase("internet explorer")) {
			String ieDriver = System.getProperty("user.dir") + File.separatorChar + "config"
					+File.separatorChar + "IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", ieDriver);
			driver = new InternetExplorerDriver();
		} 
		return driver;
	}
}