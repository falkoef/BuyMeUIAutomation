package Pages;
import Extensions.DriverManager;
import Extensions.ReportManager;
import com.aventstack.extentreports.Status;
import org.junit.rules.TestName;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;

public class RegistrationPage {

    //Will press Not Yet Registration
    public static void pressNotYetRegistration(){
        DriverManager.driver.findElement(Constans.NOT_YET_REGISTRATION_BUTTON_LOCATOR).click();
    }

    //Will set First Name
    public static void setFirstName(String keys){
        DriverManager.driver.findElement(Constans.FIRST_NAME_LOCATOR).sendKeys(keys);
    }

    //Will set a Mail
    public static void setMail(String keys){
        DriverManager.driver.findElement(Constans.MAIL_LOCATOR).sendKeys(keys);
    }

    //Will set a Password
    public static void setPassword(String keys){
        DriverManager.driver.findElement(Constans.PASSWORD_LOCATOR).sendKeys(keys);
    }

    //Will set a Validate Password
    public static void setValidatePassword(String keys){
        DriverManager.driver.findElement(Constans.VALIDATE_PASSWORD_LOCATOR).sendKeys(keys);
    }

    //Will press Register Consent
    public static void pressRegisterConsent(){
        DriverManager.driver.findElement(Constans.REGISTER_CONSENT_LOCATOR).click();
    }

    //Will press Submit Button
    public static void pressSubmit(){
        DriverManager.driver.findElement(Constans.SUBMIT_BUTTON_LOCATOR).click();
    }

    //Will press X Button
    public static void pressXButton(){
        DriverManager.driver.findElement(Constans.X_BUTTON_LOCATOR).click();
    }

    //Will Validate Required Field
    public static void ValidateRequiredField(TestName name) throws IOException {
        ArrayList<WebElement> requiredFields = (ArrayList<WebElement>)DriverManager.driver.findElements(Constans.REQUIRED_FIELDS_LOCATOR);
        if (requiredFields.size() == 2){
            for (int i = 0; i < 2; i++) {
                if (requiredFields.get(i).getText().equals("כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה")){
                    ReportManager.test.log(Status.PASS, "The required field " + (i+1) + " exists");
                }
                else {
                    ReportManager.test.log(Status.FAIL, "The required field " + (i+1) + " not exists");
                    ReportManager.failAndAddScreenShot(name, "ValidateRequiredField FAIL");
                }
            }
        }
        else {
            ReportManager.test.log(Status.FAIL, "The required fields not equals 2");
            ReportManager.failAndAddScreenShot(name, "ValidateRequiredField FAIL");
        }
    }
}
