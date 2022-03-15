package main.java.ActionDriver;

import main.java.actionInterface.ActionInterface;
import main.java.commun.ApplicationCommonScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Action extends ApplicationCommonScript implements ActionInterface {
    @Override
    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {

    }

    @Override
    public void click(WebDriver ldriver, WebElement ele) {

    }

    @Override
    public boolean isDisplayed(WebDriver ldriver, WebElement ele) {
        return false;
    }

    @Override
    public boolean type(WebElement ele, String text) {
        return false;
    }

    @Override
    public boolean findElement(WebDriver ldriver, WebElement ele) {
        return false;
    }

    @Override
    public boolean isSelected(WebDriver ldriver, WebElement ele) {
        return false;
    }

    @Override
    public boolean isEnabled(WebDriver ldriver, WebElement ele) {
        return false;
    }

    @Override
    public boolean selectBySendkeys(String value, WebElement ele) {
        return false;
    }

    @Override
    public boolean selectByIndex(WebElement element, int index) {
        return false;
    }

    @Override
    public boolean selectByValue(WebElement element, String value) {
        return false;
    }

    @Override
    public boolean selectByVisibleText(String visibletext, WebElement ele) {
        return false;
    }

    @Override
    public boolean mouseHoverByJavaScript(WebElement locator) {
        return false;
    }

    @Override
    public boolean JSClick(WebDriver driver, WebElement ele) {
        return false;
    }

    @Override
    public boolean switchToFrameByIndex(WebDriver driver, int index) {
        return false;
    }

    @Override
    public boolean switchToFrameById(WebDriver driver, String idValue) {
        return false;
    }

    @Override
    public boolean switchToFrameByName(WebDriver driver, String nameValue) {
        return false;
    }

    @Override
    public boolean switchToDefaultFrame(WebDriver driver) {
        return false;
    }

    @Override
    public void mouseOverElement(WebDriver driver, WebElement element) {

    }

    @Override
    public boolean moveToElement(WebDriver driver, WebElement ele) {
        return false;
    }

    @Override
    public boolean mouseover(WebDriver driver, WebElement ele) {
        return false;
    }

    @Override
    public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
        return false;
    }

    @Override
    public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
        return false;
    }

    @Override
    public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
        return false;
    }

    @Override
    public boolean rightclick(WebDriver driver, WebElement ele) {
        return false;
    }

    @Override
    public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
        return false;
    }

    @Override
    public boolean switchToNewWindow(WebDriver driver) {
        return false;
    }

    @Override
    public boolean switchToOldWindow(WebDriver driver) {
        return false;
    }

    @Override
    public int getColumncount(WebElement row) {
        return 0;
    }

    @Override
    public int getRowCount(WebElement table) {
        return 0;
    }

    @Override
    public boolean Alert(WebDriver driver) {
        return false;
    }

    @Override
    public boolean launchUrl(WebDriver driver, String url) {
        return false;
    }

    @Override
    public boolean isAlertPresent(WebDriver driver) {
        return false;
    }

    @Override
    public String getCurrentURL(WebDriver driver) {
        return null;
    }

    @Override
    public String getTitle(WebDriver driver) {
        return null;
    }

    @Override
    public boolean click1(WebElement locator, String locatorName) {
        return false;
    }

    @Override
    public void fluentWait(WebDriver driver, WebElement element, int timeOut) {

    }

    @Override
    public void implicitWait(WebDriver driver, int timeOut) {

    }

    @Override
    public void explicitWait(WebDriver driver, WebElement element, int timeOut) {

    }

    @Override
    public void pageLoadTimeOut(WebDriver driver, int timeOut) {

    }

    @Override
    public String screenShot(WebDriver driver, String filename) {
        return null;
    }

    @Override
    public String getCurrentTime() {
        return null;
    }
}
