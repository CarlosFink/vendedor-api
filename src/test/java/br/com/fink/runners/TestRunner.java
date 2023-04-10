package br.com.fink.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		features = {"src/test/java/resources"},
		glue = {"br.com.fink.runners"},
		plugin = "pretty",
		monochrome = true,
		dryRun = false,
		tags = ("not @ignore")
)
public class TestRunner {

}
