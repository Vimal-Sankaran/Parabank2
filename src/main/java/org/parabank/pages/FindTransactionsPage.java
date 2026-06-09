package org.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.parabank.utilities.BaseClass;

public class FindTransactionsPage extends BaseClass {
    public WebDriver driver;

    public FindTransactionsPage (WebDriver driver1){
        this.driver=driver1;
        PageFactory.initElements(driver, this);
        }
        @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[5]/a")
        private WebElement Findtranspage;
    public void clickFindtranspage(){clickOnElement(Findtranspage);}
@FindBy(xpath = "//*[@id=\"accountId\"]")
        private WebElement dropdownacctselt;
    public void clickdropdownacctselect(String value){
        clickOnElement(dropdownacctselt);
        selectDropDownByValue(dropdownacctselt,value);
    }
    @FindBy(xpath = "//*[@id=\"transactionDate\"]")
     private WebElement inputdate;
    public void dateinput(String value){
        clickOnElement(inputdate);
        sendValueToTextBox(inputdate,value);
    }
    @FindBy(id = "findByDate")
    private WebElement clkfindtransbutton;
    public void clkfindtrans(){
        clickOnElement(clkfindtransbutton);
    }
    @FindBy(xpath="//*[@id=\"fromDate\"]")
    private WebElement findtransbymonth;
    @FindBy(xpath="//*[@id=\"toDate\"]")
    private WebElement findtransbymonth1;
    @FindBy(id="findByDateRange")
    private WebElement clkonfindtransbymonth;
    public void clkfindtransbymonth(String value, String value1){
        clickOnElement(findtransbymonth);
        sendValueToTextBox(findtransbymonth,value);
        clickOnElement(findtransbymonth1);
        sendValueToTextBox(findtransbymonth1,value1);
        clickOnElement(clkonfindtransbymonth);
    }
    @FindBy(xpath = "//*[@id=\"amount\"]")
    private WebElement findtransbyamt;
    @FindBy(id="findByAmount")
    private WebElement getClkfindtransbyamtbutton;
        public void clkfindtransbyamt(String amount){
        clickOnElement(findtransbyamt);
        sendValueToTextBox(findtransbyamt,amount);
        clickOnElement(getClkfindtransbyamtbutton);

    }



}
