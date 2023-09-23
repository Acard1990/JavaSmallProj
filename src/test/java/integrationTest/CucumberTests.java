package integrationTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/appUser.feature",
        plugin = {"pretty", "html:build/cucumber", "json:build/cucumber.json"},
        glue = {"integrationTest"})
public class CucumberTests {

}
