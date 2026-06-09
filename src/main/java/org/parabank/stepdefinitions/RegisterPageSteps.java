package org.parabank.stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.parabank.helpers.*;
import org.parabank.pages.RegisterPage;

import org.parabank.utilities.BaseClass;

import java.util.List;

public class RegisterPageSteps extends BaseClass {

    RegisterPage registerPage;
    EntityHelper entityHelper;

    public RegisterPageSteps() {

        registerPage =
                new RegisterPage(driver);

        entityHelper =
                new EntityHelper();
    }

    @Given("I enter first name {string} in registration page")
    public void enterFirstName(String value) {
        registerPage.enterFirstName(value);
    }

    @Given("I enter last name {string} in registration page")
    public void enterLastName(String value) {
        registerPage.enterLastName(value);
    }

    @Given("I enter address {string} in registration page")
    public void enterAddress(String value) {
        registerPage.enterAddress(value);
    }

    @Given("I enter city {string} in registration page")
    public void enterCity(String value) {
        registerPage.enterCity(value);
    }

    @Given("I enter state {string} in registration page")
    public void enterState(String value) {
        registerPage.enterState(value);
    }

    @Given("I enter zip code {string} in registration page")
    public void enterZip(String value) {
        registerPage.enterZip(value);
    }

    @Given("I enter phone number {string} in registration page")
    public void enterPhone(String value) {
        registerPage.enterPhone(value);
    }

    @Given("I enter SSN {string} in registration page")
    public void enterSSN(String value) {
        registerPage.enterSSN(value);
    }

    @Given("I enter username {string} in registration page")
    public void enterUsername(String value) {
        registerPage.enterUsername(value);
    }

    @Given("I enter password {string} in registration page")
    public void enterPassword(String value) {
        registerPage.enterPassword(value);
    }

    @Given("I enter confirm password {string} in registration page")
    public void enterConfirmPassword(String value) {
        registerPage.enterConfirmPassword(value);
    }

    @Given("I click register button in registration page")
    public void clickRegister() {registerPage.clickRegister();}


    @Given("I register customer with json {string}")
    public void registerCustomer(String id) {

        ParabankData data =
                entityHelper.getDataById(id);

        // 1. Fill registration form
        registerPage.enterFirstName(
                data.getCustomer().getFirstName()
        );

        registerPage.enterLastName(
                data.getCustomer().getLastName()
        );

        registerPage.enterAddress(
                data.getCustomer().getAddress()
        );

        registerPage.enterCity(
                data.getCustomer().getCity()
        );

        registerPage.enterState(
                data.getCustomer().getState()
        );

        registerPage.enterZip(
                data.getCustomer().getZipCode()
        );

        registerPage.enterPhone(
                data.getCustomer().getPhoneNumber()
        );

        registerPage.enterSSN(
                data.getCustomer().getSsn()
        );

        registerPage.enterUsername(
                data.getCredentials().getUsername()
        );

        registerPage.enterPassword(
                data.getCredentials().getPassword()
        );

        registerPage.enterConfirmPassword(
                data.getCredentials().getPassword()
        );

        registerPage.clickRegister();

    }

}