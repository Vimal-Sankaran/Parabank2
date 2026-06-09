package org.parabank.stepdefinitions;

import io.cucumber.java.en.Given;
import org.parabank.helpers.EntityHelper;
import org.parabank.pages.FindTransactionsPage;
import org.parabank.utilities.BaseClass;
import org.parabank.utilities.ConfigReader;

public class FindTransactionsPagesteps extends BaseClass {
    EntityHelper entityHelper;
    ConfigReader configReader;
    FindTransactionsPage FindTransPage;

    public FindTransactionsPagesteps(){
        FindTransPage = new FindTransactionsPage(driver);
        entityHelper=new EntityHelper();
        configReader=new ConfigReader();
    }

    @Given("I click on Find Transactions page and find transactions by date and search by today's date {string}")
    public void clkfindtranspage(String date) {
        FindTransPage.clickFindtranspage();
        FindTransPage.dateinput(date);
        FindTransPage.clkfindtrans();

    }
    @Given("I click on Find Transactions page and find transactions by month and search by entering Start date {string} and End date {string}")
    public void clkfindtranspagebymonth(String date,String date1)  {
        FindTransPage.clickFindtranspage();
        FindTransPage.clkfindtransbymonth(date, date1);


    }
    @Given("I click on Find Transactions page and find transactions by amount and search by entering amount {string}")
    public void clkfindtransbyamout(String amt)  {
        FindTransPage.clickFindtranspage();
        FindTransPage.clkfindtransbyamt(amt);

    }

}
