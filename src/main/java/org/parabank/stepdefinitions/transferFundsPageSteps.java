package org.parabank.stepdefinitions;

import org.parabank.helpers.EntityHelper;
import org.parabank.pages.transferFundsPage;
import io.cucumber.java.en.Given;
import org.parabank.utilities.BaseClass;

import static java.lang.Thread.sleep;

public class transferFundsPageSteps extends BaseClass {

    transferFundsPage tferFundsPage;
    EntityHelper entityhelp;
    public transferFundsPageSteps() {
        tferFundsPage = new transferFundsPage(driver);

        entityhelp = new EntityHelper();
    }

        @Given("I transfer an amount of {string}")
        public void fundTransfer (String id) throws InterruptedException {
            tferFundsPage.clktransferpage();
            tferFundsPage.enterAmt(id);
            //wait(5000);
            //sleep(300);
            tferFundsPage.clkTransfer();
            System.out.println("Transfer sucessfull");
        }
    }