package com.learnAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage class provides common methods for interacting with web elements
 * and managing WebDriver interactions. This class serves as a parent class
 * for page-specific classes in a Page Object Model (POM) framework.
 */
public class BasePage {
    protected WebDriver driver;

    /**
     * Constructor to initialize the BasePage with a WebDriver instance.
     *
     * @param driver WebDriver instance to be used for interacting with the browser.
     */
    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigates to the specified URL in the browser.
     * @param url The URL to navigate to.
     */
    protected void navigateTo(String url) {
        this.driver.get(url);
    }

    /**
     * Creates and returns a WebDriverWait instance with the specified timeout.
     *
     * @param time Timeout in seconds to wait for a condition.
     * @return A WebDriverWait instance.
     */
    private WebDriverWait getWait(int time) {
        return new WebDriverWait(this.driver, Duration.ofSeconds(time));
    }

    /**
     * Finds a web element using the specified locator.
     *
     * @param locator The By locator to identify the element.
     * @return The found WebElement.
     */
    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Finds a web element using the specified locator and waits until it becomes visible.
     *
     * @param locator The By locator to identify the element.
     * @param seconds Timeout in seconds to wait for the element to become visible.
     * @return The found WebElement.
     */
    protected WebElement findElement(By locator, int seconds) {
        return getWait(seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Sends text to a web element identified by the specified locator, waiting for it to become visible.
     *
     * @param locator The By locator to identify the element.
     * @param data    The text data to send to the element.
     * @param seconds Timeout in seconds to wait for the element to become visible.
     */
    protected void writeText(By locator, String data, int seconds) {
        findElement(locator, seconds).sendKeys(data);
    }

    /**
     * Sends text to a web element identified by the specified locator without waiting.
     *
     * @param locator The By locator to identify the element.
     * @param data    The text data to send to the element.
     */
    protected void writeText(By locator, String data) {
        findElement(locator).sendKeys(data);
    }

    /**
     * Clicks on a web element identified by the specified locator, waiting for it to become clickable.
     *
     * @param locator The By locator to identify the element.
     * @param seconds Timeout in seconds to wait for the element to become clickable.
     */
    protected void clickElement(By locator, int seconds) {
        getWait(seconds).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Clicks on a web element identified by the specified locator without waiting.
     *
     * @param locator The By locator to identify the element.
     */
    protected void clickElement(By locator) {
        findElement(locator).click();
    }
}
