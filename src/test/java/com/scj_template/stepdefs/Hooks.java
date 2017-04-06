package com.scj_template.stepdefs;

/**
 * Created by eroguli on 31/03/2017.
 */

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class Hooks {

    public static WebDriver driver;

    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        }
        catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    @Before
    public void startDriver() throws MalformedURLException, UnsupportedEncodingException {
        System.out.println("Called openBrowser");
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
    }

    @After
    public void stopDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.write("Current Page URL: " + driver.getCurrentUrl());
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        driver.quit();
    }

}