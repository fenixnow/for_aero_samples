package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.qameta.allure.Step;
import org.openqa.selenium.Rectangle;
import driver.EmulatorActions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

//Моя карта
public class CreatingCardPage {

    EmulatorActions emulatorActions = new EmulatorActions();

    protected SelenideElement myCardButton = $(AppiumBy.id("ru.vkusvill:id/bottom_item_profile"));
    protected SelenideElement startButton = $(AppiumBy.id("ru.vkusvill:id/btn"));
    protected SelenideElement turnOnProfitTitle = $(AppiumBy.xpath("//*[@text='Персональные скидки от ВкусВилла']"));
    protected SelenideElement turnOnProfitDescription = $(AppiumBy.xpath("//*[@text='Нажмите 1 кнопку в приложении и получите скидку 20% на 6 разных товаров. Новые скидки доступны каждый день.']"));
    protected SelenideElement enterTitle = $(AppiumBy.xpath("//*[@text='Введите номер телефона']"));
    protected SelenideElement inputFieldNumber = $(AppiumBy.id("ru.vkusvill:id/editText"));
    protected SelenideElement inputFiledNumberMask =$(AppiumBy.xpath("//*[@text='+7 (999) 999-99-99']"));
    protected SelenideElement continueButton = $(AppiumBy.xpath("//*[@text='Продолжить']"));
    protected SelenideElement userConfirmText = $(AppiumBy.xpath("//*[@text='Соглашаюсь получать новости\n" + "и специальные предложения']"));
    protected SelenideElement confirmToggle = $(AppiumBy.id("ru.vkusvill:id/cb_news"));
    protected SelenideElement agreementText =  $(AppiumBy.xpath("//*[@text='Нажимая кнопку «Продолжить», соглашаюсь\n" + "с офертой и политикой конфиденциальности.']"));
    protected SelenideElement virtualCardCreatingTitle = $(AppiumBy.xpath("//*[@text='Виртуальная карта']"));
    protected SelenideElement virtualCardCreatingContent = $(AppiumBy.xpath("//*[@text='Мы не нашли карту лояльности, привязанную к вашему номеру.\n" +
            "\n" +
            "Создайте виртуальную карту и участвуйте в программе лояльности ВкусВилл.']"));
    protected SelenideElement virtualCardCloseButton = $(AppiumBy.xpath("//*[@text='ЗАКРЫТЬ']"));
    protected SelenideElement virtualCardCreateButton = $(AppiumBy.xpath("//*[@text='СОЗДАТЬ']"));
    protected SelenideElement virtualCardInputNamePlaceholder = $(AppiumBy.xpath("//*[@text='Ваше имя']"));
    protected SelenideElement inputSmsCodeFormTitle = $(AppiumBy.xpath("//*[@text='Введите код\n" +
            "из смс']"));
    protected SelenideElement inputSmsCodeFormPlaceholder = $(AppiumBy.xpath("//*[@resource-id='ru.vkusvill:id/editText']"));
    protected SelenideElement smsCodeFormConfirmButton = $(AppiumBy.xpath("//*[@text='Подтвердить']"));
    protected SelenideElement smsCodeFormTimer = $(AppiumBy.id("ru.vkusvill:id/textView_retry"));
    protected SelenideElement smsCodeFormSuggestion = $(AppiumBy.xpath("//*[@text='Проблемы со входом? Будем рады помочь в чате.']"));
    protected SelenideElement smsCodeNewCodeButton = $(AppiumBy.xpath("//*[@text='Отправить код ещё раз']"));
    protected SelenideElement incorrectCodeWindowTitle = $(AppiumBy.xpath("//*[@text='Введён неверный код']"));
    protected SelenideElement toManyTriesInputCodeWindowMessage = $(AppiumBy.xpath("//*[@text='Слишком много неудачных попыток ввода кода для активации. Запросите новую СМС.']"));
    protected SelenideElement inputPhoneErrorMessage = $(AppiumBy.xpath("//*[@text='Введите номер телефона']"));
    protected SelenideElement formatPhoneErrorMessage = $(AppiumBy.xpath("//*[@text='Номер телефона должен состоять из 10 цифр']"));
    protected SelenideElement inputPhoneTitle = $(AppiumBy.xpath("//*[@text='Ошибка']"));
    protected SelenideElement publicTenderHeader = $(AppiumBy.xpath("//*[@text='Публичная оферта']"));
    protected SelenideElement shareButton = $(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Поделиться\"]"));
    protected SelenideElement backButton = $(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]"));
    protected SelenideElement privatePolicyHeader = $(AppiumBy.xpath("//*[@text='Политика конфиденциальности персональных данных']"));
    protected SelenideElement agreementElement = $(AppiumBy.id("ru.vkusvill:id/tv_agreement"));

    protected SelenideElement[] myCardPageAuthorizationFormElements = {
            enterTitle,
            inputFieldNumber,
            inputFiledNumberMask,
            userConfirmText,
            continueButton,
            confirmToggle,
            agreementText
    };

    protected SelenideElement[] startCardCreatePageWithProfitThemeElements = {
            startButton,
            turnOnProfitTitle,
            turnOnProfitDescription
    };

    protected SelenideElement[] creatingNewCardWindowElements = {
            virtualCardCreatingTitle,
            virtualCardCreatingContent,
            virtualCardCloseButton,
            virtualCardCreateButton
    };

    protected SelenideElement[] confirmSmsCodeCreatingCardElements = {
            inputSmsCodeFormTitle,
            inputSmsCodeFormPlaceholder,
            smsCodeFormConfirmButton,
            smsCodeFormTimer,
            smsCodeFormSuggestion,
    };

    protected SelenideElement[] inputPhoneErrorElements = {
            inputPhoneErrorMessage,
            inputPhoneTitle,
            virtualCardCloseButton
    };

    protected SelenideElement[] formatPhoneErrorWindowElements = {
            formatPhoneErrorMessage,
            inputPhoneTitle,
            virtualCardCloseButton
    };

    protected SelenideElement[] publicTenderPageElements = {
            publicTenderHeader,
            shareButton,
            backButton
    };

    protected SelenideElement[] privatePolicyPageElements = {
            privatePolicyHeader,
            shareButton,
            backButton
    };

    @Step("Отображение иконки \"Моя карта\"")
    public CreatingCardPage myCardIconDisplaying() {
        myCardButton.should(Condition.visible);
        return this;
    }

    @Step("Нажать на иконку\"Моя карта\"")
    public CreatingCardPage myCardIconClick() {
        myCardButton.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение элементов страницы старта создания карты")
    public CreatingCardPage startCardPageElementsDisplayingWithOnProfitTheme() {
        for (SelenideElement element : startCardCreatePageWithProfitThemeElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Отображение элементов страницы оформления карты")
    public CreatingCardPage createCardPageElementsDisplaying() {
        startCardCreatePageWithProfitThemeElements[0].click();
        for (SelenideElement element : myCardPageAuthorizationFormElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Открываем форму ввода номера")
    public CreatingCardPage openInputNumberForm() {
        myCardButton.click();
        startCardCreatePageWithProfitThemeElements[0].should(Condition.visible).click();
        for (SelenideElement element : myCardPageAuthorizationFormElements) {
            element.should(Condition.visible);
        }
        return this;
    }
    @Step("Вводим незарегистрированный номер телефона")
    public CreatingCardPage enterUnregisteredNumber(String unregisteredNumber) {
        myCardPageAuthorizationFormElements[1].sendKeys(unregisteredNumber);
        return this;
    }

    @Step("Вводим зарегистрированный номер")
    public CreatingCardPage enterRegisteredNumber(String registeredNumber) {
        myCardPageAuthorizationFormElements[1].sendKeys(registeredNumber);
        return this;
    }

    @Step("Нажимаем кнопку \"Продолжить\"")
    public CreatingCardPage clickContinueButton() {
        myCardPageAuthorizationFormElements[4].click();
        return this;
    }
    @Step("Нажимаем кнопку \"СОЗДАТЬ\" в открывшемся модальном окне \"Виртуальная карта\"")
    public CreatingCardPage clickCreateButton() {
            for (SelenideElement element : creatingNewCardWindowElements) {
        element.should(Condition.visible);
    }
        creatingNewCardWindowElements[3].click();
        return this;
    }

    @Step("Вводим имя в модальном окне ввода имени с полем \"Введите имя\" и нажимаем кнопку \"СОЗДАТЬ\"")
    public CreatingCardPage enterNameInVirtualCardWindow() {
        creatingNewCardWindowElements[0].should(Condition.visible);
        creatingNewCardWindowElements[2].should(Condition.visible);
        creatingNewCardWindowElements[3].should(Condition.visible);
        virtualCardInputNamePlaceholder.should(Condition.visible).click();
        virtualCardInputNamePlaceholder.sendKeys("Тестовое");
        creatingNewCardWindowElements[3].click();
        return this;
    }

    @Step("Отображение элементов формы ввода смс-кода")
    public CreatingCardPage inputSmsCodeFormElementsDisplaying() {
        for (SelenideElement element: confirmSmsCodeCreatingCardElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Ввести некорректный смс-код")
    public CreatingCardPage inputIncorrectSmsCode() {
        confirmSmsCodeCreatingCardElements[1].click();

        emulatorActions.enterAndroidKeys(new AndroidKey[]
                {
                        AndroidKey.DIGIT_5,
                        AndroidKey.DIGIT_5,
                        AndroidKey.DIGIT_5,
                        AndroidKey.DIGIT_5,
                        AndroidKey.DIGIT_5,
                        AndroidKey.DIGIT_5,
                }
        );
        emulatorActions.hideKeyBd();

        return this;
    }

    @Step("Нажать \"Закрыть\"")
    public CreatingCardPage clickCloseButton() {
        creatingNewCardWindowElements[2].click();
        return this;
    }

    @Step("Нажать \"Подтвердить\"")
    public CreatingCardPage clickConfirmButton() {
        confirmSmsCodeCreatingCardElements[2].should(Condition.visible).click();
        return this;
    }

    @Step("Отображение окна с сообщением о вводе некорректного кода")
    public CreatingCardPage incorrectCodeWindowDisplaying() {
        incorrectCodeWindowTitle.should(Condition.visible);
        return this;
    }

    @Step("Отображение окна с сообщением о множестве попыток ввода некорректного кода")
    public CreatingCardPage toManyTriesInputCodeWindowDisplaying() {
        while (!(toManyTriesInputCodeWindowMessage.is(Condition.visible))) {
            incorrectCodeWindowDisplaying();
            clickCloseButton();
            clickConfirmButton();
            if(toManyTriesInputCodeWindowMessage.is(Condition.visible)) {
                break;
            }
        }
        creatingNewCardWindowElements[2].should(Condition.visible);
        return this;
    }

    @Step("В форме ввода смс-кода вводим корректный код")
    public CreatingCardPage enterCorrectCodeInSmsCodeForm() {
        for (SelenideElement element: confirmSmsCodeCreatingCardElements) {
            element.should(Condition.visible);
        }
        emulatorActions.enterAndroidKeys(new AndroidKey[]
                {
                        AndroidKey.DIGIT_1,
                        AndroidKey.DIGIT_0,
                        AndroidKey.DIGIT_0,
                        AndroidKey.DIGIT_5,
                        AndroidKey.DIGIT_0,
                        AndroidKey.DIGIT_0
                }
        );
        emulatorActions.hideKeyBd();
        return this;
    }

    @Step("Ждем истечения таймера кода и жмем кнопку \"Отправить код ещё раз\"")
    public CreatingCardPage waitTimerAndClickNewCodeButton() {
        smsCodeNewCodeButton.should(Condition.visible, Duration.ofSeconds(65));
        smsCodeNewCodeButton.click();
        return this;
    }

    @Step("Отображение окна ошибки с сообщением \"Введите номер телефона\"")
    public CreatingCardPage inputPhoneErrorWindowDisplaying() {
        for (SelenideElement element: inputPhoneErrorElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Отображение окна ошибки с сообщением \"Номер телефона должен состоять из 10 цифр\"")
    public CreatingCardPage formatPhoneErrorWindowDisplaying() {
        for (SelenideElement element: formatPhoneErrorWindowElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Кликнуть на ссылку \"политикой конфиденциальности\"")
    public CreatingCardPage clickPrivatePolicyLink() {
        Rectangle rect = agreementElement.getRect();
        emulatorActions.tapByCoordinates
                (
                        rect.x + 500,
                        rect.y + rect.height - 16,
                        200
                );
        return this;
    }

    @Step("Кликнуть на ссылку \"офертой\"")
    public CreatingCardPage clickTenderLink() {
        Rectangle rect = agreementElement.getRect();
        emulatorActions.tapByCoordinates
                (
                        rect.x + 100,
                        rect.y + rect.height - 16,
                        200
                );
        return this;
    }

    @Step("Отображение элементов страницы публичной оферты")
    public CreatingCardPage publicTenderPageDisplaying() {
        for (SelenideElement element: publicTenderPageElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Отображение элементов страницы политики конфиденциальности")
    public CreatingCardPage privatePolicyPageDisplaying() {
        for (SelenideElement element: privatePolicyPageElements) {
            element.should(Condition.visible);
        }
        return this;
    }
}
