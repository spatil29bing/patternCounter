package com.spatil29.patternsCounter.patterns.factory.features;

import com.spatil29.patternsCounter.patterns.IPatternCounter;
import com.spatil29.patternsCounter.patterns.factory.PatternFactory;
import com.spatil29.patternsCounter.patterns.types.NumberCounter;
import com.spatil29.patternsCounter.patterns.types.PhraseCounter;
import com.spatil29.patternsCounter.patterns.types.WordCounter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class PatternFactoryTest {

    PatternFactory patternFactory;
    IPatternCounter patternCounter;

    @Given("^a factory instance$")
    public void a_factory_instance() throws Throwable {
        this.patternFactory = new PatternFactory();
        System.out.println("Pattern Factory is initialized");
    }

    @When("^the entered string is \"([^\"]*)\"$")
    public void the_entered_string_is(String arg1) throws Throwable {
        this.patternCounter = patternFactory.getPatternSpecificObject(arg1);
    }

    @Then("^check whether the factory returned a WordCounter instance$")
    public void check_whether_the_factory_returned_a_WordCounter_instance() throws Throwable {
        assertTrue(this.patternCounter instanceof WordCounter);
        System.out.println("Instance of Word Counter successfully tested");
    }

    @Then("^check whether the factory returned a NumberCounter instance$")
    public void check_whether_the_factory_returned_a_NumberCounter_instance() throws Throwable {
        assertTrue(this.patternCounter instanceof NumberCounter);
        System.out.println("Instance of number Counter successfully tested");
    }

    @Then("^check whether the factory returned a PhraseCounter instance$")
    public void check_whether_the_factory_returned_a_PhraseCounter_instance() throws Throwable {
        assertTrue(this.patternCounter instanceof PhraseCounter);
        System.out.println("Instance of Phrase Counter successfully tested");
    }

    @Then("^check whether the factory returned null instance$")
    public void check_whether_the_factory_returned_null_instance() throws Throwable {
        assertNull(this.patternCounter);
        System.out.println("Patern Counter null verified");
    }
    @Given("^reset all fields$")
    public void reset_all_fields() throws Throwable {
        this.patternCounter = null;
        System.out.println("Reset success");
    }

}