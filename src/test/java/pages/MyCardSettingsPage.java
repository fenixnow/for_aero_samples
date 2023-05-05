package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import driver.EmulatorActions;

import static com.codeborne.selenide.Selenide.$;

public class MyCardSettingsPage extends MyCardMainPage {

    private static EmulatorActions emulatorActions = new EmulatorActions();
    private static MyCardMainPage myCardMainPage = new MyCardMainPage();
    private static CatalogPage catalogPage = new CatalogPage();
    private static ShopsPage shopsPage = new ShopsPage();
    private static ProfilePage profilePage = new ProfilePage();
    private static SupportPage supportPage = new SupportPage();

    private String changedName;

    private SelenideElement virtualCardPageTitle = $(MobileBy.xpath("//*[@text='Наша реальная дружба и виртуальная карта']"));
    private SelenideElement backButton = $(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]"));
    private SelenideElement settingsTitle = $(MobileBy.xpath("//*[@text='Настройки']"));
    private SelenideElement virtualCardButton = $(MobileBy.xpath("//*[@text='Сделать карту виртуальной']"));
    private SelenideElement noAskLPModeTitle = $(MobileBy.xpath("//*[@text='Не спрашивать про ЛП']"));
    private SelenideElement noAskLPSwitcher = $(MobileBy.id("ru.vkusvill:id/swDontAskLp"));
    private SelenideElement noAskLPDescription = $(MobileBy.xpath("//*[@text='Вас не спросят на кассе о любимом продукте, если данная функция включена']"));
    private SelenideElement autoWiFiModeTitle = $(MobileBy.xpath("//*[@text='Автоматическое подключение к WiFi']"));
    private SelenideElement autoWifiSwitcher = $(MobileBy.id("ru.vkusvill:id/swWifi"));
    private SelenideElement autoWiFiDescription = $(MobileBy.xpath("//*[@text='Если при запуске приложения мы заметим, что у вас нет связи с интернетом, мы подключим вас к бесплатной сети WiFi ВкусВилл']"));
    private SelenideElement shakePhoneModeTitle = $(MobileBy.xpath("//*[@text='Активировать \"Потрясти телефон\"']"));
    private SelenideElement shakePhoneSwitcher = $(MobileBy.id("ru.vkusvill:id/swShakeQr"));
    private SelenideElement shakePhoneDescription = $(MobileBy.xpath("//*[@text='При включении этого режима вы можете просто потрясти телефон, чтобы активировать считывание QR-кода на кассе']"));
    private SelenideElement orderSettingsButton = $(MobileBy.xpath("//*[@text='Настройки заказа']"));
    private SelenideElement orderSettingsDescription = $(MobileBy.xpath("//*[@text='Здесь вы можете настроить правила сборки и доставки заказа']"));
    private SelenideElement showOrderConditionsModeTitle = $(MobileBy.xpath("//*[@text='Показывать условия получения заказа']"));
    private SelenideElement showOrderConditionsSwitcher = $(MobileBy.id("ru.vkusvill:id/swServiceRules"));
    private SelenideElement showOrderConditionsDescription = $(MobileBy.xpath("//*[@text='Показывать подробные условия сборки и доставки для каждого заказа']"));
    private SelenideElement messageStatusButton = $(MobileBy.xpath("//*[@text='Статус общения']"));
    private SelenideElement messageStatusNoValue = $(MobileBy.xpath("//*[@text='не назначено']"));
    private SelenideElement changeNameButton = $(MobileBy.xpath("//*[@text='Изменить имя']"));
    private SelenideElement currentAccName = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/tvChangeNameDesc']"));
    private SelenideElement changeEmailButton = $(MobileBy.xpath("//*[@text='Изменить email']"));
    private SelenideElement currentEmail = $(MobileBy.xpath("//*[@text='mail@gmail.com']"));
    private SelenideElement getChecksEmailModeTitle = $(MobileBy.xpath("//*[@text='Получать чеки на email']"));
    private SelenideElement getChecksEmailSwitcher = $(MobileBy.id("ru.vkusvill:id/swCheck"));
    private SelenideElement checksDescription = $(MobileBy.xpath("//*[@text='Чеки будут приходить на указанную электронную почту']"));
    private SelenideElement poleButton = $(MobileBy.xpath("//*[@text='Пол']"));
    private SelenideElement currentPole = $(MobileBy.xpath("//*[@text='Мужской']"));
    private SelenideElement birthdayDateButton = $(MobileBy.xpath("//*[@text='Дата рождения']"));
    private SelenideElement currentBirthdayDate = $(MobileBy.xpath("//*[@text='01.01.1900']"));
    private SelenideElement cityButton = $(MobileBy.xpath("//*[@text='Город']"));
    private SelenideElement currentCity = $(MobileBy.xpath("//*[@text='Москва']"));
    private SelenideElement otherNetCards = $(MobileBy.xpath("//*[@text='Карты других сетей']"));
    private SelenideElement transferCardDataButton = $(MobileBy.xpath("//*[@text='Перенос данных по карте']"));
    private SelenideElement darkThemeModeTitle = $(MobileBy.xpath("//*[@text='Тёмная тема']"));
    private SelenideElement darkThemeSwitcher = $(MobileBy.id("ru.vkusvill:id/swTheme"));
    private SelenideElement logoutButton = $(MobileBy.xpath("//*[@text='Выйти из аккаунта']"));
    private SelenideElement logoutDescription = $(MobileBy.xpath("//*[@text='Вы сможете вернуться в любой момент по вашему номеру телефона']"));
    private SelenideElement deleteAcc = $(MobileBy.xpath("//*[@text='Удалить аккаунт']"));
    private SelenideElement deleteAccDescription = $(MobileBy.xpath("//*[@text='Карта лояльности будет аннулирована, данные удалены безвозвратно']"));
    private SelenideElement virtualCardModalWindowTitle = $(MobileBy.xpath("//*[@text='Виртуальная карта']"));
    private SelenideElement virtualCardModalWindowContent = $(MobileBy.id("ru.vkusvill:id/md_content"));
    private SelenideElement virtualCardModalMakeVirtualCardButton = $(MobileBy.xpath("//*[@text='СДЕЛАТЬ КАРТУ ВИРТУАЛЬНОЙ']"));
    private SelenideElement virtualCardModalCancelButton = $(MobileBy.xpath("//*[@text='ОТМЕНА']"));
    private SelenideElement virtualCardModalMoreDetailsButton = $(MobileBy.xpath("//*[@text='ПОДРОБНЕЕ']"));
    private SelenideElement confirmLogoutModalWindowTitle = $(MobileBy.xpath("//*[@text='Подтверждение']"));
    private SelenideElement yesButton = $(MobileBy.xpath("//*[@text='ДА']"));
    private SelenideElement cancelButton = $(MobileBy.xpath("//*[@text='ОТМЕНИТЬ']"));
    private SelenideElement cancelButton2 = $(MobileBy.xpath("//*[@text='ОТМЕНА']"));
    private SelenideElement changeNameWindowTitle = $(MobileBy.id("ru.vkusvill:id/md_title"));
    private SelenideElement changeNameCurrentInputName = $(MobileBy.id("android:id/input"));
    private SelenideElement saveButton = $(MobileBy.xpath("//*[@text='СОХРАНИТЬ']"));

    private SelenideElement[] myCardPageSettingsElements1 = {
            backButton,
            settingsTitle,
            virtualCardButton,
            noAskLPModeTitle,
            noAskLPSwitcher,
            noAskLPDescription,
            autoWiFiModeTitle,
            autoWifiSwitcher,
            autoWiFiDescription,
            shakePhoneModeTitle,
            shakePhoneSwitcher,
            shakePhoneDescription,
            orderSettingsButton,
            orderSettingsDescription,
            showOrderConditionsModeTitle,
            showOrderConditionsSwitcher,
            showOrderConditionsDescription,
            messageStatusButton,
    };

    private SelenideElement[] myCardPageSettingsElements2 = {
            changeNameButton,
            currentAccName,
            changeEmailButton,
            currentEmail,
            getChecksEmailModeTitle,
            getChecksEmailSwitcher,
            checksDescription,
            poleButton,
            currentPole,
            birthdayDateButton,
            currentBirthdayDate,
            cityButton,
            currentCity
    };

    private SelenideElement[] myCardPageSettingsElements3 = {
            otherNetCards,
            transferCardDataButton,
            darkThemeModeTitle,
            darkThemeSwitcher,
            logoutButton,
            logoutDescription,
            deleteAcc,
            deleteAccDescription
    };

    private SelenideElement[] virtualCardOptionModalWindowElements = {
            virtualCardModalWindowTitle,
            virtualCardModalWindowContent,
            virtualCardModalCancelButton,
            virtualCardModalMakeVirtualCardButton,
            virtualCardModalMoreDetailsButton
    };

    private SelenideElement[] confirmLogoutWindowElements = {
            confirmLogoutModalWindowTitle,
            yesButton,
            cancelButton
    };

    private SelenideElement[] changeNameWindowElements = {
            changeNameWindowTitle,
            changeNameCurrentInputName,
            cancelButton2,
            saveButton
    };

    @Step("Отображение элементов страницы \"Моя карта - Настройки\"")
    public MyCardSettingsPage myCardPageSettingsElementsDisplaying() {
        for (SelenideElement element : myCardPageSettingsElements1) {
            element.should(Condition.visible);
        }
        emulatorActions.verticalSwipeToFindElement(
            0.5, 0.3, 0.47,
            myCardPageSettingsElements2[12],
            50,
            "Cannot find the end of the article"
        );
        for (SelenideElement element: myCardPageSettingsElements2) {
            element.should(Condition.visible);
        }
        emulatorActions.verticalSwipeToFindElement(
            0.5, 0.3, 0.47,
            myCardPageSettingsElements3[7],
            50,
            "Cannot find the end of the article"
        );
        for (SelenideElement element : myCardPageSettingsElements3) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Отображение модального окна \"Виртуальная карта\" и его закрытие")
    public MyCardSettingsPage checkingVirtualCardModalWindowAndClose() {
        myCardPageSettingsElements1[2].should(Condition.visible).click();
        for (SelenideElement element : virtualCardOptionModalWindowElements) {
            element.should(Condition.visible);
        }
        virtualCardOptionModalWindowElements[2].click();
        return this;
    }

    @Step("Нажать кнопку \"Подробнее\" в модальном окне \"Виртуальная карта\"")
    public MyCardSettingsPage clickMoreDetailsInVirtualCardModal() {
        myCardPageSettingsElements1[2].should(Condition.visible).click();
        virtualCardOptionModalWindowElements[4].should(Condition.visible).click();
        virtualCardPageTitle.should(Condition.visible);
        return this;
    }

    @Step("Работа переключателя \"Не спрашивать про ЛП\"")
    public MyCardSettingsPage turnOnNoAskLPMode () {
        String noAskSwitcherValue = myCardPageSettingsElements1[4].getText();
        switch (noAskSwitcherValue) {
            case ("ON") :
                myCardPageSettingsElements1[4].should(Condition.visible).click();
                Assertions.assertEquals("OFF", myCardPageSettingsElements1[4].getText());
                break;
            case ("OFF") :
                myCardPageSettingsElements1[4].should(Condition.visible).click();
                Assertions.assertEquals("ON", myCardPageSettingsElements1[4].getText());
                break;
        }
        return this;
    }

    @Step("Работа переключателя \"Автоматическое подключение к WiFi\"")
    public MyCardSettingsPage turnOnAutoWiFiMode () {
        String autoWiFiSwitcherValue = myCardPageSettingsElements1[7].getText();
        switch (autoWiFiSwitcherValue) {
            case ("ON") :
                myCardPageSettingsElements1[7].should(Condition.visible).click();
                Assertions.assertEquals("OFF", myCardPageSettingsElements1[7].getText());
                break;
            case ("OFF") :
                myCardPageSettingsElements1[7].should(Condition.visible).click();
                Assertions.assertEquals("ON", myCardPageSettingsElements1[7].getText());
                break;
        }
        return this;
    }

    @Step("Пройтись по разделам приложения c темной темой")
    public MyCardSettingsPage checkPagesWithDarkTheme () {
        myCardMainPage.clickMyCardIconIfMainPageNotOpened();
        emulatorActions.horizontalSwipe
                (
                        0.9,
                        0.2,
                        0.1,
                        200
                );
        emulatorActions.verticalSwipe
                (
                        0.7,
                        0.5,
                        0.2,
                        200
                );
        catalogPage.catalogIconClick();
        emulatorActions.verticalSwipe
                (
                        0.5,
                        0.5,
                        0.2,
                        200
                );
        shopsPage.clickShopIcon();
        emulatorActions.verticalSwipe
                (
                        0.8,
                        0.5,
                        0.3,
                        200
                );
        profilePage.profileIconClick();
        emulatorActions.horizontalSwipe
                (
                        0.9,
                        0.15,
                        0.1,
                        200
                );
        emulatorActions.verticalSwipe
                (
                        0.9,
                        0.5,
                        0.3,
                        200
                );
        profilePage
                .profilePageChecksSubsectionClick()
                .profilePagePurchasesSubsectionClick()
                .profilePageB2BProfileSubsectionClick();
        supportPage.clickSupportIcon();
        emulatorActions.horizontalSwipe
                (
                        0.9,
                        0.5,
                        0.1,
                        200
                );
        emulatorActions.verticalSwipe
                (
                        0.9,
                        0.5,
                        0.1,
                        200
                );
        return this;
    }

    @Step("Работа переключателя \"Потрясти телефон\"")
    public MyCardSettingsPage turnOnShakePhoneMode () {
        String shakePhoneSwitcherValue = myCardPageSettingsElements1[10].getText();
        switch (shakePhoneSwitcherValue) {
            case ("ON") :
                myCardPageSettingsElements1[10].should(Condition.visible).click();
                Assertions.assertEquals("OFF", myCardPageSettingsElements1[10].getText());
                break;
            case ("OFF") :
                myCardPageSettingsElements1[10].should(Condition.visible).click();
                Assertions.assertEquals("ON", myCardPageSettingsElements1[10].getText());
                break;
        }
        return this;
    }

    @Step("Включить темную тему")
    public MyCardSettingsPage turnOnDarkThemeMode () {
        emulatorActions.verticalSwipeToFindElement(
            0.5, 0.3, 0.3,
            myCardPageSettingsElements3[4],
            20,
            "Cannot find the end of the article"
        );
        myCardPageSettingsElements3[3].should(Condition.visible).click();
        Assertions.assertEquals("ON", myCardPageSettingsElements3[3].getText());
        return this;
    }

    @Step("Выключить темную тему")
    public MyCardSettingsPage turnOffDarkThemeMode () {
        emulatorActions.verticalSwipeToFindElement(
            0.5, 0.3, 0.3,
            myCardPageSettingsElements3[4],
            20,
            "Cannot find the end of the article"
        );
        myCardPageSettingsElements3[3].should(Condition.visible).click();
        Assertions.assertEquals("OFF", myCardPageSettingsElements3[3].getText());
        return this;
    }

    @Step("Нажать \"выйти из аккаунта\"")
    public MyCardSettingsPage clickLogoutButton () {
        emulatorActions.verticalSwipeToFindElement(
            0.5, 0.3, 0.3,
            myCardPageSettingsElements3[4],
            10,
            "Cannot find the end of the article"
        );
        myCardPageSettingsElements3[4].click();
        return this;
    }

    @Step("Отображение модального окна подтверждения выхода из аккаунта")
    public MyCardSettingsPage confirmLogoutWindowDisplaying () {
        for (SelenideElement element : confirmLogoutWindowElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Кликнуть кнопку \"Да\"")
    public MyCardSettingsPage clickYesButton () {
        yesButton.click();
        return this;
    }

    @Step("Нажать кнопку \"Изменить имя\"")
    public MyCardSettingsPage clickChangeNameButton () {
        emulatorActions.verticalSwipeToFindElement(
            0.5, 0.5, 0.3,
            currentAccName,
            20,
            "Name not found"
        );
        changeNameButton.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение модального окна изменения имени")
    public MyCardSettingsPage changeNameWindowDisplaying() {
        for (SelenideElement element: changeNameWindowElements) {
            element.should(Condition.visible);
        }
        Assertions.assertEquals("Изменить имя", changeNameWindowTitle.getText());
        return this;
    }

    @Step("Ввести новое имя")
    public MyCardSettingsPage inputNewName(String newName) {
        changeNameCurrentInputName.click();
        emulatorActions.clearAllCharsInInputField(changeNameCurrentInputName);
        changeNameCurrentInputName.sendKeys(newName);
        return this;
    }

    @Step("Нажать Нажать \"Сохранить\"")
    public String clickSaveButton() {
        saveButton.click();
        changedName = currentAccName.getText();
        return changedName;
    }

    @Step("Проверяем новое имя в \"Моя карта\"")
    public MyCardSettingsPage checkChangedNameInMyCard() {
        myCardIconClick();
        Assertions.assertEquals(changedName, userName.getText());
        return this;
    }
}



