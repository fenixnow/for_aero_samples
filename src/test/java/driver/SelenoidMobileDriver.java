package driver;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import config.ConfigReader;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SelenoidMobileDriver implements WebDriverProvider {

    private static final String URL = ConfigReader.emulatorConfig.remoteURL();
    public static final String APK_URL = ConfigReader.emulatorConfig.app_android();
    public static final String VERSION = ConfigReader.emulatorConfig.platformVersion();
    private static final String PLATFORM_NAME = ConfigReader.emulatorConfig.platformName();
    public static final Boolean ENABLE_VIDEO = ConfigReader.emulatorConfig.enableVideo();
    private static final String BRANCH_NAME = ConfigReader.emulatorConfig.branchName();

    public static URL getSelenoidUrl() {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    @CheckReturnValue
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("android");
        options.setCapability("autoGrantPermissions",true);
        options.setPlatformName(PLATFORM_NAME);
        options.setPlatformVersion(VERSION);
        options.setApp(APK_URL);
        options.setAppActivity("ru.vkusvill.ui.screens.splash.SplashActivity");
        options.setAppPackage("ru.vkusvill");
        options.setLanguage("ru");
        options.setLocale("ru");
        options.setCapability("pageLoadStrategy", "normal");

        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", ENABLE_VIDEO);
//        selenoidOptions.put("enableLog", true);
        selenoidOptions.put("timeZone", "Europe/Moscow");

        options.setCapability("selenoid:options", selenoidOptions);

        AndroidDriver driver = new AndroidDriver(getSelenoidUrl(), options);
        EmulatorActions.driver = driver;

        return driver;
    }

}
