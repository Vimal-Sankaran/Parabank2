package org.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.parabank.utilities.BaseClass;

public class NewAccountPage extends BaseClass {
    public WebDriver driver;

//    Constructor
public NewAccountPage(WebDriver driver1) {
    this.driver = driver1;
    PageFactory.initElements(driver, this);
}
// Actions
@FindBy(id = "type")
private WebElement accountType;

@FindBy(xpath = "//h1[contains(text( ),'Open New Account')]")
private WebElement NewAccText;

@FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[1]/a")
private WebElement newAccountLink;

@FindBy(xpath = "//*[@id=\"openAccountForm\"]/form/div/input")
    private WebElement openAccButton;

@FindBy(xpath = "//h1[contains(text( ), 'Account Opened')]")
private WebElement openText1;

@FindBy(xpath = "//p[contains(text( ), 'Congratulations')]")
    private WebElement openText2;

@FindBy(xpath = "//a[@id=\"newAccountId\"]")
private WebElement newAccId;

@FindBy(id = "accountId")
private WebElement accountId;

@FindBy(id = "accountType")
private WebElement getAccountType;

@FindBy(id = "balance")
private WebElement balance;

@FindBy(id = "availableBalance")
private WebElement availableBalance;

public void clickNewAccountLink(){clickOnElement(newAccountLink);}

public void selectAccountType(String value){
    clickOnElement(accountType);
selectDropDownByValue(accountType,value);
}

public void clickOpenAccount(){
    waitForElementVisible(openAccButton,10);
    waitForElementClickable(openAccButton,10);
    clickOnElement(openAccButton);
}

public void clickNewAccID(){clickOnElement(newAccId);}

public void getMessage1(){getElementText(openText1);}

public void getMessage2(){getElementText(openText2);}

public void getNewAccNumber(){getElementText(newAccId);}

    public String getNewAccNo(){return getElementText(accountId);}
    public String getNewAccType(){return getElementText(getAccountType);}
    public String getBalance(){return getElementText(balance);}
    public String getAvlBal(){return getElementText(availableBalance);}

}
