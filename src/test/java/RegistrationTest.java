import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");

        mainPage = new MainPage(driver);
    }

    @Test
    public void RegisterNewAccountTest() {
        SignInPage signInPage = mainPage.clickSignIn();
        NewAccountPage newAccountPage = signInPage.CreateAccount("korushovvvvvvvv" + System.currentTimeMillis() + "@mail.ru");
        MyAccountPage myAccountPage = newAccountPage.newAccountRegistration("Firstname", "Lastname", "12233444", "Street", "City", "5", "11111", "1111111111");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
    }

    @Test
    public void RegisterInvalidEmailTest() {
        SignInPage signInPage = mainPage.clickSignIn();
        NewAccountPage newAccountPage = signInPage.CreateAccount("emaaaaaaail");
        SignInPage errorText = signInPage.InvalidEmailError();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(errorText, "Invalid email address.");
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}