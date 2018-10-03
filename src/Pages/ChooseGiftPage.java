package Pages;
import Extensions.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class ChooseGiftPage {

    //Will wait for first business item
    public static void waitForFirstBusinessItem(){
        DriverManager.waitForElement(Constans.BUSINESS_ITEM_LOCATOR);
    }

    //Will press on first business item
    public static void pressFirstBusinessItem(){
        DriverManager.driver.findElement(Constans.BUSINESS_ITEM_LOCATOR).click();
    }

    //Will scroll To Buttom Of The Page
    public static void scrollToButtomOfPage() throws InterruptedException {
        Thread.sleep(1000);
        ArrayList<WebElement> BusinessItems;
        int finalSize;
        do {
            BusinessItems = (ArrayList<WebElement>)DriverManager.driver.findElements(Constans.BUSINESS_ITEM_LOCATOR);
            ((JavascriptExecutor)DriverManager.driver).executeScript("arguments[0].scrollIntoView(true);", BusinessItems.get(BusinessItems.size()-1));
            //DriverManager.waitForElement(By.className("fa-spin"));
            Thread.sleep(1000);
            finalSize = DriverManager.driver.findElements(Constans.BUSINESS_ITEM_LOCATOR).size();
        }
        while (BusinessItems.size() != finalSize);
    }
}
