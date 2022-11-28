package com.spatil29.patternsCounter.patterns.types.features;

import com.spatil29.patternsCounter.patterns.IPatternCounter;
import com.spatil29.patternsCounter.patterns.types.WordCounter;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordCounterTest {

    IPatternCounter patterncounter;
    Map<String, Integer> result = null;
    Map<String, Integer> expected = null;

    @Given("^Word count service is properly wired$")
    public void word_count_service_is_properly_wired() throws Throwable {
        this.patterncounter = new WordCounter();
        System.out.println("Word counter is successfully initialized");
    }

    @Given("^result is reset$")
    public void result_is_reset() throws Throwable {
        this.result = null;
    }

    @When("^a valid text with content \"([^\"]*)\" is passed with file name as \"([^\"]*)\" is passed$")
    public void a_valid_text_with_content_is_passed_with_file_name_as_is_passed(String arg1, String arg2)
            throws Throwable {
        this.result = patterncounter.getPatternCount(arg1, arg2);
        System.out.println("The contents are sent to the service");
    }

    @Then("^make sure the result is not empty$")
    public void make_sure_the_result_is_not_empty() throws Throwable {
        assertTrue(this.result.size() >0);
        System.out.println("Result is not empty");

    }

    @Then("^check the value is as expected$")
    public void check_the_value_is_as_expected(DataTable arg1) throws Throwable {
        this.expected = arg1.asMap(String.class, Integer.class);
        assertEquals(expected, result);
        System.out.println("Successfully verified contents");
    }

    @When("^check the value is empty$")
    public void check_the_value_is_empty() throws Throwable {
        assertEquals(0, result.size());
        System.out.println("size is 0");
    }

}