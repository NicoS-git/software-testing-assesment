package utls;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;


public class BaseTest {

    static ExtentTest test;
    static ExtentReports report;


    @BeforeMethod
    public void setUp(ITestContext sn){



        String suitename = sn.getCurrentXmlTest().getSuite().getName();
        report = new
                ExtentReports( ".\\test-outputs\\"+suitename+".html", false);

        String s = String.valueOf(getClass());
        String s2 = s.substring(s.indexOf(".")+1);
        test = report.startTest(s2);
        report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
        System.out.println("This is the beginning");

    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {

        if (result.getStatus()== ITestResult.FAILURE){
            test.log(LogStatus.FAIL,"This test failed: "+result.getName());
            test.log(LogStatus.FAIL,"Error Details:-\n" + result.getThrowable().getMessage());
            test.log(LogStatus.FAIL,"Error below: "+ test.addScreenCapture(capture()));
        }else if (result.getStatus()== ITestResult.SKIP){
            test.log(LogStatus.SKIP, "This test was skipped: "+result.getName());
        }else if (result.getStatus()== ITestResult.SUCCESS){
            test.log(LogStatus.PASS,"This test has passed: "+result.getName());
        }
    }

    @AfterClass
    public void tearDown(){

        System.out.println("This is the end");
        report.endTest(test);
        report.flush();
        Mtds.driver.close();

    }

    public static String capture() throws IOException {

        TakesScreenshot ts = (TakesScreenshot)Mtds.driver;
        File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

        String screenShotPath = "C:\\Automation\\automationsolution\\screenshots\\" +System.currentTimeMillis()+".png";

        FileUtils.copyFile(screenshotFile,new File(screenShotPath));

        return screenShotPath;
    }

    public void reportlog(String message){

        test.log(LogStatus.INFO, message);

    }

    public void screen() throws IOException {

        test.log(LogStatus.INFO, "Success"+test.addScreenCapture(capture()));


    }
}
