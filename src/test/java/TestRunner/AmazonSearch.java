package TestRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class AmazonSearch {
    public static void main(String[] args) throws InterruptedException {
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sam");
        Thread.sleep(2000);
        List<WebElement> suggestionElements = driver.findElements(By.cssSelector("div.s-suggestion"));

        // Print all product names
        for (WebElement suggestion : suggestionElements) {
            String productName = suggestion.getDomAttribute("aria-label");
            System.out.println(productName);
        }

        driver.close();
    }
}
