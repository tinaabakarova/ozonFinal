package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoriesPage extends BasePage{
    private static final String categoryFormat = "//div[contains(@class,'category-filter')]//a[contains(text(),'%s')]";

    private static By targetItemLocator = By.xpath("//div[contains(@class,'category-filter')]/ul");

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    public By getTargetItemLocator() {
        return targetItemLocator;
    }

    public void chooseCategorySecond(String name){
        getDriver().findElement(By.xpath(String.format(categoryFormat, name))).click();
    }
}
