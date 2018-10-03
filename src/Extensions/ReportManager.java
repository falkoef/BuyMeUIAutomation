package Extensions;

import Pages.Constans;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ReportManager {

    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent ;

    // creates a toggle for the given test, adds all log events under it
    public static ExtentTest test ;

    //Will start the report
    public static void start(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Constans.DESKTOP_PATH + "extent.html");

        // choose to append each test
        htmlReporter.setAppendExisting(true);
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("BuyMe", "Website sanity test");

        // add custom system info
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Tester", "Elchanan");

        // log results
        test.log(Status.INFO, "@Before class");
    }

    //Will stop the report
    public static void stop(){
        test.log(Status.INFO, "@After Class");
        extent.flush();
    }

    //Will pass the step and add screenshot
    public static void passAndAddScreenShot(TestName name, String details) throws IOException {
        test.pass(details, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constans.DESKTOP_PATH + name.getMethodName())).build());
    }

    //Will fail the step and add screenshot
    public static void failAndAddScreenShot(TestName name, String details) throws IOException {
        test.fail(details, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constans.DESKTOP_PATH + name.getMethodName())).build());
    }

    //Will take a screenshot by ImagesPath
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }
}
