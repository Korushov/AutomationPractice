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





}
