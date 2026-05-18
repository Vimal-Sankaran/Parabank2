package org.parabank.pages;

import org.parabank.utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    public WebDriver driver;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement loginButton;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    /*
     * Constructor
     */
    public LoginPage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
    }

    /*
     * Actions
     */
    public void setUsername(String value) {
        sendValueToTextBox(username, value);
    }

    public void setPassword(String value) {
        sendValueToTextBox(password, value);
    }

    public void clickLogin() {
        clickOnElement(loginButton);
    }

    public void clickRegisterLink() {
        clickOnElement(registerLink);
    }

}