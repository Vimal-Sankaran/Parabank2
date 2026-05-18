package org.parabank.stepdefinitions;

import io.cucumber.java.en.Given;
import org.parabank.helpers.EntityHelper;
import org.parabank.pages.LoginPage;
import org.parabank.utilities.BaseClass;
import org.parabank.utilities.ConfigReader;

public class LoginPageSteps extends BaseClass {

    LoginPage loginPage;

    EntityHelper entityHelper;

    ConfigReader config = new ConfigReader();

    /*
     * Constructor
     */
    public LoginPageSteps() {

        loginPage =
                new LoginPage(driver);

        entityHelper =
                new EntityHelper();
    }

    /*
     * Individual Steps
     */
    @Given("I enter username {string} in Parabank Login Page")
    public void setUsername(String value) {
        loginPage.setUsername(value);
    }

    @Given("I enter password {string} in Parabank Login Page")
    public void setPassword(String value) {
        loginPage.setPassword(value);
    }

    @Given("I click on login button in Parabank Login Page")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    /*
     * Direct Login
     */
    @Given("I login with username {string} and password {string}")
    public void login(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
    }

    /*
     * Login Using JSON
     */
    @Given("I login as parabank customer {string}")
    public void loginWithJson(String id) {
        attachScreenshotToReport();
        loginPage.setUsername(entityHelper.getDataById(id).getCredentials().getUsername());
        loginPage.setPassword(entityHelper.getDataById(id).getCredentials().getPassword());
        loginPage.clickLogin();
    }

    /*
     * Navigate to Registration
     */
    @Given("I navigate to Parabank Registration Page")
    public void navigateToRegisterPage() {
        loginPage.clickRegisterLink();
    }
}
