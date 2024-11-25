package com.learnAutomation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory
{
    private WebDriver driver;

    /**
     * Initializes the WebDriver instance based on the browser name provided as a system property.
     *
     * @return a WebDriver instance for the specified browser.
     *         Defaults to "chrome" if the browser name is not provided or invalid.
     * @throws IllegalArgumentException if an unsupported browser name is provided.
     */
    public WebDriver getDriver()
    {
        String browserName = System.getProperty("browser","chrome").toLowerCase();
        if(browserName.equals("chrome"))
            driver = new ChromeDriver();
        else if(browserName.equals("firefox"))
            driver = new FirefoxDriver();
        else if(browserName.equals("edge"))
            driver = new EdgeDriver();
        else
            throw new IllegalArgumentException("Invalid Browser name, Please enter valid valid browser name");
        return  driver;
    }

}
