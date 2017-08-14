package com.propertyfinder.automation.utils;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;


public class WindowDriverFactory {
	
    private static Map<String, WebDriver> webDriverPool = new HashMap<String, WebDriver>();

    public static WebDriver getWebDriver(String platform, String browser, String nodeURL) throws Exception {
        String key = getKey(platform, browser, nodeURL);
        WebDriver driver = webDriverPool.get(key);
        if (driver == null) {
            driver = WebDriverManager.getDriver(platform, browser, nodeURL);
            webDriverPool.put(key, driver);
        }
        return driver;
    }

    private static String getKey(String platform, String browser, String nodeURL) {
        return String.format("%s~%s~%s", platform, browser, nodeURL);
    }
}
