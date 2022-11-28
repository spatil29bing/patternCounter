package com.spatil29.patternsCounter.patterns.types.features;

import com.spatil29.patternsCounter.patterns.IPatternCounter;

import com.spatil29.patternsCounter.patterns.types.NumberCounter;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class NumberCounterTest {

    Map<String, Integer> result = null;
    Map<String, Integer> expected = null;

    IPatternCounter  patternCounter = null;


    @Given("^number pattern counter is initialized$")
    public void number_pattern_counter_is_initialized() throws Throwable {
        System.out.println("Pattern Counter is initialized");
        this.patternCounter = new NumberCounter();
    }

    @When("^an input of \"([^\"]*)\" and \"([^\"]*)\" is passed as input parameters$")
    public void an_input_of_and_is_passed_as_input_parameters(String arg1, String arg2) throws Throwable {
        System.out.println("arguments " + arg1 + " and " + arg2 + " are sent to the service");
        this.result = patternCounter.getPatternCount(arg1, arg2);
    }

    @Then("^check whether the counter is returning correct counts$")
    public void check_whether_the_counter_is_returning_correct_counts(DataTable arg1) throws Throwable {
        expected = arg1.asMap(String.class, Integer.class);
        assertEquals(expected, result);
        System.out.println("Expected Results returned successfully");
    }

    @Then("^check whether the \\\"([^\\\"]*)\\\" count is (\\d+) and \\\"([^\\\"]*)\\\" count is (\\d+)$")
    public void check_whether_the_count_is_and_count_is(String arg1, int arg2, String arg3, int arg4) throws Throwable {
        assertEquals(expected.get(arg1), (Integer) arg2);
        assertEquals(expected.get(arg3), (Integer) arg4);
        System.out.println("Test Passed");

    }

    @Then("^check whether the result is empty$")
    public void check_whether_the_result_is_empty() throws Throwable {
        assertEquals(result.size(), 0);
        System.out.println("Expected empty result is returned");
    }
}