package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ChooseItemPage;

public class ChooseItemPageSteps extends BaseSteps {
    ChooseItemPage chooseItemPage;

    public ChooseItemPageSteps(WebDriver driver) {
        chooseItemPage = new ChooseItemPage(driver);
    }

    public String getPrice() {
        return chooseItemPage.getItemPrice();
    }

    public String getName() {
        return chooseItemPage.getItemName();
    }

    public void chooseCategory(String name, WebDriverWait wait) throws InterruptedException {
        chooseItemPage.chooseCategory(name);
        Thread.sleep(1000);
        waitForVisibleElementLocated(wait, chooseItemPage.getItemsWaitLocator());
    }

    @Step("выбирает производителя")
    public void chooseBrand(String name, WebDriverWait wait) throws InterruptedException {
        waitForVisibleElementLocated(wait, chooseItemPage.getBrandLocator());
        chooseItemPage.chooseBrand(name);
        Thread.sleep(1000);
        waitForVisibleElementLocated(wait, chooseItemPage.getItemsWaitLocator());
    }

    @Step("вводит цену ")
    public void setPrice(String price, WebDriverWait wait) throws InterruptedException {
        chooseItemPage.setStartPrice(price);
        Thread.sleep(1000);
        waitToBeClicable(wait, chooseItemPage.getItemsWaitLocator());
    }

    @Step("добавляет первый товар в корзину, запоминая название и цену")
    public void addFirstItemToCart() {
        chooseItemPage.addFirstItemToCart();
    }

    @Step("переходит в корзину")
    public void goToCart(){
        chooseItemPage.goToCart();
    }
}
