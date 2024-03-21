package homework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;

public class DriverFactory<IOSdriver> {
    AppiumDriver<?> driver;
    public AppiumDriver<?> setUp(org.openqa.selenium.Platform platform) throws MalformedURLException {
        return switch (platform) {
            case ANDROID -> createAndroidDriver();// создаем методы
            case IOS -> createIosDriver();
            default -> throw new IllegalArgumentException("No such platform");
        };
    }

    private IOSDriver<?> createIosDriver() {

        return null;
    }

    private AndroidDriver<?> createAndroidDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android" );
        desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
        desiredCapabilities.setCapability(APP_PACKAGE, "ru.filit.mvideo.b2c");
        desiredCapabilities.setCapability(APP_ACTIVITY, "ui.splash.view.SplashScreen");
        desiredCapabilities.setCapability(NO_SIGN, true);
        URL remouteUrl = new URL("http://localhost:4723");//не забыть добавить исключения
        driver = new AndroidDriver<>(remouteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new EventListener());

        return (AndroidDriver<?>) driver;
    }


}

