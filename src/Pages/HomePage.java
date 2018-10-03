package Pages;

import Extensions.DriverManager;

import static Extensions.BuyMeExtensions.setDropdownOption;

public class HomePage {

    //Will wait For Registration Button
    public static void waitForRegistrationButton(){
        DriverManager.waitForElement(Constans.REGISTRATION_BUTTON_LOCATOR);
    }

    //Will press Registration
    public static void pressRegistration(){
        DriverManager.driver.findElement(Constans.REGISTRATION_BUTTON_LOCATOR).click();
    }

    //Will set Dropdown Amount Option
    public static void setDropdownAmountOption(int option){
        DriverManager.driver.findElement(Constans.AMOUNT_LOCATOR).click();
        setDropdownOption(option);
    }

    //Will set Dropdown Area Option
    public static void setDropdownAreaOption(int option){
        DriverManager.driver.findElement(Constans.AREA_LOCATOR).click();
        setDropdownOption(option);
    }

    //Will set Dropdown Category Option
    public static void setDropdownCategoryOption(int option){
        DriverManager.driver.findElement(Constans.CATEGORY_LOCATOR).click();
        setDropdownOption(option);
    }

    //Will press Submit Button
    public static void pressSubmit(){
        DriverManager.driver.findElement(Constans.SUBMIT_BUTTON_LOCATOR).click();
    }

    //Will return the Loading Dots Size
    public static String getLoadingDotsSize(){
        DriverManager.waitForElement(Constans.LOADING_DOTS_LOCATOR);
        return DriverManager.driver.findElement(Constans.LOADING_DOTS_LOCATOR).getSize().toString();
    }
}
