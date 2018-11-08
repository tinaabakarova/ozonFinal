package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    private static final String categoryFormat = "//div[contains(@class,'bHeaderCategoryLinks ')]/a[contains(text(),'%s')]";

    private static final By targetElementlocator = By.xpath("//div[contains(@class,'bHeaderCategoryLinks ')]/a[contains(text(),'Электроника')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public By getTargetElementlocator() {
        return targetElementlocator;
    }

    public void chooseCategoryFirst(String name){
        getDriver().findElement(By.xpath(String.format(categoryFormat, name))).click();
    }

}
