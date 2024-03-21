package homework;

import io.appium.java_client.AppiumDriver;
import screens.CartScreen;

public class GoToMainFromCart implements GoToMainScreenStrategy {
    AppiumDriver<?> driver;
    public GoToMainFromCart(AppiumDriver<?> driver) {
        this.driver = driver;
    }

    @Override
    public void goToMain(){
        CartScreen cartScreen  = new CartScreen(driver);
        cartScreen.goToMainScreen();
    }
}
