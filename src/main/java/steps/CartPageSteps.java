package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;

public class CartPageSteps extends BaseSteps {
    CartPage cartPage;

    public CartPageSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
    }

    @Step("проверяем есть ли товар в корзине")
    public void checkItemInTheCart(String name, WebDriverWait wait){
        waitForVisibleElementLocated(wait, cartPage.getCartItemLocator());
        cartPage.checkItemInCart(name);
    }

    @Step("нажимаем удалить все")
    public void deleteAll(WebDriverWait wait) {
        waitForVisibleElementLocated(wait, cartPage.getCartPriceLocator());
        cartPage.deleteAll();
    }

    @Step("проверяем что корзина пуста")
    public void assertThatCartIsEmpty(WebDriverWait wait) {
        waitForVisibleElementLocated(wait, cartPage.getEmptyCartLocator());
        cartPage.assertThatCartIsEmpty();
    }
}
