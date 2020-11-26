package feature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utls.BaseTest;
import utls.Excelutls;
import utls.Mtds;

import static utls.Mtds.driver;


public class CheckOut extends BaseTest {


    @Test(dataProvider = "Customer")
    public void CheckoutTest(String username, String paasword, String sItem1, String sItem2) throws Exception {

        reportlog("Opening Browser");
        Mtds.Launch("firefox");

        reportlog("Navigating to URL");
        driver.get("https://www.saucedemo.com/");

        reportlog("Entering login credentials");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(paasword);
        reportlog("Logging in");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product_label']")));

        reportlog("Selecting and adding first item to cart");
        driver.findElement(By.xpath("//div[@class='inventory_item_name'][contains(.,'"+sItem1+"')]")).click();
        String item1 = driver.findElement(By.xpath("//div[contains(@class,'inventory_details_name')]")).getText();
        driver.findElement(By.xpath("//button[contains(.,'ADD TO CART')]")).click();

        reportlog("Navigating back to home screen");
        driver.findElement(By.xpath("//button[contains(.,'<- Back')]")).click();

        reportlog("Selecting and adding second item to cart");
        driver.findElement(By.xpath("//div[@class='inventory_item_name'][contains(.,'"+sItem2+"')]")).click();
        String item2 = driver.findElement(By.xpath("//div[contains(@class,'inventory_details_name')]")).getText();
        driver.findElement(By.xpath("//button[contains(.,'ADD TO CART')]")).click();

        reportlog("Navigating back to home screen");
        driver.findElement(By.xpath("//button[contains(.,'<- Back')]")).click();

        reportlog("Navigating to cart");
        driver.findElement(By.xpath("//span[contains(.,'2')]")).click();

        reportlog("These are the items in your cart: "+ item1 + " and " + item2);
        screen();

        reportlog("Clicking on checkout");
        driver.findElement(By.xpath("//a[contains(.,'CHECKOUT')]")).click();

        reportlog("Entering required details");
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Nico");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("1234");

        reportlog("Clicking on continue");
        driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'contents_wrapper')]")));

        reportlog("These are the items you are checking out:");
        screen();

        reportlog("Clicking on finish");
        driver.findElement(By.xpath("//a[contains(.,'FINISH')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='checkout_complete_container']")));
        String done = driver.findElement(By.xpath("//div[@class='checkout_complete_container']")).getText();
        reportlog(done);
        screen();

    }

    @DataProvider
    public Object[][] Customer() throws Exception {
        Object[][] testObjArray = Excelutls.getTableArray(".\\src\\main\\resources\\Testdata.xlsx", "Checkout",4);

        return (testObjArray);
    }
}
