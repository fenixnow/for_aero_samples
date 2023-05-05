package driver;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.html5.LocationContext;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

public class EmulatorActions {

    protected static AppiumDriver driver;

    final int PRESS_TIME = 200; // ms

    public void hideKeyBd() {
        if (!(driver instanceof HidesKeyboard)) {
            throw new UnsupportedOperationException();
        }
        ((HidesKeyboard) driver).hideKeyboard();
    }

    public void enterAndroidKeys(AndroidKey[] androidKeys) {
        if (!(driver instanceof PressesKey)) {
            throw new UnsupportedOperationException();
        }
        for (AndroidKey key: androidKeys) {
            ((PressesKey)driver).pressKey(new KeyEvent(key));
        }
    }

    public void clearAllCharsInInputField (SelenideElement element) {
        if (!(driver instanceof PressesKey)) {
            throw new UnsupportedOperationException();
        }
        String currentNameValue = element.getText();
        int length = currentNameValue.length();
        for (int i = length; i > 0; i--) {
            ((PressesKey)driver).pressKey(new KeyEvent(AndroidKey.DEL));
        }
    }

    public WebElement waitForElementPresent(By by, String errorMessage, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void verticalSwipe(
        double startPercentage, double anchorPercentage, double endPercentage, int timeOutMills
    ) {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * anchorPercentage);
        int start_y = (int) (size.height * startPercentage);
        int end_y = (int) (size.height * endPercentage);

        EmulatorInteractions.scroll(driver, x, start_y, x, end_y, timeOutMills);
    }

    public void horizontalSwipe(
        double startPercentage,
        double anchorPercentage,
        double endPercentage,
        int timeOutMills
    ) {
        Dimension size = driver.manage().window().getSize();
        int y = (int) (size.height * anchorPercentage);
        int start_x = (int) (size.width * startPercentage);
        int end_x = (int) (size.width * endPercentage);

        EmulatorInteractions.scroll(driver, start_x, y, end_x, y, timeOutMills);
    }

    public void horizontalSwipeOnElement(SelenideElement element, int deltaX, int timeOutMills) {
        int startX = element.getLocation().x;
        int y = element.getLocation().y;

        EmulatorInteractions.scroll(driver, startX, y, startX + deltaX, y, timeOutMills);
    }

    public void horizontalSwipeToFindElement(
        double startPercentage, double anchorPercentage, double endPercentage,
        SelenideElement element,
        int maxSwipes
    ) {
        horizontalSwipeToFindElement(startPercentage, anchorPercentage, endPercentage, element, maxSwipes, null);
    }

    public void horizontalSwipeToFindElement(
        double startPercentage, double anchorPercentage, double endPercentage,
        SelenideElement element,
        int maxSwipes,
        String errorText
    ) {
        for (var i = 0; i < maxSwipes; i++) {
            if (element.is(Condition.visible)) return;
            horizontalSwipe(startPercentage, anchorPercentage, endPercentage, PRESS_TIME);
        }

        var condition = Condition.visible;
        if (errorText != null) condition = condition.because(errorText);
        element.should(condition);
    }

    public void verticalSwipeToFindElement(
        double startPercentage, double anchorPercentage, double endPercentage,
        SelenideElement element,
        int maxSwipes
    ) {
        verticalSwipeToFindElement(startPercentage, anchorPercentage, endPercentage, element, maxSwipes, null);
    }

    public void verticalSwipeToFindElement(
        double startPercentage, double anchorPercentage, double endPercentage,
        SelenideElement element,
        int maxSwipes,
        String errorText
    ) {
        for (var i = 0; i < maxSwipes; i++) {
            if (element.is(Condition.visible)) return;
            verticalSwipe(startPercentage, anchorPercentage, endPercentage, PRESS_TIME);
        }
        var condition = Condition.visible;
        if (errorText != null) condition = condition.because(errorText);
        element.should(condition);
    }

    public void tapByAspectRatio(double vertPercentage, double horPercentage, int timeOutMills) {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * horPercentage);
        int y = (int) (size.height * vertPercentage);
        tapByCoordinates(x, y, timeOutMills);
    }

    public void tapByCoordinates(int x, int y, int timeOutMills) {
        EmulatorInteractions.tap(driver, x, y, timeOutMills);
    }

    public void copiedValueCheck(String copiedElementText) {
        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor dataFlavor = DataFlavor.stringFlavor;
        Object clipboardText = null;
        try {
            clipboardText = systemClipboard.getData(dataFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (systemClipboard.isDataFlavorAvailable(dataFlavor)) {
                System.out.println();
            Assertions.assertEquals(copiedElementText, clipboardText);
        }
    }

    public void setLocation(double latitude, double longitude) {
        if (!(driver instanceof LocationContext)) {
            throw new UnsupportedOperationException();
        }
        ((LocationContext) driver).setLocation(new Location(latitude, longitude, 0));
    }

    public void horizontalSwipeElement(
        double startPercentage, double endPercentage, SelenideElement element
    ) {
        Rectangle position = element.getRect();
        Dimension size = element.getSize();
        int y = position.getY() + (int) (size.height * 0.5);
        int start_x = position.getX() + (int) (size.width * startPercentage);
        int end_x = position.getX() + (int) (size.width * endPercentage);
        EmulatorInteractions.scroll(driver, start_x, y, end_x, y, PRESS_TIME);
    }

    public void verticalSwipeElement(
        double startPercentage, double endPercentage, SelenideElement element
    ) {
        Rectangle position = element.getRect();
        Dimension size = element.getSize();
        int x = position.getX() + size.width / 2;
        int start_y = position.getY() + (int) (size.height * startPercentage);
        int end_y = position.getY() + (int) (size.height * endPercentage);
        EmulatorInteractions.scroll(driver, x, start_y, x, end_y, PRESS_TIME);
    }

}
