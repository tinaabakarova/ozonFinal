package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public abstract class BaseSteps {

    public void waitForVisibleElementLocated(WebDriverWait wait, By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisibleElement(WebDriverWait wait, WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitToBeClicable(WebDriverWait wait, By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
