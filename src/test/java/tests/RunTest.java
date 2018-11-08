package tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.bg.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.TestProps;
import steps.CartPageSteps;
import steps.CategoriesStepPage;
import steps.ChooseItemPageSteps;
import steps.MainPageSteps;

import java.util.concurrent.TimeUnit;

public class RunTest {
    WebDriver driver;
    WebDriverWait wait;
    ChromeOptions options;
    private MainPageSteps mainPageSteps;
    private CategoriesStepPage categoriesStepPage;
    private ChooseItemPageSteps chooseItemPageSteps;
    private CartPageSteps cartPageSteps;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 20);
        mainPageSteps = new MainPageSteps(driver);
        categoriesStepPage = new CategoriesStepPage(driver);
        chooseItemPageSteps = new ChooseItemPageSteps(driver);
        cartPageSteps = new CartPageSteps(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        driver.get((String) TestProps.getInstance().getProperties().get("base.url"));
    }

    @After
    public void endTest(){
        driver.quit();
    }

    @Когда("^пользователь выбирает меню \"(.*)\"$")
    public void chooseCategory(String name){
        mainPageSteps.chooseCategoryByName(name, wait);
    }

    @И("^выбирает меню \"(.*)\"$")
    public void chooseSecondCategory(String name){
        categoriesStepPage.chooseCategoryByName(name, wait);
    }

    @И ("^выбирает категорию \"(.*)\"$")
    public void chooseCameraCategory(String name) throws InterruptedException {
        chooseItemPageSteps.chooseCategory(name);
    }

    @И("^выбирает производителя \"(.*)\"$")
    public void chooseBrand(String name) throws InterruptedException {
        chooseItemPageSteps.chooseBrand(name, wait);
    }

    @И("^вводит цену \"(.*)\"$")
    public void setPrice(String price) throws InterruptedException {
        chooseItemPageSteps.setPrice(price);
    }

    @И("^добавляет первый товар в корзину, запоминая название и цену$")
    public void addFirstItemToCart() throws InterruptedException {
        chooseItemPageSteps.addFirstItemToCart();
    }

    @И("^переходит в корзину$")
    public void goToCart(){
        chooseItemPageSteps.goToCart();
    }

    @Тогда("^проверяем есть ли товар в корзине$")
    public void checkItems(){
        cartPageSteps.checkItemInTheCart(chooseItemPageSteps.getName(), wait);
    }

    @Тогда("^нажимаем удалить все$")
    public void deleteAll() throws InterruptedException {
        cartPageSteps.deleteAll(wait);
    }

    @Тогда("^проверяем что корзина пуста$")
    public void checkIfCartisEmpty() throws InterruptedException {
        cartPageSteps.assertThatCartIsEmpty();
    }
}
