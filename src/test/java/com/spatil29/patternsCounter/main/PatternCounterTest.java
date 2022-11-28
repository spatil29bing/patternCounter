package com.spatil29.patternsCounter.main;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * The main Cucumber runner for the test cases
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(glue = { "com.spatil29.patternsCounter" }, features = { "src/test/resources/features" }, format = {
        "json:target/cucumber-report/cucumber.json" })
public class PatternCounterTest {

}
