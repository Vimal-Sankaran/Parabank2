package org.parabank.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.parabank.helpers.Account;
import org.parabank.helpers.EntityHelper;
import org.parabank.helpers.ParabankData;
import org.parabank.pages.NewAccountPage;
import org.parabank.utilities.BaseClass;
import org.parabank.utilities.ConfigReader;

import java.util.List;

public class NewAccountPageSteps extends BaseClass {
    NewAccountPage newAccountPage;
    EntityHelper entityHelper;
    ConfigReader configReader;

    public NewAccountPageSteps(){
        newAccountPage=new NewAccountPage(driver);
        entityHelper=new EntityHelper();
        configReader=new ConfigReader();
    }

    @Given("I click New Account link to open account")
    public void setNewAccOpenLink(){newAccountPage.clickNewAccountLink();}

    @Given("I select savings accounts in dropdown{string}")
    public void setSelectAccountType(String value){newAccountPage.selectAccountType(value);}

    @Given("I click open account")
    public void setSelectFromAcc(){newAccountPage.clickOpenAccount();}

    @Given("I navigate to new account details page")
    public void setNewAccDetails(){
        attachScreenshotToReport();
        newAccountPage.clickNewAccID();
    }
    @Then("I validate the account opening message")
    public void setValidationMessage(){
        newAccountPage.getMessage1();
        newAccountPage.getMessage2();
    }
    @And("I create savings{string} account")
    public void createSavingsAccount(String value) throws InterruptedException {
        newAccountPage.clickNewAccountLink();
        newAccountPage.selectAccountType(value);
        Thread.sleep(3000);
        newAccountPage.clickOpenAccount();
        newAccountPage.clickNewAccID();
    }
    @Then("I capture new account details to json file{string}")
    public void getNewAccDetails(String id) throws InterruptedException {
        Thread.sleep(1000);
        Account account=new Account();
        account.setAccountNumber(newAccountPage.getNewAccNo());
        account.setAccountType(newAccountPage.getNewAccType());
        account.setBalance(newAccountPage.getBalance());
        account.setAvailableBalance(newAccountPage.getAvlBal());

        List<ParabankData> allData=entityHelper.readJson();
        for(ParabankData data: allData){
            if (data.getId().equals(id)){
                data.getAccounts().add(account);
            }
        }
        entityHelper.writeJson(allData);

    }
}
