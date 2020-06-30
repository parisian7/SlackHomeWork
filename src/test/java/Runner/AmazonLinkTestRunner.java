package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\AmazonLink\\LinkVerification.feature",
        glue = "StepDefinitions",
        monochrome = false,
        dryRun = false

)

public class AmazonLinkTestRunner {
}
