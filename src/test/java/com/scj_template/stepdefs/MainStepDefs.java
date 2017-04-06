package com.scj_template.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.scj_template.stepdefs.Hooks.driver;
import static com.scj_template.stepdefs.Hooks.waitForPageLoaded;

/**
 * Created by eroguli on 31/03/2017.
 */
public class MainStepDefs {

    @Given("^I open googlecom$")
    public void iOpenGoogleCom() {
        waitForPageLoaded();
        driver.get("https://www.google.com/");
    }

    @When("^I click on the searchbox$")
    public void iClickOnTheSearchbox() {
        waitForPageLoaded();
        driver.findElement(By.id("lst-ib")).click();
    }

    @And("^I type something$")
    public void iTypeSomething() {
        driver.findElement(By.id("lst-ib")).sendKeys("Business Insider");
        driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
    }

    @Then("^search results should be displayed$")
    public void searchResultsShouldBeDisplayed() {
        waitForPageLoaded();
        Assert.assertTrue("Results successfully displayed",
                driver.findElement(By.tagName("body")).getText().contains("Business Insider"));
    }
}
