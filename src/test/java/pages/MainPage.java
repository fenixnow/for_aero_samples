package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

//Страница входа
public class MainPage {

    private SelenideElement buttonEnter = $(MobileBy.id("ru.vkusvill:id/btn_enter"));
    private SelenideElement appUpdateWindowTitle = $(MobileBy.xpath("//*[@text='Обновите сервисы Google Play']"));
    private SelenideElement appUpdateWindowContent = $(MobileBy.xpath("//*[@text='Чтобы запустить приложение \"ВкусВилл\", обновите сервисы Google Play.']"));
    private SelenideElement appUpdateButton = $(MobileBy.xpath("//*[@text='UPDATE']"));

    private SelenideElement buttonLogin = $(MobileBy.xpath("//*[@text='Войти по номеру телефона']"));
    private SelenideElement editPhoneNumber = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/editText']"));
    private SelenideElement buttonSendPhone = $(MobileBy.xpath("//*[@text='Продолжить']"));
    private SelenideElement editSmsCode = $(MobileBy.xpath("(//*[@resource-id='ru.vkusvill:id/editText'])[last()]"));
    private SelenideElement buttonSendCode = $(MobileBy.xpath("//*[@text='Подтвердить']"));
    private SelenideElement bottomNav = $(MobileBy.id("ru.vkusvill:id/ll_bottom_nav"));

    private SelenideElement[] appUpdateWindowElements = {
            appUpdateWindowTitle,
            appUpdateWindowContent,
            appUpdateButton
    };


    @Step("Нажимаем на кнопку \"НАЧАТЬ\" на стартовом экране")
    public MainPage login() {
        buttonEnter.should(Condition.visible).click();
        return this;
    }

    @Step("Быстрый вход в аккаунт(без проверки полей)")
    //Нет необходимости в каждом тесте проверять наличие всех полей
    //достаточно только в AuthorizationTests
    public MainPage fastLogin(String phone, String code) {
        buttonEnter.should(Condition.visible).click();
        buttonLogin.should(Condition.visible).click();
        editPhoneNumber.should(Condition.visible).sendKeys(phone);
        buttonSendPhone.click();
        buttonSendCode.should(Condition.visible);
        editSmsCode.sendKeys(code);
        bottomNav.should(Condition.visible);
        return this;
    }

    //шаг для сокрытия окна обновления
    @Step("Проверяем окно обновления приложения и скрываем его")
    public MainPage updateAppWindowCheck() {
        if (appUpdateWindowContent.is(Condition.visible)) {
            for (SelenideElement element : appUpdateWindowElements) {
                element.should(Condition.visible);
            }
        }
        return this;
    }
}
