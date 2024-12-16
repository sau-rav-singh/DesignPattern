package RahulDP.Tests;

import RahulDP.PageComponents.FooterNavigation;
import RahulDP.PageComponents.MultiTrip;
import RahulDP.PageComponents.NavigationBar;
import RahulDP.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FooterTest {
    @Test
    public void flightTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
        FooterNavigation footer = travelHomePage.getFooterBar();
        footer.getFlightAttribute();
        footer.getLinkCount();
        NavigationBar navBar = travelHomePage.getNavigationBar();
        navBar.getFlightAttribute();
        navBar.getLinkCount();
        //travelHomePage.setBookingStrategy(new RoundTrip(driver));
        //travelHomePage.setBookingStrategy("multiTrip");
        travelHomePage.setBookingStrategy("roundTrip");
        travelHomePage.checkAvailability("PNQ", "HYD");
       // driver.close();
    }
}
