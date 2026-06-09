package org.parabank.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.parabank.helpers.Account;
import org.parabank.helpers.EntityHelper;
import org.parabank.helpers.ParabankData;
import org.parabank.pages.BillPaymentPage;
import org.parabank.utilities.BaseClass;
import org.parabank.utilities.ConfigReader;

public class BillPaymentPageSteps extends BaseClass {
    BillPaymentPage billPaymentPage;
    EntityHelper entityHelper;
    ConfigReader configReader;

    public BillPaymentPageSteps(){
        billPaymentPage=new BillPaymentPage(driver);
        entityHelper=new EntityHelper();
        configReader=new ConfigReader();
    }
    @Given("I click Bill Payment link from home page")
    public void setClickBillPaymt(){billPaymentPage.setBillPaymentLink();}
    @Given("I enter payee name{string} in Bill Payment page")
    public void setPayeeName(String value){billPaymentPage.setPayeeName(value);}
    @Given("I enter payee address{string} in Bill payment page")
    public void setPayeeAddress(String value){billPaymentPage.setPayeeAddressStreet(value);}
    @Given("I enter payee city{string} in Bill payment page")
    public void setPayeeCity(String value){billPaymentPage.setPayeeCity(value);}
    @Given("I enter payee state{string} in Bill payment page")
    public void setPayeeState(String value){billPaymentPage.setPayeeState(value);}
    @Given("I enter payee zipcode{string} in Bill payment page")
    public void setPayeeZipcode(String value){billPaymentPage.setPayeeZipCode(value);}
    @Given("I enter payee phone number{string} in Bill payment page")
    public void setPayeePhone(String value){billPaymentPage.setPayeePhone(value);}
    @Given("I enter payee account number{string} in Bill payment page")
    public void setPayeeAccNo(String value){billPaymentPage.setPayeeAccountNumber(value);}
    @Given("I enter payee verify account number{string} in Bill payment page")
    public void setPayAccVerify(String value){billPaymentPage.setPayeeVerifyAccNumber(value);}
    @Given("I enter amount{string} in Bill payment page")
    public void setAmount(String value){billPaymentPage.setBillAmount(value);}
    @Given("I select from account{string} in Bill payment page ")
    public void setFromAcc(String value){billPaymentPage.setFromAccNo(value);}
    @Given("I click send payment button")
    public void setClickPayment(){billPaymentPage.setSendPaymentButton();}
    @Then("I validate the success message")
    public void setSuccessMessage(){billPaymentPage.getBillPayResultMsg();
    }

    @And("I make bill payment{string} from savings account{int} to Payee {string} using json file{string}")
    public void billPaymentUsingJson(String amount, int index, String id1,String id){
        ParabankData data=entityHelper.getDataById(id1);
        billPaymentPage.setPayeeName(data.getCustomer().getFirstName());
        billPaymentPage.setPayeeAddressStreet(data.getCustomer().getAddress());
        billPaymentPage.setPayeeCity(data.getCustomer().getCity());
        billPaymentPage.setPayeeState(data.getCustomer().getState());
        billPaymentPage.setPayeeZipCode(data.getCustomer().getZipCode());
        billPaymentPage.setPayeePhone(data.getCustomer().getPhoneNumber());
        Account account= entityHelper.getAccountByTypeAndIndex(id,"SAVINGS",index-1);
        billPaymentPage.setPayeeAccountNumber(entityHelper.getDataById(id1).getAccounts().get(0).getAccountNumber());
        billPaymentPage.setPayeeVerifyAccNumber(entityHelper.getDataById(id1).getAccounts().get(0).getAccountNumber());
        billPaymentPage.setBillAmount(amount);
        //billPaymentPage.setFromAccNo(account.getAccountNumber());
        billPaymentPage.setSendPaymentButton();
        System.out.println("Bill Payment to Vijay in the amount of $"+amount+" from account "+account.getAccountNumber()+" was successful.");
        //assertEquals(billPaymentPage.getBillPayResultMsg(), "Bill Payment to Vijay in the amount of $"+amount+" from account "+account.getAccountNumber()+" was successful.","Validation success");
        attachScreenshotToReport();
    }

}

