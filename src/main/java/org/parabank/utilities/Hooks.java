package org.parabank.utilities;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{
    ConfigReader config = new ConfigReader();

    @Before
    public void setup() {
        setChromeBrowser();
        loadURL(config.getProperty("url"));
    }

//    @After
//    public void tearDown() {
//        if (BaseClass.driver != null) {
//            closeBrowser();
//            BaseClass.driver = null;
//        }
//    }
}
