package Steps;

import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;

public class Step2 {
    private static SharedStateBetweenScenario sharedStateBetweenScenario;
    private final SharedStateBetweenSteps sharedStateBetweenSteps;

    public Step2(SharedStateBetweenScenario sharedStateBetweenScenario, SharedStateBetweenSteps sharedStateBetweenSteps) {
        Step2.sharedStateBetweenScenario = sharedStateBetweenScenario;
        this.sharedStateBetweenSteps = sharedStateBetweenSteps;

    }

    @Then("I should have access to the important data in step definition 2")
    public void iShouldHaveAccessToTheImportantDataInStepDefinition() {
        String data = sharedStateBetweenSteps.getDatabetweenSteps();
        System.out.println("The important data is: " + data);
        assertEquals(data, "expectedData");
    }

    @Then("I should have access to the important data in Feature 1")
    public void iShouldHaveAccessToTheImportantDataInFeature() {
        String data = SharedStateBetweenScenario.dataBetweenScenarrio;
        System.out.println("The important data is: " + data);
        assertEquals(data, "expectedData");
    }
}
