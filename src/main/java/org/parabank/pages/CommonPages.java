package org.parabank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.parabank.utilities.BaseClass.clickOnElement;

public class CommonPages {
    @FindBy(xpath = "//a[contains(text(),'home')]")
    private WebElement clickHomeIcon;

    @FindBy(xpath = "//li[contains(text( ),'ATM Services')]")
    private WebElement atmServices;

    @FindBy(xpath = "//li[contains(text( ),'Online Services')]")
    private WebElement onlineServices;

    @FindBy(xpath = "//a[contains(text(),'about')]")
    private WebElement clickAboutIcon;

    @FindBy(xpath = "//h1[contains(text( ),'ParaSoft Demo Website')]")
    private WebElement aboutParasoft;

    @FindBy(xpath = "//a[contains(text(),'contact')]")
    private WebElement clickContactIcon;

    @FindBy(xpath = "//h1[contains(text( ),'Customer Care')]")
    private WebElement getTitleCustomerCare;

    @FindBy(id = "name")
    private WebElement customerName;

    @FindBy(id = "email")
    private WebElement customerEmail;

    @FindBy(id = "phone")
    private WebElement phoneNo;

    @FindBy(id = "message")
    private WebElement textMessage;

    @FindBy(xpath = "//input[@type='button']")
    private WebElement sentToCustomerCareBtn;

    public void setClickHomeIcon() { clickOnElement(clickHomeIcon); }

    public void setClickAboutIcon() { clickOnElement(clickAboutIcon); }

    public void setClickContactIcon() { clickOnElement(clickContactIcon); }

    public void enterName(String value) { sendValueToTextBox (customerName, value); }

    public void enterEmail(String value) { sendValueToTextBox (customerEmail, value); }

    public void enterPhoneNo(String value) { sendValueToTextBox (phoneNo, value); }

    public void enterTextMessage(String value) { sendValueToTextBox (textMessage, value); }
}
