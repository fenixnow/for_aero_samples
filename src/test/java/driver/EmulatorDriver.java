package driver;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import config.ConfigReader;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class EmulatorDriver implements WebDriverProvider {

    private static final String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static final String PLATFORM_NAME = ConfigReader.emulatorConfig.platformName();
    private static final String PLATFORM_VERSION = ConfigReader.emulatorConfig.platformVersion();
    private static String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static String APP_ACTIVITY = ConfigReader.emulatorConfig.appActivity();
    public static final String APP_IOS = ConfigReader.emulatorConfig.app_ios();
    public static final String APP_ANDROID = ConfigReader.emulatorConfig.app_android();
    private static final String URL = ConfigReader.emulatorConfig.remoteURL();
    private static final String NEW_COMMAND_TIMEOUT = ConfigReader.emulatorConfig.newCommandTimeout();

    /**
     * Валидация URL ссылки из пропертей
     */
    public static java.net.URL getUrl() {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private URL appUrl() {
        try {
            if (PLATFORM_NAME.equals("Android")) {
                return new URL(APP_ANDROID);
            } else if (PLATFORM_NAME.equals("IOS")) {
                return new URL(APP_IOS);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
}
        return null;
    }


    @Nonnull
    @Override
    @CheckReturnValue
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        if (PLATFORM_NAME.equals("Android")) {
            UiAutomator2Options options = new UiAutomator2Options();

            options.merge(capabilities);

            options.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
            options.setCapability("deviceName", DEVICE_NAME);
            options.setCapability("platformName", PLATFORM_NAME);
            options.setCapability("appPackage", APP_PACKAGE);
            options.setCapability("appActivity", APP_ACTIVITY);
//        options.disableWindowAnimation();
            options.setNewCommandTimeout(Duration.parse(NEW_COMMAND_TIMEOUT));

            options.setApp(appUrl());
//        options.setCapability("app", "/root/tmp/bb.apk");

            AndroidDriver driver = new AndroidDriver(getUrl(), options);
            EmulatorActions.driver = driver;
            return driver;

        } else if (PLATFORM_NAME.equals("IOS")) {

            XCUITestOptions options = new XCUITestOptions();
            options.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
            options.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
            options.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
            options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            options.setNewCommandTimeout(Duration.parse(NEW_COMMAND_TIMEOUT));
            options.setApp(appUrl());

            IOSDriver driver = new IOSDriver(getUrl(), options);
            EmulatorActions.driver = driver;
            return driver;
        }

        throw new UnsupportedOperationException("Unsupported PLATFORM_NAME");
    }
}
