package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ChooseItemPage extends BasePage {
    private static final String brandFormat = "//div[@data-test-id='filter-block-brand']//span[@class='label-text'][contains(text(),'%s')]/../input";
    private String itemName = "", itemPrice = "";
    private static final By itemsLocator = By.xpath("//div[@class='item-wrapper']//div[@class='tile'][@data-index>=0]");
    private static final By findNameLocator = By.xpath("./div//p[@itemprop='name']/a");
    private static final By findPriceLocator = By.xpath("./div//span[@class='price-number']/span");
    private static final By findButtonLocator = By.xpath("./div[@class='tile-actions']//button[@type='submit']");
    private static final By inputFieldLocator = By.xpath("//div[@data-test-id='filter-block-price']//input[@data-test-id='range-filter-from-input']");
    private static final By cartLocator = By.xpath("//div[@data-test-id='header-cart']/a");
    private static By brandLocator = By.xpath("//div[@data-test-id='filter-block-brand']");
    private static By itemsWaitLocator = By.xpath("//div[@class='item-wrapper']");
    private static String categoryItemFoormat = "//div[@class='category-list']//a[contains(text(), '')]";

    public ChooseItemPage(WebDriver driver) {
        super(driver);
    }

    public By getItemsWaitLocator() {
        return itemsWaitLocator;
    }

    public By getBrandLocator() {
        return brandLocator;
    }

    public void chooseCategory(String category){
        getDriver().findElement(By.xpath(String.format(categoryItemFoormat, category))).click();
    }

    public void chooseBrand(String brand) {
        getDriver().findElement(By.xpath(String.format(brandFormat, brand))).click();
    }

    public void setStartPrice(String price) throws InterruptedException {
        WebElement inputField = getDriver().findElement(inputFieldLocator);
        for (int i = 0; i < 6; i++) {

            inputField.sendKeys(Keys.BACK_SPACE);
            Thread.sleep(300);
        }
        inputField.sendKeys(price);
        Thread.sleep(300);
        inputField.sendKeys(Keys.ENTER);
    }

    public void addFirstItemToCart(){
        List<WebElement> elements = getDriver().findElements(itemsLocator);
        WebElement firstElement = elements.get(elements.size()-1);
        scroll(firstElement);
        itemName = firstElement.findElement(findNameLocator).getText();
        itemPrice = firstElement.findElement(findPriceLocator).getText();
        firstElement.findElement(findButtonLocator).click();
    }

    public void goToCart(){
        getDriver().findElement(cartLocator).click();
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }
}
