package RahulDP.PageObjects;

import RahulDP.AbstractComponents.SearchFlightAvail;
import RahulDP.AbstractComponents.StrategyFactory;
import RahulDP.PageComponents.FooterNavigation;
import RahulDP.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {

    By footer = By.id("traveller-home");
    By navBar = By.id("buttons");
    WebDriver driver;
    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver, navBar);
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public FooterNavigation getFooterBar() {
        return new FooterNavigation(driver, footer);
    }

    public void setBookingStrategy(String tripType) {
        StrategyFactory strategyFactory=new StrategyFactory(driver);
        searchFlightAvail=strategyFactory.createStrategy(tripType);
    }

    public void checkAvailability(String origin, String destination) {

        HashMap<String, String> travalMap = new HashMap<>();
        travalMap.put("origin", origin);
        travalMap.put("destination", destination);
        searchFlightAvail.checkAvail(travalMap);
    }
}
