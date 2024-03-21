package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CityScreen extends Screen {
    @AndroidFindBy(accessibility = "Кнопка назад в меню")
    MobileElement backButton;

    public CityScreen(AppiumDriver<?> driver) {
        super(driver);
    }

    public void back() {
        backButton.click();
    }
}
