package org.parabank.pages;

import org.parabank.utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.parabank.utilities.BaseClass;

import static java.lang.Thread.sleep;

public class transferFundsPage extends BaseClass {

    public WebDriver driver;
    @FindBy (xpath = "//*[@id=\"leftPanel\"]/ul/li[3]/a")
    private WebElement transfer;
    public void clktransferpage() throws InterruptedException {
        clickOnElement(transfer);
        sleep(3000);
    }
    @FindBy(id="amount")
    private WebElement amt;
    public void enterAmt(String amount) throws InterruptedException {
        sleep(3000);
        sendValueToTextBox(amt,amount);
    }

    @FindBy(xpath = "//*[@id=\"transferForm\"]/div[2]/input")
    private WebElement clktrsf;
    public void clkTransfer(){
        clickOnElement(clktrsf);
    }
    public transferFundsPage(WebDriver driver){
            this.driver= driver;
            PageFactory.initElements(driver,this);
        }

}
