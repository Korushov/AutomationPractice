import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

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

    public static boolean isloadComplete(WebDriver driver) {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("loaded")
                || ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }

    public void ifError508() {
        String title = driver.getTitle();
        while (title.equalsIgnoreCase("508 Resource Limit Is Reached")){
            driver.navigate().refresh();
            title = driver.getTitle();
        }
    }
}
