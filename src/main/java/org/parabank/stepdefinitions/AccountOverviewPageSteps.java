package org.parabank.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.parabank.helpers.Account;
import org.parabank.helpers.EntityHelper;
import org.parabank.helpers.ParabankData;
import org.parabank.pages.AccountOverviewPage;
import org.parabank.pages.BillPaymentPage;
import org.parabank.utilities.BaseClass;
import org.parabank.utilities.ConfigReader;

import java.util.List;

public class AccountOverviewPageSteps extends BaseClass {
    AccountOverviewPage accountOverviewPage;
    EntityHelper entityHelper;
    ConfigReader configReader;

    public AccountOverviewPageSteps() {
        accountOverviewPage = new AccountOverviewPage(driver);
        entityHelper = new EntityHelper();
        configReader = new ConfigReader();
    }

    @Given("I click Account Overview to get account details")
    public void getDefaultAcct() {
        accountOverviewPage.clickAccOverview();
        accountOverviewPage.clickNewAccID();
    }

    @Then("I capture new checkings account details to json file{string}")
    public void getNewAccDetails(String id) throws InterruptedException {
        Thread.sleep(1000);
        Account account = new Account();
        account.setAccountNumber(accountOverviewPage.getNewAccNo());
        account.setAccountType(accountOverviewPage.getNewAccType());
        account.setBalance(accountOverviewPage.getNewAccBalance());
        account.setAvailableBalance(accountOverviewPage.getNewAccAvlBAL());

        List<ParabankData> allData = entityHelper.readJson();
        for (ParabankData data : allData) {
            if (data.getId().equals(id)) {
                data.getAccounts().add(account);
            }
        }
    }
}
