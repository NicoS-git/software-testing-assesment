package utls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Mtds {

    public static WebDriver driver;

    public static void Launch(String browser) throws Exception {

        if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdirver.chrome.driver",".\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:\\Users\\A230777\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
            //options.addArguments("--headless");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        }
        else if(browser.equalsIgnoreCase("Edge"))
        {
            System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }

        else
        {
            throw new Exception("No browser found");
        }

    }
}
