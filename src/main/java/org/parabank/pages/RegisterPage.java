package org.parabank.pages;

import org.parabank.utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseClass {

    public WebDriver driver;

    public RegisterPage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    private WebElement address;

    @FindBy(id = "customer.address.city")
    private WebElement city;

    @FindBy(id = "customer.address.state")
    private WebElement state;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phone;

    @FindBy(id = "customer.ssn")
    private WebElement ssn;

    @FindBy(id = "customer.username")
    private WebElement username;

    @FindBy(id = "customer.password")
    private WebElement password;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerBtn;

    public void enterFirstName(String value) {
        sendValueToTextBox(firstName, value);
    }

    public void enterLastName(String value) {
        sendValueToTextBox(lastName, value);
    }

    public void enterAddress(String value) {
        sendValueToTextBox(address, value);
    }

    public void enterCity(String value) {
        sendValueToTextBox(city, value);
    }

    public void enterState(String value) {
        sendValueToTextBox(state, value);
    }

    public void enterZip(String value) {
        sendValueToTextBox(zipCode, value);
    }

    public void enterPhone(String value) {
        sendValueToTextBox(phone, value);
    }

    public void enterSSN(String value) {
        sendValueToTextBox(ssn, value);
    }

    public void enterUsername(String value) {
        sendValueToTextBox(username, value);
    }

    public void enterPassword(String value) {
        sendValueToTextBox(password, value);
    }

    public void enterConfirmPassword(String value) {
        sendValueToTextBox(confirmPassword, value);
    }

    public void clickRegister() {
        clickOnElement(registerBtn);
    }

}