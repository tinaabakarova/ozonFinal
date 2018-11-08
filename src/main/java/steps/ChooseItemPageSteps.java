package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ChooseItemPage;

public class ChooseItemPageSteps extends BaseSteps {
    ChooseItemPage chooseItemPage;

    String name = "", price = "";

    public ChooseItemPageSteps(WebDriver driver) {
        chooseItemPage = new ChooseItemPage(driver);
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void chooseCategory(String name) throws InterruptedException {
        chooseItemPage.chooseCategory(name);
        Thread.sleep(4000);
    }

    @Step("выбирает производителя")
    public void chooseBrand(String name, WebDriverWait wait) throws InterruptedException {
        waitForVisibleElementLocated(wait, chooseItemPage.getBrandLocator());
        chooseItemPage.chooseBrand(name);
        Thread.sleep(4000);
    }

    @Step("вводит цену ")
    public void setPrice(String price) throws InterruptedException {
        chooseItemPage.setStartPrice(price);
        //Thread.sleep(4000);
    }

    @Step("добавляет первый товар в корзину, запоминая название и цену")
    public void addFirstItemToCart(WebDriverWait wait) throws InterruptedException {
        waitToBeClicable(wait, chooseItemPage.getItemsWaitLocator());
        chooseItemPage.addFirstItemToCart();
        name = chooseItemPage.getItemName();
        price = chooseItemPage.getItemPrice();
        Thread.sleep(4000);
    }

    @Step("переходит в корзину")
    public void goToCart(){
        chooseItemPage.goToCart();
    }
}
