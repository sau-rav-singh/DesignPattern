package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "StepDefinition",
        tags = "@Parallel1"
        //tags = "@DI"
)
public class TestRunner2 extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}