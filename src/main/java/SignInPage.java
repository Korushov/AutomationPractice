import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    private WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    private By emailAdress = By.id("email_create");
    private By createAccountButton = By.id("SubmitCreate");
    private By error = By.xpath("//*[@id=\"create_account_error\"]/ol/li");
    private By errorFrame = By.id("create_account_error");

    String email = "korushovv" + System.currentTimeMillis() + "@mail.ru";

    public SignInPage TypeEmail(String email) {
        driver.findElement(emailAdress).sendKeys(email);
        return this;
    }

    public NewAccountPage CreateNewAccount() {
        driver.findElement(emailAdress).sendKeys(Keys.ENTER);
        return new NewAccountPage(driver);
    }

    public NewAccountPage CreateAccount(String email) {
        TypeEmail(email);
        CreateNewAccount();
        return new NewAccountPage(driver);
    }

    public SignInPage InvalidEmailError() {
        driver.findElement(error).getText();
        return this;
    }




}
