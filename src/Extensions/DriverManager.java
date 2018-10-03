package Extensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;
    private static int secondsToWaitForElement = 10;
    private static int secondsToWaitForImplicitlyWait = 10;
    private static int secondsToWaitForPage = 10;

    //Will start chrome
    private static void startChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Falko\\Desktop\\BuyMeUIAutomation\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions", "--start-maximize","--headless");
        driver = new ChromeDriver(options);
    }
    //Will start firefox
    private static void startFireFox(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Falko\\Desktop\\BuyMeUIAutomation\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    //Will start browser by config file value
    public static void startBrowser() throws IOException, SAXException, ParserConfigurationException {
        String browserType = XmlHelper.getData("BrowserType").toLowerCase();
        if (browserType.equals("chrome"))
            startChrome();
        else if (browserType.equals("firefox"))
            startFireFox();
        driver.manage().window().maximize();
        DriverManager.driver.manage().timeouts().implicitlyWait(secondsToWaitForImplicitlyWait, TimeUnit.SECONDS);
        DriverManager.driver.manage().timeouts().pageLoadTimeout(secondsToWaitForPage, TimeUnit.SECONDS);
    }

    //Will wait for element to be visibility
    public static void waitForElement(By by){
        WebDriverWait wait = new WebDriverWait(driver,secondsToWaitForElement);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
