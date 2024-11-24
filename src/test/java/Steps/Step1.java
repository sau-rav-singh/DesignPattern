package Steps;

import io.cucumber.java.en.Given;

public class Step1 {
    private static SharedStateBetweenScenario sharedStateBetweenScenario;
    private final SharedStateBetweenSteps sharedStateBetweenSteps;

    public Step1(SharedStateBetweenScenario sharedStateBetweenScenario, SharedStateBetweenSteps sharedStateBetweenSteps) {
        Step1.sharedStateBetweenScenario = sharedStateBetweenScenario;
        this.sharedStateBetweenSteps = sharedStateBetweenSteps;
    }

    @Given("I set the important data to {string} in step definition 1")
    public void iSetTheImportantDataToInStepDefinition(String data) {
        sharedStateBetweenSteps.setDatabetweenSteps(data);
        SharedStateBetweenScenario.dataBetweenScenarrio = data;
    }
}
