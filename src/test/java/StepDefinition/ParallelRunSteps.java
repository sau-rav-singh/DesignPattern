package StepDefinition;

import Utils.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ParallelRunSteps {

    WebDriver driver;

    @Given("I am on {string} homepage")
    public void openHomepage(String searchEngine) {
        driver= WebDriverManager.getInstance("chrome").getDriver();
        driver.manage().window().maximize();
        if (searchEngine.equalsIgnoreCase("Google")) {
            driver.get("https://www.google.com/");
        } else if (searchEngine.equalsIgnoreCase("Bing")) {
            driver.get("https://www.bing.com/");
        } else {
            throw new IllegalArgumentException("Unsupported search engine: " + searchEngine);
        }
    }

    @When("I get the page title")
    public void getPageTitle() throws InterruptedException {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Thread.sleep(1000);
    }

    @Then("the title should be {string}")
    public void verifyTitle(String expectedTitle) {
        //Assert.assertEquals(driver.getTitle(), expectedTitle);
        WebDriverManager.quitBrowser();
    }


}