package org.parabank.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.parabank.helpers.Customer;
import org.parabank.helpers.EntityHelper;
import org.parabank.pages.BillPaymentPage;
import org.parabank.pages.UpdateContactInfoPage;
import org.parabank.utilities.BaseClass;
import org.parabank.utilities.ConfigReader;

//import static com.sun.tools.doclint.Entity.ne;

public class UpdateContactInfoPageSteps extends BaseClass {
    UpdateContactInfoPage updateContactInfoPage;
    EntityHelper entityHelper;
    ConfigReader configReader;
    public UpdateContactInfoPageSteps(){
        updateContactInfoPage=new UpdateContactInfoPage(driver);
        entityHelper=new EntityHelper();
        configReader=new ConfigReader();
    }

    @Given("I click Update Contact information link")
    public void setUpdateContactInfoPage(){updateContactInfoPage.clickUpdateContactLink();}
    @And("I update the address{string} and phone{string}")
    public void setAddressPhone(String value,String value1){
        updateContactInfoPage.setAddress(value);
        updateContactInfoPage.setPhone(value1);
    }
    @And("I click update profile button")
    public void clickUpdateProfile(){updateContactInfoPage.clickUpdateProfile();}

    @Then("I validate the update message")
    public void validateProfileUpdateMsg(){
        System.out.println(updateContactInfoPage.getUpdateProfileMsg());
        System.out.println("Your updated address and phone number have been added to the system. ");
        assertEquals(updateContactInfoPage.getUpdateProfileMsg(),"Your updated address and phone number have been added to the system. ","Validation success");
    }

    @And("I update customer info{string},{string} in Json{string}")
    public void setUpdateContactPage(String address,String phone,String id){
        Customer customer=new Customer();
        customer.setAddress(address);
        customer.setPhoneNumber(phone);
        entityHelper.updateCustomerDetails("TC01",customer);
    }
}
