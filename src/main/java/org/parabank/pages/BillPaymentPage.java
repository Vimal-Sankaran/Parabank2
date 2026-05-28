package org.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.parabank.utilities.BaseClass;

public class BillPaymentPage extends BaseClass {
    public WebDriver driver;

    // Constructor
    public BillPaymentPage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
    }

    //actions
    @FindBy(xpath = "//a[contains(text( ), 'Bill')]")
    private WebElement billPaymentLink;

    @FindBy(name = "payee.name")
    private WebElement payeeName;

    @FindBy(name = "payee.address.street")
    private WebElement payeeAddressStreet;

    @FindBy(name = "payee.address.city")
    private WebElement payeeCity;

    @FindBy(name = "payee.address.state")
    private WebElement payeeState;

    @FindBy(name = "payee.address.zipCode")
    private WebElement payeeZipCode;

    @FindBy(name = "payee.phoneNumber")
    private WebElement payeePhone;

    @FindBy(name = "payee.accountNumber")
    private WebElement payeeAccountNumber;

    @FindBy(name = "verifyAccount")
    private WebElement payeeVerifyAccNumber;

    @FindBy(name = "amount")
    private WebElement billAmount;

    @FindBy(name = "fromAccountId")
    private WebElement fromAccNo;

    @FindBy(xpath = "//input[@value='Send Payment']")
    private WebElement sendPaymentButton;

    @FindBy(xpath = "//*[@id=\"billpayResult\"]/p[1]")
    private WebElement billPayResultMsg;


    public void setBillPaymentLink(){
        clickOnElement(billPaymentLink);
    }
    public void setPayeeName(String value){
        sendValueToTextBox(payeeName,value);
    }

    public void setPayeeAddressStreet(String value){
        sendValueToTextBox(payeeAddressStreet,value);
    }
    public void setPayeeCity(String value){
        sendValueToTextBox(payeeCity,value);
    }
    public void setPayeeState(String value){
        sendValueToTextBox(payeeState,value);
    }
    public void setPayeeZipCode(String value){
        sendValueToTextBox(payeeZipCode,value);
    }
    public void setPayeePhone(String value){
        sendValueToTextBox(payeePhone,value);
    }
    public void setPayeeAccountNumber(String value){
        sendValueToTextBox(payeeAccountNumber,value);
    }
    public void setPayeeVerifyAccNumber(String value){
        sendValueToTextBox(payeeVerifyAccNumber,value);
    }
    public void setBillAmount(String value){
        sendValueToTextBox(billAmount,value);
    }
    public void setFromAccNo(String value){
        selectDropDownByValue(fromAccNo,value);
    }

    public void setSendPaymentButton(){
        clickOnElement(sendPaymentButton);
    }

    public String getBillPayResultMsg(){
        waitForElementVisible(billPayResultMsg,10);
        String message=getElementText(billPayResultMsg);
        return message;

    }

}
