package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Tabbar extends Screen{
    @AndroidFindBy(accessibility = "Списки")
    MobileElement listIcon;

    @AndroidFindBy(accessibility = "Профиль")
    MobileElement profileIcon;

    @AndroidFindBy(accessibility = "Корзина")
    MobileElement cartIcon;

    @AndroidFindBy(accessibility = "Главная")
    MobileElement mainIcon;

    public Tabbar(AppiumDriver<?> driver) {
        super();
    }

    public void goToList() {

        listIcon.click();
    }

    public void goToProfile() {
        profileIcon.click();
    }

    public void goToCart() {

        cartIcon.click();
    }

    public void goToMain(){

        mainIcon.click();
    }
}
