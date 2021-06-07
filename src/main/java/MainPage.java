import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By signInButton = By.className("login");

    public SignInPage clickSignIn() {
        String linkToSignIn = driver.findElement(signInButton).getAttribute("href");
        driver.get(linkToSignIn);
        return new SignInPage(driver);
    }
}
