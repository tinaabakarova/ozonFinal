package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by student on 03.11.2018.
 */
public abstract class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    public void click(WebElement element){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void scroll(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);",element);
    }

    public WebDriver getDriver() {
       return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement findByLocator(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        findByLocator(locator).click();
    }

    public void click(String xpath){
        findByXpath(xpath).click();
    }

    public void checkElementText(WebElement element, String expectedText){
        Assert.assertEquals("Значения текст не соотвествует ожидаемому",
                expectedText, element.getText());
    }

}
