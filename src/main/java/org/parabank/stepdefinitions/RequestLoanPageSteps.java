package org.parabank.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.parabank.helpers.Account;
import org.parabank.helpers.EntityHelper;
import org.parabank.pages.RequestLoanPage;
import org.parabank.utilities.BaseClass;
import org.parabank.utilities.ConfigReader;

public class RequestLoanPageSteps extends BaseClass {

    RequestLoanPage requestLoanPage;
    EntityHelper entityHelper;
    ConfigReader configReader;

    public RequestLoanPageSteps() {
        requestLoanPage = new RequestLoanPage(driver);
        entityHelper = new EntityHelper();
        configReader = new ConfigReader();
    }

    @Given("I Click Request Loan Link")
    public void clickRequestLoan() {
        requestLoanPage.setClickRequestLoanLink();
    }

    @And("I Enter Loan Amount {string}")
    public void setLoanAmount(String Value) {
        requestLoanPage.enterLoanAmount(Value);
    }

    @And("I Enter Down Payment Amount {string}")
    public void setDownPayment(String Value) {
        requestLoanPage.enterDownPayment(Value);
    }

    @And("I Select From Account Type from Dropdown {string}")
    public void selectFromAccountType(String Value) {
        requestLoanPage.enterFromAccountId(Value);
    }

    @And("I Click Apply Now Button")
    public void clickApplyNowBtn() {
        requestLoanPage.clickApplyNow();
    }

    @And("I Click New Loan Account Id")
    public void clickNewAccountID() {
        requestLoanPage.clickNewLoanAccountId();
    }


    @Given("I Request a Loan by Entering Loan Amount {string} and Down Payment {string}")

    public void requestLoan(String amount, String payment) {
        requestLoanPage.setClickRequestLoanLink();
        requestLoanPage.enterLoanAmount(amount);
        requestLoanPage.enterDownPayment(payment);
        requestLoanPage.clickApplyNow();
        requestLoanPage.clickNewLoanAccountId();
    }
    @Then("I Capture Loan Account Details to JSON {string}")
    public void captureLoanDetails (String ID)  {

        Account account =new Account();
        account.setAccountNumber(requestLoanPage.getAccNo());
        account.setAccountType(requestLoanPage.getAccType());
        account.setBalance(requestLoanPage.getAccBalance());
        account.setAvailableBalance(requestLoanPage.getAvailableBalance());
        entityHelper.addAccountById(ID, account);}

}