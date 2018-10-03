package Pages;

import Extensions.*;
import org.openqa.selenium.Keys;

import static Extensions.BuyMeExtensions.getTagElementFromSpan;
import static Extensions.BuyMeExtensions.setDropdownOption;

public class SenderInformationPage {

    //Will set Amount
    public static void setAmount(String keys){
        DriverManager.driver.findElement(Constans.WHATS_AMOUNT_LOCATOR).sendKeys(keys + Keys.ENTER);
    }

    //Will press Someone Else Radio Button
    public static void pressSomeoneElseRadioButton(){
        DriverManager.driver.findElement(Constans.SOMEONE_ELSE_LOCATOR).click();
    }

    //Will set Receiver Name
    public static void setReceiverName(String keys){
        getTagElementFromSpan(Constans.RECEIVER_NAME_LOCATOR, "input").sendKeys(keys);
    }

    //Will set Sender Name
    public static void setSenderName(String keys){
        getTagElementFromSpan(Constans.SENDER_NAME_LOCATOR, "input").sendKeys(keys);
    }

    //Will set Blessing
    public static void setBlessing(String keys){
        getTagElementFromSpan(Constans.BLESSING_LOCATOR, "textarea").sendKeys(keys);
    }

    //Will upload File by file path
    public static void uploadFile(String path){
        DriverManager.driver.findElement(Constans.UPLOAD_FILE_LOCATOR).sendKeys(path);
    }

    //Will set Dropdown Event Option
    public static void setDropdownEventOption(int option){
        DriverManager.driver.findElement(Constans.EVENT_LOCATOR).click();
        setDropdownOption(option);
    }

    //Will press Send Now RadioButton
    public static void pressSendNowRadioButton(){
        DriverManager.driver.findElement(Constans.SEND_NOW_LOCATOR).click();
    }

    //Will press By Mail
    public static void pressByMail(){
        DriverManager.driver.findElement(Constans.BY_MAIL_BUTTON_LOCATOR).click();
    }

    //Will set Receiver Mail And Will Save
    public static void setReceiverMailAndSave(String keys){
        getTagElementFromSpan(Constans.RECEIVER_MAIL_LOCATOR, "input").sendKeys(keys + Keys.ENTER);
    }

    //Will press Submit button
    public static void pressSubmit(){
        DriverManager.driver.findElement(Constans.SUBMIT_BUTTON_LOCATOR).click();
    }
}
