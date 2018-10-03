package Extensions;

import Pages.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class BuyMeExtensions {

    //Will return tag element by span
    public static WebElement getTagElementFromSpan(By spanLocator, String tagName){
        return DriverManager.driver.findElement(spanLocator).findElement(By.xpath("..")).findElement(By.tagName(tagName));
    }

    //Will press on option from dropdown
    public static void setDropdownOption(int option){
        ArrayList<WebElement> listOptions = (ArrayList<WebElement>) DriverManager.driver.findElements(Constans.DROPDOWN_LIST_LOCATOR);
        listOptions.get(option).click();
    }
}
