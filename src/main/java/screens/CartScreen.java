package screens;

import homework.GoToMainFromCart;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartScreen extends Tabbar {
    @AndroidFindBy(id = "cart_emty_check_this_out_button")
    MobileElement goToMainButton;

    public CartScreen(AppiumDriver<?> driver) {
        super(driver);
    }

    public void goToMainScreen() {
        goToMainButton.click();
    }

    public void goToMainScreenByStrategy(GoToMainFromCart goToMainScreenByStrategy) {
        goToMainScreenByStrategy.goToMain();
    }
}
