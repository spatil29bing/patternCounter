package com.spatil29.patternsCounter.services.features;

import com.spatil29.patternsCounter.services.IPatternCounterService;
import com.spatil29.patternsCounter.services.PatternCounterService;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ServicePhraseCounterSpec {

	IPatternCounterService service;
	Map<String, Integer> output = null;

	@Given("^check service classes are wired$")
	public void check_service_classes_is_wired() throws Throwable {
		this.service = new PatternCounterService();
		System.out.println("Service class is wired");
		assertNotNull(service);
	}

	@When("^user Enters file name as \"([^\"]*)\" and \"([^\"]*)\" as count pattern type$")
	public void user_Enters_file_name_as_and_as_count_pattern_type(String arg1, String arg2) throws Throwable {
		System.out.println("User entered file name and type of pattern counter");
		output = service.findPatternfromFile(arg1, arg2);
	}

	@Then("^expect the following word count results$")
	public void expect_the_following_word_count_results(DataTable arg1) throws Throwable {
		Map<String, Integer> expected = arg1.asMap(String.class, Integer.class);
		assertEquals(expected, output);
		System.out.println("Service Returned result successfully");
	}

	@Then("^expect an empty output$")
	public void expect_an_empty_output() throws Throwable {
		assertEquals(0, output.size());
		System.out.println("Service Returned null map as expected");
	}

	@Then("^expect output with words count having atleast three words and skips the rest$")
	public void expect_output_with_words_count_having_atleast_three_words_and_skips_the_rest(DataTable arg1)
			throws Throwable {
		Map<String, Integer> expected = arg1.asMap(String.class, Integer.class);
		assertEquals(expected, output);
		System.out.println("Service Returned expected partial result successfully");
	}

}
