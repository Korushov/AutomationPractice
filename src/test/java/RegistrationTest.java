import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {

        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
        mainPage = new MainPage(driver);
        mainPage.ifError508();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void RegisterNewAccountTest() {
        SignInPage signInPage = mainPage.clickSignIn();
        mainPage.ifError508();
        MainPage.isloadComplete(driver);
        NewAccountPage newAccountPage = signInPage.CreateAccount(signInPage.email);
        MainPage.isloadComplete(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        newAccountPage.newAccountRegistration("Firstname", "Lastname", "12233444", "Street", "City", "5", "11111", "1111111111");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleIs("My account - My Store"));
        MainPage.isloadComplete(driver);
        Assert.assertEquals("My account - My Store", driver.getTitle());
    }

    @Test
    public void RegisterInvalidEmailTest() {
        SignInPage signInPage = mainPage.clickSignIn();
        signInPage.CreateAccount("emaaaaaaail");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("create_account_error"))));
        MainPage.isloadComplete(driver);
        Assert.assertTrue(driver.findElement(By.id("create_account_error")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}