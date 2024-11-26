package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static volatile WebDriverManager instance;

    private WebDriverManager() {
    }

    public static WebDriverManager getInstance(String browser) {//Double-Checked Locking (DCL)
        if (instance == null) {
            synchronized (WebDriverManager.class) {
                if (instance == null) {
                    instance = new WebDriverManager();
                }
            }
        }
        if (tlDriver.get() == null) {
            instance.initDriver(browser);
        }
        return instance;
    }

    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getInstance("chrome").getDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        WebDriverManager.quitBrowser();
    }

    public void initDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                tlDriver.set(new ChromeDriver());
                break;
            case "firefox":
                tlDriver.set(new FirefoxDriver());
                break;
            case "edge":
                tlDriver.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitBrowser() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
