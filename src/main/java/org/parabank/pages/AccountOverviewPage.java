package org.parabank.pages;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.parabank.utilities.BaseClass;

public class AccountOverviewPage extends BaseClass {
    public WebDriver driver;

    // Constructor
    public AccountOverviewPage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[contains(text( ),'Accounts Overview')]")
    private WebElement accountOverview;

    @FindBy(xpath = "//td/a")
    private WebElement newAccLink;

    @FindBy(id = "accountId")
    private WebElement accountId;
    @FindBy(id = "accountType")
    private WebElement accountType;
    @FindBy(id = "balance")
    private WebElement balance;
    @FindBy(id = "availableBalance")
    private WebElement availableBalance;

    public void clickAccOverview(){clickOnElement(accountOverview);}
    public void clickNewAccID(){clickOnElement(newAccLink);}
    public String getNewAccNo(){return getElementText(accountId);}
    public String getNewAccType(){return getElementText(accountType);}
    public String getNewAccBalance(){return getElementText(balance);}
    public String getNewAccAvlBAL(){return getElementText(availableBalance);}
}
