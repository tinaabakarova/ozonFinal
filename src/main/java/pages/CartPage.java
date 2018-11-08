package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{
   public static final String format = "//div[@class='eCartSplitItems']//span[contains(text(),'%s')]";
    public static final By cartItemLocator = By.xpath("//div[@class='eCartControls_info']");
    public static final By deleteAllbuttonLocator = By.xpath("//div[@class='eCartControls_buttons']");
    public static final By cartHeaderLocator = By.xpath("//div[@class='eCartPage_title']//span");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public By getCartItemLocator() {
        return cartItemLocator;
    }

    public void checkItemInCart(String name){
       List<WebElement> item = getDriver().findElements(By.xpath(String.format(format, name)));
       Assert.assertNotEquals("Элемент в корзине не найден", item.size(), 0);
       System.out.println("Элемент найден");
   }

    public By getDeleteAllbuttonLocator() {
        return deleteAllbuttonLocator;
    }

    public void deleteAll(){
        getDriver().findElement(deleteAllbuttonLocator).click();
    }

     public void assertThatCartIsEmpty(){
       Assert.assertEquals("Корзина пуста", getDriver().findElement(cartHeaderLocator).getText());
       System.out.println("Корзина пуста");
     }
}
