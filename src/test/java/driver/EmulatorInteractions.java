package driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofMillis;

/*
https://www.linkedin.com/pulse/guide-perform-appium-20-w3c-mobile-actions-swipe-%EA%9C%B1%E1%B4%80%C9%B4%E1%B4%8B%E1%B4%87%E1%B4%9B-%E1%B4%8A%E1%B4%8F%EA%9C%B1%CA%9C%C9%AA
 */
public class EmulatorInteractions {

    private static final PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    public static void scroll(AppiumDriver driver, int startX, int startY, int endX, int endY, int pauseMillis) {
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), startX, startY));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(pauseMillis)));
        sequence.addAction(finger.createPointerMove(ofMillis(200), PointerInput.Origin.viewport(), endX, endY));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(sequence));
    }

    public static void tap(AppiumDriver driver, int x, int y, int pauseMillis) {
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(pauseMillis)));
        driver.perform(List.of(sequence));
    }

    public static void swipeOnElement(AppiumDriver driver, WebElement element, SwipeDirection direction, int pauseMillis) {
        int startX, startY, endX, endY;
        switch (direction) {
            case RIGHT:
                startX = element.getRect().x + (element.getSize().width / 4);
                startY = element.getRect().y + (element.getSize().height / 2);
                endX = element.getRect().x + (element.getSize().width * 3 / 4);
                endY = element.getRect().y + (element.getSize().height / 2);
                break;
            case LEFT:
                startX = element.getRect().x + (element.getSize().width * 3 / 4);
                startY = element.getRect().y + (element.getSize().height / 2);
                endX = element.getRect().x + (element.getSize().width / 4);
                endY = element.getRect().y + (element.getSize().height / 2);
                break;
            case DOWN:
                startX = element.getRect().x + (element.getSize().width / 2);
                startY = element.getRect().y + (element.getSize().height / 4);
                endX = element.getRect().x + (element.getSize().width / 2);
                endY = element.getRect().y + (element.getSize().height * 3 / 4);
                break;
            case UP:
                startX = element.getRect().x + (element.getSize().width / 2);
                startY = element.getRect().y + (element.getSize().height * 3 / 4);
                endX = element.getRect().x + (element.getSize().width / 2);
                endY = element.getRect().y + (element.getSize().height / 4);
                break;
            default:
                throw new IllegalStateException();
        }
        scroll(driver, startX, startY, endX, endY, pauseMillis);
    }

    public enum SwipeDirection { RIGHT, LEFT, DOWN, UP }

}
