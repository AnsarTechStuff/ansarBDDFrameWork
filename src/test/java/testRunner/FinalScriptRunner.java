package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.*;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features =".//Features/Login.feature", //run single only
		//features = {".//Features/Login.feature", ".//Features/xyz.feature"}, //To run mutiple files
	    features =".//Features/", //if you want run all 
		glue 	 ="stepDefinations",
		dryRun   = false,
		monochrome=true,
		plugin   = {"pretty","html:test-output"}
		
		)


public class FinalScriptRunner {

}
