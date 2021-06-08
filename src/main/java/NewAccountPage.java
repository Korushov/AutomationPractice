import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class NewAccountPage {

    private WebDriver driver;

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameBox = By.id("customer_firstname");
    private By lastNameBox = By.id("customer_lastname");
    private By passwordBox = By.id("passwd");
    private By addressBox= By.id("address1");
    private By cityBox = By.id("city");
    private By stateBox = By.id("id_state");
    private By postcodeBox = By.id("postcode");
    private By phoneBox = By.id("phone_mobile");
    private By registerButton = By.id("submitAccount");

    public NewAccountPage typeFirstName(String firstName) {
        driver.findElement(firstNameBox).sendKeys(firstName);
        return this;
    }

    public NewAccountPage typeLastName(String lastName) {
        driver.findElement(lastNameBox).sendKeys(lastName);
        return this;
    }

    public NewAccountPage typePassword(String password) {
        driver.findElement(passwordBox).sendKeys(password);
        return this;
    }

    public NewAccountPage typeAddress(String address) {
        driver.findElement(addressBox).sendKeys(address);
        return this;
    }

    public NewAccountPage typeCity(String city) {
        driver.findElement(cityBox).sendKeys(city);
        return this;
    }

    public NewAccountPage selectState(String value) {
        Select dropdownState = new Select(driver.findElement(stateBox));
        dropdownState.selectByValue(value);
        return this;
    }

    public NewAccountPage typePostcode(String postcode) {
        driver.findElement(postcodeBox).sendKeys(postcode);
        return this;
    }

    public NewAccountPage typePhone(String phone) {
        driver.findElement(phoneBox).sendKeys(phone);
        return this;
    }

    public MyAccountPage RegisterButton() {
        driver.findElement(phoneBox).sendKeys(Keys.ENTER);
        return new MyAccountPage(driver);
    }

    public MyAccountPage newAccountRegistration(String firstname, String lastname, String password, String address, String city, String value, String postcode, String phone) {
        typeFirstName(firstname);
        typeLastName(lastname);
        typePassword(password);
        typeAddress(address);
        typeCity(city);
        selectState(value);
        typePostcode(postcode);
        typePhone(phone);
        RegisterButton();
        return new MyAccountPage(driver);
    }
}


