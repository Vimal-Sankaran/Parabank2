package org.parabank.utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BaseClass {

    public static WebDriver driver;

    public static ConfigReader config = new ConfigReader();

    /*
     * Browser Launch
     */
    public static WebDriver setChromeBrowser() {

        if (driver == null) {

            System.setProperty(
                    "Webdriver.chrome.driver",
                    config.getProperty("chromeDriverPath")
            );

            driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    /*
     * Browser Utilities
     */
    public static void maximizeBrowserWindow() {
        driver.manage().window().maximize();
    }

    public static void loadURL(String url) {
        driver.get(url);
    }

    public static String getCurrentURl() {
        return driver.getCurrentUrl();
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }

    public static void navigateForward() {
        driver.navigate().forward();
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static void closeTab() {
        driver.close();
    }

    public static void closeBrowser() {

        if (driver != null) {

            driver.quit();

            driver = null;
        }
    }

    /*
     * Window Handling
     */
    public static String captureWindowHandle() {
        return driver.getWindowHandle();
    }

    public static List<String> captureWindowHandles() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    public static void switchToWindow(String handle) {
        driver.switchTo().window(handle);
    }

    public static void switchToWindowTitle(String title) {

        Set<String> allWindowHandles =
                driver.getWindowHandles();

        for (String handle : allWindowHandles) {

            driver.switchTo().window(handle);

            if (driver.getTitle()
                    .equalsIgnoreCase(title)) {

                break;
            }
        }
    }

    /*
     * Alert Handling
     */
    public static void switchToAlertAccept() {
        driver.switchTo().alert().accept();
    }

    public static void switchToAlertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public static void switchToAlertEnterValueAndAccept(
            String value
    ) {

        Alert alert = driver.switchTo().alert();

        alert.sendKeys(value);

        alert.accept();
    }

    /*
     * Frame Handling
     */
    public static void switchToFrameWithIdOrName(
            String idOrName
    ) {

        driver.switchTo().frame(idOrName);
    }

    public static void switchToFrameElement(
            WebElement element
    ) {

        driver.switchTo().frame(element);
    }

    public static void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    public static void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    /*
     * Element Utilities
     */
    public static void clearValue(WebElement element) {
        element.clear();
    }

    public static void sendValueToTextBox(
            WebElement element,
            String value
    ) {

        clearValue(element);

        element.sendKeys(value);
    }

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    public static String getElementText(WebElement element) {
        return element.getText();
    }

    public static String getAttribute(
            WebElement element,
            String attribute
    ) {

        return element.getAttribute(attribute);
    }

    public static String getTextBoxValue(
            WebElement element
    ) {

        return element.getAttribute("value");
    }

    public static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    public static boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    /*
     * Explicit Waits
     */
    public static WebElement waitForElementVisible(
            WebElement element,
            int seconds
    ) {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(seconds)
                );

        return wait.until(
                ExpectedConditions.visibilityOf(element)
        );
    }

    public static WebElement waitForElementClickable(
            WebElement element,
            int seconds
    ) {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(seconds)
                );

        return wait.until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }

    /*
     * Dropdown
     */
    public static void selectDropDownByValue(
            WebElement element,
            String value
    ) {

        Select select = new Select(element);

        select.selectByValue(value);
    }

    public static void selectDropDownByText(
            WebElement element,
            String value
    ) {

        Select select = new Select(element);

        select.selectByVisibleText(value);
    }

    public static void selectDropDownByIndex(
            WebElement element,
            int index
    ) {

        Select select = new Select(element);

        select.selectByIndex(index);
    }

    public static String getSelectedOption(
            WebElement element
    ) {

        Select select = new Select(element);

        return select.getFirstSelectedOption().getText();
    }

    /*
     * Mouse Actions
     */
    public static void mouseHover(WebElement element) {

        Actions a = new Actions(driver);

        a.moveToElement(element).perform();
    }

    public static void doubleClick(WebElement element) {

        Actions a = new Actions(driver);

        a.doubleClick(element).perform();
    }

    public static void rightClick(WebElement element) {

        Actions a = new Actions(driver);

        a.contextClick(element).perform();
    }

    public static void dragAndDrop(
            WebElement source,
            WebElement target
    ) {

        Actions a = new Actions(driver);

        a.dragAndDrop(source, target).perform();
    }

    /*
     * JavaScript Utilities
     */
    public static void scrollWindow() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,400)");
    }

    public static void scrollIntoElement(
            WebElement element
    ) {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView(true)",
                element
        );
    }

    public static void javascriptClick(
            WebElement element
    ) {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                element
        );
    }

    /*
     * Keyboard Actions
     */
    public static void keyboardTabKey()
            throws AWTException {

        Robot r = new Robot();

        r.keyPress(KeyEvent.VK_TAB);

        r.keyRelease(KeyEvent.VK_TAB);
    }

    public static void keyboardEnterKey()
            throws AWTException {

        Robot r = new Robot();

        r.keyPress(KeyEvent.VK_ENTER);

        r.keyRelease(KeyEvent.VK_ENTER);
    }

    /*
     * Screenshot Utilities
     */
    public static void takeScreenshot() {

        try {

            File folder = new File(
                    config.getProperty("screenshotPath")
            );

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String filename =
                    "Screenshot_"
                            + new SimpleDateFormat(
                            "ddMMyyyy_HHmmss_SSS"
                    ).format(new Date())
                            + ".png";

            TakesScreenshot ts =
                    (TakesScreenshot) driver;

            File source =
                    ts.getScreenshotAs(OutputType.FILE);

            File destination = new File(
                    config.getProperty("screenshotPath")
                            + File.separator
                            + filename
            );

            FileHandler.copy(source, destination);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public static void takeFullScreenScreenShot(
            String location
    ) throws IOException {

        Screenshot scr =
                new AShot()
                        .shootingStrategy(
                                ShootingStrategies.viewportPasting(1000)
                        )
                        .takeScreenshot(driver);

        ImageIO.write(
                scr.getImage(),
                "png",
                new File(location)
        );
    }

    /*
     * Assertions
     */
    public static void assertEquals(
            String actual,
            String expected,
            String message
    ) {

        Assert.assertEquals(message, expected, actual);
    }

    /*
     * Extent Screenshot
     */
    public static void attachScreenshotToReport() {

        try {

            String base64Screenshot =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BASE64);

            ExtentTest test =
                    ExtentCucumberAdapter.getCurrentStep();

            if (test != null) {

                test.info(
                        "Screenshot",
                        MediaEntityBuilder
                                .createScreenCaptureFromBase64String(
                                        base64Screenshot
                                )
                                .build()
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Failed to attach screenshot : "
                            + e.getMessage()
            );
        }
    }
}