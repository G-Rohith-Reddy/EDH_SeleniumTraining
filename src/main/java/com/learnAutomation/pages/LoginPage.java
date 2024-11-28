package com.learnAutomation.pages;

import com.learnAutomation.util.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * LoginPage class represents the login page of the application and provides methods
 * to interact with its elements. This class extends BasePage to reuse common functionalities.
 */
public class LoginPage extends BasePage
{
    /**
     * Constructor to initialize the LoginPage with a WebDriver instance.
     *
     * @param driver WebDriver instance to interact with the login page.
     */
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    // Locators for the web elements on the login page
    private By userNameField = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.cssSelector("button[type=\"submit\"]");

    /**
     * Navigates to the login page using the base URL provided in the configuration file.
     */
    public void navigateToPage()
    {
        navigateTo(ConfigReader.getProperty("baseUrl"));
    }

    /**
     * Logs into the application by using the credentials fetched from the configuration file.
     */
    public boolean login()
    {
        writeText(userNameField,ConfigReader.getProperty("userName"),30);
        writeText(password,ConfigReader.getProperty("password"));
        clickElement(loginButton);
        LeftNavBarPage leftnavBar = new LeftNavBarPage(this.driver);
        return leftnavBar.logoDisplayed();
    }
}
