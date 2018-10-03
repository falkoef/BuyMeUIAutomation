package Pages;

import org.openqa.selenium.By;

public class Constans {
    // Test constans
    public static String DESKTOP_PATH = "C:\\Users\\Falko\\Desktop\\";

    //Home page constans
    static final By LOADING_DOTS_LOCATOR = By.className("spinner");
    static final By REGISTRATION_BUTTON_LOCATOR = By.xpath("//li[@class='top-bar-item my-account']");
    static final By AMOUNT_LOCATOR = By.xpath("//span[text() = 'סכום']");
    static final By AREA_LOCATOR = By.xpath("//span[text() = 'אזור']");
    static final By CATEGORY_LOCATOR = By.xpath("//span[text() = 'קטגוריה']");
    public static final By DROPDOWN_LIST_LOCATOR = By.className("active-result");

    //Registration page constans
    static final By NOT_YET_REGISTRATION_BUTTON_LOCATOR = By.xpath("//strong[text() = 'עוד לא נרשמת?']");
    static final By FIRST_NAME_LOCATOR = By.xpath("//input[@placeholder = 'שם פרטי']");
    static final By MAIL_LOCATOR = By.xpath("//input[@placeholder = 'מייל']");
    static final By PASSWORD_LOCATOR = By.xpath("//input[@placeholder = 'סיסמה']");
    static final By VALIDATE_PASSWORD_LOCATOR = By.xpath("//input[@placeholder = 'אימות סיסמה']");
    static final By REGISTER_CONSENT_LOCATOR = By.xpath("//label[@for = 'register-consent']");
    static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@type = 'submit']");
    static final By X_BUTTON_LOCATOR = By.className("icon-times");
    static final By REQUIRED_FIELDS_LOCATOR = By.className("parsley-required");

    //Choose gift page constans
    public static final By BUSINESS_ITEM_LOCATOR = By.className("promo-item-logo");

    //Sender information page constans
    static final By WHATS_AMOUNT_LOCATOR = By.xpath("//input[@placeholder = 'מה הסכום?']");
    static final By SOMEONE_ELSE_LOCATOR = By.xpath("//span[text() = 'למישהו אחר']");
    static final By RECEIVER_NAME_LOCATOR = By.xpath("//span[text() = 'למי המתנה?']");
    static final By SENDER_NAME_LOCATOR = By.xpath("//span[text() = 'ממי המתנה?']");
    static final By BLESSING_LOCATOR = By.xpath("//span[text() = 'ברכות ואיחולים או מילים טובות']");
    static final By UPLOAD_FILE_LOCATOR = By.name("fileUpload");
    static final By EVENT_LOCATOR = By.xpath("//span[text() = 'לאיזה אירוע?']");
    static final By SEND_NOW_LOCATOR = By.className("send-now");
    static final By BY_MAIL_BUTTON_LOCATOR = By.xpath("//span[text() = 'במייל']");
    static final By RECEIVER_MAIL_LOCATOR = By.xpath("//input[@placeholder = 'כתובת המייל של מקבל/ת המתנה']");
}
