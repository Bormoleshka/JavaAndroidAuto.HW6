import homework.DriverFactory;
import homework.GoToMainFromCart;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.support.PageFactory;
import screens.*;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeWork6Test {
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class HomeWork6 {

        private  final DriverFactory driverFactory = new DriverFactory();
        private  AppiumDriver<?> driver;



        @BeforeAll
        public void setDriver() throws MalformedURLException {
            driver = driverFactory.setUp(Platform.ANDROID);
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }

        @Test
        public void homeTest() {
            MainScreen mainScreen = new MainScreen(driver);
            mainScreen.getLogotypeIcon().isDisplayed();
            Tabbar tabbar = new Tabbar(driver);
            tabbar.goToList();
            ListsScreen listScreen = new ListsScreen(driver);
            listScreen.showCatalog();
            CatalogScreen catalogScreen = new CatalogScreen(driver);
            catalogScreen.openSmartphonesAndGadgets();
            catalogScreen.getSamsungTitle().isDisplayed();
            tabbar.goToProfile();
            ProfileScreen profileScreen = new ProfileScreen(driver);
            profileScreen.chooseCity();
            CityScreen cityScreen = new CityScreen(driver);
            cityScreen.back();
            tabbar.goToCart();
            CartScreen cartScreen = new CartScreen(driver);
            cartScreen.goToMainScreenByStrategy(new GoToMainFromCart(driver));


            assertEquals("Я в магазине", mainScreen.getStoreMainTitleText());
        }

        @AfterAll
        public  void tearDown(){
            driver.quit();
        }

    }
}

