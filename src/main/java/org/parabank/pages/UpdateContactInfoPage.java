package org.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.parabank.utilities.BaseClass;

public class UpdateContactInfoPage extends BaseClass {
    public WebDriver driver;

    //    Constructor
    public UpdateContactInfoPage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[contains(text( ),'Update Contact Info')]")
    private WebElement updateContactInfoLink;
    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    private WebElement address;
    @FindBy(id = "customer.address.city")
    private WebElement city;
    @FindBy(id = "customer.address.state")
    private WebElement state;
    @FindBy(id = "customer.address.zipCode")
    private WebElement zipcode;
    @FindBy(id = "customer.phoneNumber")
    private WebElement phone;
    @FindBy(xpath = "//input[@type='button']")
    private WebElement updateProfile;

    @FindBy(xpath = "//p[contains(text( ),'Your updated address and phone number')]")
    private WebElement updateProfileMessage;

    public void clickUpdateContactLink(){clickOnElement(updateContactInfoLink);}

    public void setAddress(String value){
        address.clear();
        sendValueToTextBox(address,value);
    }
    public void setCity(String value){
        city.clear();
        sendValueToTextBox(city,value);
    }
    public void setZipcode(String value){
        zipcode.clear();
        sendValueToTextBox(zipcode,value);
    }
    public void setPhone(String value){
        phone.clear();
        sendValueToTextBox(phone,value);
    }
    public void clickUpdateProfile(){clickOnElement(updateProfile);}

    public String getUpdateProfileMsg(){
        waitForElementVisible(updateProfileMessage,10);
        String message=getElementText(updateProfileMessage);
        return message;
    }
}
