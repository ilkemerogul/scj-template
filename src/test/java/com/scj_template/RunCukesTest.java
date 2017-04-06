package com.scj_template;

/**
 * Created by eroguli on 31/03/2017.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:target/cucumber.json",
        features = {"classpath:features"},
        glue = {"com.scj_template"},
        tags = {"~@ignore"})
public class RunCukesTest {

}


