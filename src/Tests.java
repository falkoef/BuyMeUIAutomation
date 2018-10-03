import Extensions.DriverManager;
import Extensions.ReportManager;
import Extensions.XmlHelper;
import Pages.*;
import com.aventstack.extentreports.Status;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
    private static String url;

    static {
        try {
            url = XmlHelper.getData("URL");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void beforeClass() throws IOException, SAXException, ParserConfigurationException {
        ReportManager.start();
        DriverManager.startBrowser();
        DriverManager.driver.get(url);
    }

    @Before
    public  void before() {
    }

    @Test()
    public void test1RegistrationPage() throws IOException {

        HomePage.waitForRegistrationButton();
        HomePage.pressRegistration();
        RegistrationPage.pressNotYetRegistration();
        RegistrationPage.setFirstName("אלחנן");
        RegistrationPage.setMail("123@gmaile.com");
        RegistrationPage.setPassword("Aa43211234");
        RegistrationPage.setValidatePassword("Aa43211234");
        RegistrationPage.pressRegisterConsent();
        RegistrationPage.pressSubmit();
        ReportManager.passAndAddScreenShot(name, "Registration test");
        RegistrationPage.pressXButton();
    }

    @Test()
    public void test2HomePage() throws IOException {
        HomePage.setDropdownAmountOption(1);
        HomePage.setDropdownAreaOption(3);
        HomePage.setDropdownCategoryOption(4);
        ReportManager.passAndAddScreenShot(name, "HomePage test");
        HomePage.pressSubmit();
        ChooseGiftPage.waitForFirstBusinessItem();
    }

    @Test()
    public void test3ChooseGiftPage() throws IOException {
        if (!url.equals(DriverManager.driver.getCurrentUrl()))
            ReportManager.test.log(Status.PASS, "Webpage URL changed successfully");
        else
        {
            ReportManager.test.log(Status.FAIL, "Webpage URL not changed");
            Assert.assertNotEquals(url, DriverManager.driver.getCurrentUrl());
        }

        ReportManager.passAndAddScreenShot(name, "ChooseGiftPage test");
        ChooseGiftPage.pressFirstBusinessItem();
    }
    @Test()
    public void test4SenderInformationPage() throws IOException {
        SenderInformationPage.setAmount("100");
        SenderInformationPage.pressSomeoneElseRadioButton();
        SenderInformationPage.setReceiverName("בדיקה");
        SenderInformationPage.setSenderName("אלחנן");
        SenderInformationPage.setBlessing("ברכה");
        SenderInformationPage.uploadFile(Constans.DESKTOP_PATH + "test3.png");
        SenderInformationPage.setDropdownEventOption(5);
        SenderInformationPage.pressSendNowRadioButton();
        SenderInformationPage.pressByMail();
        SenderInformationPage.setReceiverMailAndSave("123@gmaile.com");
        ReportManager.passAndAddScreenShot(name, "SenderInformationPage test");
        SenderInformationPage.pressSubmit();
    }

    @Test()
    public void test5RegistrationPageValidations() throws InterruptedException, IOException {
        DriverManager.driver.get(url);
        HomePage.waitForRegistrationButton();
        Thread.sleep(1000);
        HomePage.pressRegistration();
        RegistrationPage.pressSubmit();
        RegistrationPage.ValidateRequiredField(name);
    }

    @Test()
    public void test6ScrollButtomChooseGiftPage() throws InterruptedException, IOException {
        DriverManager.driver.get(url + "search?budget=3&category=16&region=11");
        ChooseGiftPage.waitForFirstBusinessItem();
        ChooseGiftPage.scrollToButtomOfPage();
        ReportManager.passAndAddScreenShot(name, "Buttom page");
    }

    @Test()
    public void test7LoadingDotsSize() throws IOException {
        DriverManager.driver.get(url);
        ReportManager.test.log(Status.INFO,"The loading dots size is =" + HomePage.getLoadingDotsSize());
        ReportManager.passAndAddScreenShot(name, "Loading dots size");
    }

    @After
    public void after() {
    }

    @AfterClass
    public static void afterClass() {
        DriverManager.driver.quit();
        ReportManager.stop();
    }
}
