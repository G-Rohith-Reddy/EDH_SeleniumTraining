package com.learnAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftNavBarPage extends BasePage{
    public LeftNavBarPage(WebDriver driver) {
        super(driver);
    }
    private By logo = By.cssSelector("img[alt='client brand banner']");

    public boolean logoDisplayed()
    {
        return this.isElementVisible(logo,30);
    }
}
