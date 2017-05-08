package test;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = "pretty",
        features = {"src/test/java/test/features/"}
)
public class testRunner {
    
}
