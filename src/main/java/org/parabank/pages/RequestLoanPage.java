package org.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.parabank.utilities.BaseClass;

public class RequestLoanPage extends BaseClass {
    public WebDriver driver;
    public RequestLoanPage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Request Loan')]")
    private WebElement clickRequestLoanLink;

//    @FindBy(xpath = "//input[*[@id="requestLoanForm"]/h1]")
//    private WebElement ApplyForaLoan;

    @FindBy(id = "amount")
    private WebElement loanAmount;

    @FindBy(id = "downPayment")
    private WebElement downPayment;

    @FindBy(id = "fromAccountId")
    private WebElement FromAccountId;

    @FindBy(xpath = "//input[@type='button']")
    private WebElement clickApplyNowBtn;

    @FindBy(xpath = "//h1[contains(text( ),'Loan Request Processed')]")
    private WebElement LoanRequestProcessedMessage;

    @FindBy(id = "loanProviderName")
    private WebElement LoanProviderName;

    @FindBy(id = "responseDate")
    private WebElement CreatedDate;

    @FindBy(id = "loanStatus")
    private WebElement LoanStatus;

    @FindBy(id = "newAccountId")
    private WebElement NewLoanAccountId;

    @FindBy(id = "accountId")
    private WebElement loanAccountId;

    @FindBy(id = "accountType")
    private WebElement loanAccountType;

    @FindBy(id = "balance")
    private WebElement loanAccountBalance;

    @FindBy(id = "availableBalance")
    private WebElement availableBalance;

    public void setClickRequestLoanLink() { clickOnElement(clickRequestLoanLink); }
    public void enterLoanAmount(String value) { sendValueToTextBox (loanAmount, value); }

    public void enterDownPayment(String value) { sendValueToTextBox (downPayment, value); }

    public void enterFromAccountId(String value) { selectDropDownByValue (FromAccountId, value); }

    public void clickApplyNow() { clickOnElement(clickApplyNowBtn); }

    public void clickNewLoanAccountId() { clickOnElement(NewLoanAccountId); }

    public String getAccNo(){return getElementText(loanAccountId);}
    public String getAccType(){return getElementText(loanAccountType);}
    public String getAccBalance(){return getElementText(loanAccountBalance);}
    public String getAvailableBalance(){return getElementText(availableBalance);}
    }

