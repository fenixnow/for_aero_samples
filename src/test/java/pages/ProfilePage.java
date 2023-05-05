package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import driver.EmulatorActions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

//Страница "Профиль"
public class ProfilePage {

    EmulatorActions emulatorActions = new EmulatorActions();

//    private SelenideElement firstHistoryLabelOrderDeliveryDate = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout//*[@text='24 January']"));
//    private SelenideElement firstHistoryLabelOrderNumber = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout//*[@text='Заказ №135775917-1']"));

    /**
     * Элементы страницы "Профиль" до авторизации
     * */
    private SelenideElement profileButton = $(MobileBy.id("ru.vkusvill:id/bottom_item_history"));
    private SelenideElement clearHistoryButton = $(MobileBy.id("ru.vkusvill:id/btn_delete"));

    /**
     * Подразделы страницы "Профиль" после авторизации
     * */
    private SelenideElement profileHeader = $(MobileBy.xpath("//*[@text='Профиль']"));
    private SelenideElement checksSubsection = $(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"Чеки\"]/android.widget.TextView"));
    private SelenideElement myOrdersSubsection = $(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"Мои заказы\"]/android.widget.TextView"));
    private SelenideElement purchasesSubsection = $(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"Покупки\"]/android.widget.TextView"));
    private SelenideElement b2bProfileSubsection = $(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"B2B профиль\"]/android.widget.TextView"));
    private SelenideElement paymentMethodSubsection = $(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"Способы оплаты\"]/android.widget.TextView"));
    private SelenideElement myAddressesSubsection = $(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"Мои адреса\"]/android.widget.TextView"));
    private SelenideElement statisticsSubsection = $(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"Статистика\"]/android.widget.TextView"));

    /**
     * Элементы подраздела "Мои заказы" раздела "Профиль"
     * */
    private SelenideElement firstHistoryLabelOrderTitle = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout//*[@resource-id='ru.vkusvill:id/tv_service']"));
    private SelenideElement firstHistoryLabelOrderAddress = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout//*[@resource-id='ru.vkusvill:id/tv_address']"));
    private SelenideElement firstHistoryLabelOrderPrice = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout//*[@resource-id='ru.vkusvill:id/tv_price']"));
    private SelenideElement firstHistoryLabelOrderDate = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout//*[@resource-id='ru.vkusvill:id/tv_date']"));
    private SelenideElement firstHistoryLabelOrderStatus = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout//*[@resource-id='ru.vkusvill:id/tv_status']"));
    private SelenideElement firstHistoryLabelOrderPaymentStatus = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout//*[@resource-id='ru.vkusvill:id/tv_payment_status']"));
    private SelenideElement firstHistoryLabelOrderId = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout//*[@resource-id='ru.vkusvill:id/tv_id']"));
    private SelenideElement firstHistoryLabelOrderVVIcon = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout//*[@resource-id='ru.vkusvill:id/iv_type']"));
    private SelenideElement firstHistoryLabelOrderRepeatButton = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout//*[@resource-id='ru.vkusvill:id/button_repeat']//*[@resource-id='ru.vkusvill:id/tv_repeat']"));
    private SelenideElement firstHistoryLabelOrderSupportLink = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout//*[@resource-id='ru.vkusvill:id/tv_chat']"));

    /**
     * Элементы подраздела "Чеки" раздела "Профиль"
     * */
    private SelenideElement bindCheckButton = $(MobileBy.xpath("//*[@text='Привязать чек']"));
    private SelenideElement viewInfoButton = $(MobileBy.id("ru.vkusvill:id/imageView_info"));
    private SelenideElement chooseFinancePeriodButton = $(MobileBy.id("ru.vkusvill:id/imageView_finance"));
    private SelenideElement barChart = $(MobileBy.id("ru.vkusvill:id/barChart"));
    private SelenideElement legendSubtitle = $(MobileBy.xpath("//*[@text='Обозначения']"));
    private SelenideElement bonusesLabel = $(MobileBy.xpath("//*[@text='Бонусы']"));
    private SelenideElement checkLabel = $(MobileBy.xpath("//*[@text='Чек']"));
    private SelenideElement discountLabel = $(MobileBy.xpath("//*[@text='Скидка']"));
    private SelenideElement downloadMonthData = $(MobileBy.id("ru.vkusvill:id/button"));
    private SelenideElement monthOrdersSum = $(MobileBy.xpath("//*[@text='0₽']"));

    /**
     * Элементы подраздела "Покупки" раздела "Профиль"
     * */
    private SelenideElement shopsDownloadMonthData = $(MobileBy.id("ru.vkusvill:id/button"));
    private SelenideElement shopsMonthOrdersSum = $(MobileBy.xpath("//*[@text='0₽']"));

    /**
     * Элементы подраздела "B2B Профиль" раздела "Профиль"
     * */
    private SelenideElement likeEntityLabel = $(MobileBy.xpath("//android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]"));
    private SelenideElement likeEntityLabelDetailsButton = $(MobileBy.xpath("//android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]//*[@text='Детали']"));
    private SelenideElement likeEntityLabelTitle = $(MobileBy.xpath("//android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]//*[@text='Заказывать как\n" + "юридическое лицо']"));
    private SelenideElement likeEntityLabelDescription = $(MobileBy.xpath("//*[@text='Здесь вы можете покупать продукты\n" +
            "ВкусВилл на условиях, удобных\n" +
            "для юридических лиц и ИП']"));
    private SelenideElement continueButton = $(MobileBy.xpath("//*[@text='Продолжить']"));
    private SelenideElement supportButton = $(MobileBy.xpath("//*[@text='Поддержка']"));
    private SelenideElement becomeProviderLabel = $(MobileBy.xpath("//android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]"));
    private SelenideElement becomeProviderLabelTitle = $(MobileBy.xpath("//*[@text='Стать поставщиком']"));
    private SelenideElement becomeProviderLabelDescription = $(MobileBy.xpath("//*[@text='Здесь вы можете стать поставщиком\n" +
            "продуктов под маркой «ВкусВилл»']"));
    private SelenideElement becomeProviderDetailsButton = $(MobileBy.xpath("//android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]//*[@text='Детали']"));
    private SelenideElement becomeProviderFillForm = $(MobileBy.xpath("//*[@text='Заполнить анкету']"));

    /**
     * Элементы подраздела "Способы оплаты" раздела "Профиль"
     * */
    private SelenideElement byCardCourierLabel = $(MobileBy.xpath("//*[@text='Картой курьеру']"));
    private SelenideElement byCardCourierIcon = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.ImageView[1]"));
    private SelenideElement byCardCourierPrompt = $(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.ImageView[3]"));
    private SelenideElement payCashLabel = $(MobileBy.xpath("//*[@text='Наличными']"));
    private SelenideElement payCashIcon = $(MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.ImageView[1]"));
    private SelenideElement payCashPrompt = $(MobileBy.xpath("//android.widget.RelativeLayout[2]/android.widget.ImageView[3]"));
    private SelenideElement newSberPayCardLabel = $(MobileBy.xpath("//*[@text='Новая карта SberPay']"));
    private SelenideElement newSberPayCardIcon = $(MobileBy.xpath("//android.widget.RelativeLayout[3]/android.widget.ImageView[1]"));
    private SelenideElement newSberPayCardPrompt = $(MobileBy.xpath("//android.widget.RelativeLayout[3]/android.widget.ImageView[2]"));
    private SelenideElement changePayMethodButton = $(MobileBy.xpath("//*[@text='Изменить']"));
    private SelenideElement addCardButton = $(MobileBy.xpath("//*[@text='Добавить карту']"));

    /**
     * Элементы подраздела "Мои адреса" раздела "Профиль"
     * */
    private SelenideElement deliveryTab = $(MobileBy.xpath("//*[@text='Доставка']"));
    private SelenideElement pickUpTab = $(MobileBy.xpath("//*[@text='Самовывоз']"));
    private SelenideElement addShopIcon = $(MobileBy.id("ru.vkusvill:id/iv_add"));
    private SelenideElement addAddressButton = $(MobileBy.xpath("//*[@text='Добавить новый адрес']"));
    private SelenideElement addShopArrowIcon  = $(MobileBy.id("ru.vkusvill:id/iv_arrow"));

    /**
     * Элементы подраздела "Статистика" раздела "Профиль"
     * */
    private SelenideElement dataPeriodTitle = $(MobileBy.xpath("//*[@text='Период']"));
    private SelenideElement dataPeriodValue = $(MobileBy.id("ru.vkusvill:id/textView_period"));
    private SelenideElement viewListArrow = $(MobileBy.id("ru.vkusvill:id/imageView_period"));
    private SelenideElement viewPromptByPeriod = $(MobileBy.id("ru.vkusvill:id/imageView_info"));
    private SelenideElement statisticsChart = $(MobileBy.id("ru.vkusvill:id/pieChart"));
    private SelenideElement totalPurchases = $(MobileBy.xpath("//*[@text='Всего покупок:']"));
    private SelenideElement totalPurchasesSum = $(MobileBy.id("ru.vkusvill:id/textView_sum"));

    /**
     * Элементы подсказок по способам оплаты
     * */
    private SelenideElement promptItsClearButton = $(MobileBy.xpath("//*[@text='Понятно']"));
    private SelenideElement closePromptButton = $(MobileBy.id("ru.vkusvill:id/ivBottomSheetHide"));
    private SelenideElement byCardCourierPromptTitle = $(MobileBy.xpath("//*[@text='Оплата картой курьеру']"));
    private SelenideElement byCardCourierPromptContent = $(MobileBy.xpath("//*[@text='Выбрать оплату картой можно только в корзине, если этот способ доступен для вашего адреса.']"));
    private SelenideElement payCashPromptTitle = $(MobileBy.xpath("//*[@text='Оплата наличными']"));
    private SelenideElement payCashPromptContent = $(MobileBy.xpath("//*[@text='Выбрать оплату наличными можно только в корзине, если этот способ доступен для вашего адреса.']"));
    private SelenideElement sberPayCardWithoutAppPromptTitle = $(MobileBy.xpath("//*[@text='Способ оплаты недоступен']"));
    private SelenideElement sberPayCardWithoutAppPromptContent = $(MobileBy.xpath("//*[@text='Установите приложение СберБанк Онлайн для оплаты через SberPay']"));

    private SelenideElement[] profilePageBeforeAuthElements = {
            profileButton,
            clearHistoryButton
            };

    private SelenideElement[] profilePageAfterAuthSubsections1 = {
            profileHeader,
            myOrdersSubsection,
            checksSubsection,
            purchasesSubsection,
            b2bProfileSubsection
    };

    private SelenideElement[] profilePageAfterAuthSubsections2 = {
            paymentMethodSubsection,
            myAddressesSubsection,
            statisticsSubsection
    };

    private SelenideElement[] profilePageMyOrdersSubsectionElements = {
            firstHistoryLabelOrderAddress,
            firstHistoryLabelOrderPrice,
            firstHistoryLabelOrderPaymentStatus,
            firstHistoryLabelOrderDate,
            firstHistoryLabelOrderRepeatButton,
            firstHistoryLabelOrderStatus,
            firstHistoryLabelOrderId,
            firstHistoryLabelOrderTitle,
            firstHistoryLabelOrderSupportLink,
            firstHistoryLabelOrderVVIcon
    };

    private SelenideElement[] profilePageChecksSubsectionElements = {
            bindCheckButton,
            viewInfoButton,
            chooseFinancePeriodButton,
            barChart,
            legendSubtitle,
            bonusesLabel,
            checkLabel,
            discountLabel,
            downloadMonthData,
            monthOrdersSum
    };

    private SelenideElement[] profilePagePurchasesSubsectionElements = {
            shopsDownloadMonthData,
            shopsMonthOrdersSum
    };

    private SelenideElement[] profilePageB2BProfileSubsectionElements = {
            likeEntityLabel,
            likeEntityLabelDescription,
            likeEntityLabelDetailsButton,
            likeEntityLabelTitle,
            continueButton,
            supportButton,
            becomeProviderLabelTitle,
            becomeProviderLabel,
            becomeProviderDetailsButton,
            becomeProviderFillForm,
            becomeProviderLabelDescription
    };

    private SelenideElement[] profilePagePayMethodsSubsectionElements = {
            byCardCourierIcon,
            byCardCourierLabel,
            byCardCourierPrompt,
            payCashIcon,
            payCashLabel,
            payCashPrompt,
            changePayMethodButton,
            addCardButton,
            newSberPayCardIcon,
            newSberPayCardLabel,
            newSberPayCardPrompt
    };

    private SelenideElement[] profilePageMyAddressesSubsectionElements = {
            deliveryTab,
            pickUpTab,
            addShopIcon,
            addAddressButton,
            addShopArrowIcon
    };

    private SelenideElement[] profilePageStatisticsSubsectionElements = {
            dataPeriodTitle,
            dataPeriodValue,
            viewListArrow,
            viewPromptByPeriod,
            statisticsChart,
            totalPurchases,
            totalPurchasesSum
    };

    private SelenideElement[] byCardCourierPromptElements = {
            byCardCourierPromptTitle,
            byCardCourierPromptContent,
            closePromptButton,
            promptItsClearButton
    };

    private SelenideElement[] payCashPromptElements = {
            payCashPromptTitle,
            payCashPromptContent,
            closePromptButton,
            promptItsClearButton
    };

    private SelenideElement[] sberPayPromptWithoutAppElements = {
            sberPayCardWithoutAppPromptTitle,
            sberPayCardWithoutAppPromptContent,
            closePromptButton,
            promptItsClearButton
    };

    /**
     * Элементы страницы о заказе
     */
    private SelenideElement orderCancelButton = $(By.id("ru.vkusvill:id/button_cancel"));
    private SelenideElement orderConfirmCancelButton = $x("//*[@resource-id='ru.vkusvill:id/design_bottom_sheet']//*[@resource-id='ru.vkusvill:id/button']");
    private SelenideElement canceledOrderTitle = $x("//*[contains(@text, 'Заказ отменён')]");

    @Step("Отображение иконки \"Профиль\"")
    public ProfilePage profileIconDisplaying() {
        profilePageBeforeAuthElements[0].should(Condition.visible);
        return this;
    }

    @Step("Кликнуть иконку \"Профиль\"")
    public ProfilePage profileIconClick() {
        profilePageBeforeAuthElements[0].should(Condition.visible).click();
        return this;
    }

    @Step("Отображение элементов страницы \"Профиль\" до авторизации по телефону")
    public ProfilePage profilePageElementsDisplayingWithoutAuth() {
        profilePageBeforeAuthElements[1].should(Condition.visible);
        return this;
    }

    @Step("Отображение подразделов раздела \"Профиль\" после авторизации")
    public ProfilePage profilePageSubsectionsDisplayingAfterAuth() {
        for (SelenideElement element : profilePageAfterAuthSubsections1) {
            element.should(Condition.visible);
        }
        emulatorActions.horizontalSwipeToFindElement(
            0.5, 0.15, 0.4,
            profilePageAfterAuthSubsections2[2],
            20,
            "Subsection not found"
        );
        for (SelenideElement element : profilePageAfterAuthSubsections2) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Отображение элементов подраздела \"Мои заказы\" раздела \"Профиль\"")
    public ProfilePage profilePageMyOrdersSubsectionElementsDisplaying() {
        Assertions.assertEquals("true", profilePageAfterAuthSubsections1[1].getAttribute("selected"));
        for (SelenideElement element: profilePageMyOrdersSubsectionElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Кликнуть на подраздел \"Чеки\"")
    public ProfilePage profilePageChecksSubsectionClick() {
        profilePageAfterAuthSubsections1[2].should(Condition.visible).click();
        return this;
    }

    @Step("Отображение элементов подраздела \"Чеки\" раздела \"Профиль\"")
    public ProfilePage profilePageChecksSubsectionElementsDisplaying() {
        Assertions.assertEquals("true", profilePageAfterAuthSubsections1[2].getAttribute("selected"));
        for (SelenideElement element: profilePageChecksSubsectionElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Кликнуть на подраздел \"Покупки\"")
    public ProfilePage profilePagePurchasesSubsectionClick() {
        profilePageAfterAuthSubsections1[3].should(Condition.visible).click();
        return this;
    }

    @Step("Отображение элементов подраздела \"Покупки\" раздела \"Профиль\"")
    public ProfilePage profilePagePurchasesSubsectionElementsDisplaying() {
        Assertions.assertEquals("true", profilePageAfterAuthSubsections1[3].getAttribute("selected"));
        for (SelenideElement element: profilePagePurchasesSubsectionElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Кликнуть на подраздел \"B2B профиль\"")
    public ProfilePage profilePageB2BProfileSubsectionClick() {
        profilePageAfterAuthSubsections1[4].should(Condition.visible).click();
        return this;
    }

    @Step("Отображение элементов подраздела \"B2B профиль\" раздела \"Профиль\"")
    public ProfilePage profilePageB2BProfileSubsectionElementsDisplaying() {
        Assertions.assertEquals("true", profilePageAfterAuthSubsections1[4].getAttribute("selected"));
        for (SelenideElement element: profilePageB2BProfileSubsectionElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Отображение элементов подраздела \"Способы оплаты\" раздела \"Профиль\"")
    public ProfilePage profilePagePayMethodsSubsectionsElementsDisplaying() {
        emulatorActions.horizontalSwipeToFindElement(
            0.5, 0.15, 0.4,
            profilePageAfterAuthSubsections2[2],
            20,
            "Subsection not found"
        );
        profilePageAfterAuthSubsections2[0].should(Condition.visible).click();
        Assertions.assertEquals("true", profilePageAfterAuthSubsections2[0].getAttribute("selected"));
        for (SelenideElement element: profilePagePayMethodsSubsectionElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Отображение элементов подраздела \"Мои адреса\" раздела \"Профиль\"")
    public ProfilePage profilePageMyAddressesSubsectionsElementsDisplaying() {
        emulatorActions.horizontalSwipeToFindElement(
            0.5, 0.15, 0.4,
            profilePageAfterAuthSubsections2[2],
            20,
            "Subsection not found"
        );
        profilePageAfterAuthSubsections2[1].should(Condition.visible).click();
        Assertions.assertEquals("true", profilePageAfterAuthSubsections2[1].getAttribute("selected"));
        for (SelenideElement element: profilePageMyAddressesSubsectionElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Отображение элементов подраздела \"Мои адреса\" раздела \"Профиль\"")
    public ProfilePage profilePageStatisticsSubsectionsElementsDisplaying() {
        emulatorActions.horizontalSwipeToFindElement(
            0.5, 0.15, 0.4,
            profilePageAfterAuthSubsections2[2],
            20,
            "Subsection not found"
        );
        profilePageAfterAuthSubsections2[2].should(Condition.visible).click();
        Assertions.assertEquals("true", profilePageAfterAuthSubsections2[2].getAttribute("selected"));
        for (SelenideElement element: profilePageStatisticsSubsectionElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Открыть подраздел \"Способы оплаты\" раздела \"Профиль\"")
    public ProfilePage openPayMethodsSubsection() {
        emulatorActions.horizontalSwipeToFindElement(
            0.5, 0.15, 0.4,
            profilePageAfterAuthSubsections2[2],
            20,
            "Subsection not found"
        );
        profilePageAfterAuthSubsections2[0].should(Condition.visible).click();
        return this;
    }

    @Step("Кликнуть на подсказку \"Картой курьеру\"")
    public ProfilePage clickByCardCourierPrompt() {
        profilePagePayMethodsSubsectionElements[2].should(Condition.visible).click();
        return this;
    }

    @Step("Отображение элементов подсказки \"Картой курьеру\"")
    public ProfilePage byCardCourierPromptDisplaying() {
        for (SelenideElement element : byCardCourierPromptElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Подсказка \"Картой курьеру\" не отображается")
    public ProfilePage byCardCourierPromptNotDisplaying() {
        for (SelenideElement element : byCardCourierPromptElements) {
            element.should(Condition.not(Condition.visible));
        }
        return this;
    }

    @Step("Нажать кнопку \"Понятно\"")
    public ProfilePage clickItsClearButton() {
        byCardCourierPromptElements[3].should(Condition.visible).click();
        return this;
    }

    @Step("Нажать кнопку \"Закрыть\"")
    public ProfilePage clickCloseButton() {
        byCardCourierPromptElements[2].should(Condition.visible).click();
        return this;
    }

    @Step("Тапнуть мимо подсказки")
    public ProfilePage clickBesidePrompt() {
        emulatorActions
                .tapByAspectRatio
                        (
                                0.5,
                                0.5,
                                200
                        );
        for (SelenideElement element : byCardCourierPromptElements) {
            element.should(Condition.not(Condition.visible));
        }
        return this;
    }

    @Step("Кликнуть на подсказку \"Наличными\"")
    public ProfilePage clickPayCashPrompt() {
        profilePagePayMethodsSubsectionElements[5].should(Condition.visible).click();
        return this;
    }

    @Step("Отображение элементов подсказки \"Наличными\"")
    public ProfilePage payCashPromptDisplaying() {
        for (SelenideElement element : payCashPromptElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Подсказка \"Наличными\" не отображается")
    public ProfilePage payCashPromptNotDisplaying() {
        for (SelenideElement element : payCashPromptElements) {
            element.should(Condition.not(Condition.visible));
        }
        return this;
    }

    @Step("Кликнуть на подсказку \"Новая карта SberPay\"")
    public ProfilePage clickSberPayPrompt() {
        profilePagePayMethodsSubsectionElements[10].should(Condition.visible).click();
        return this;
    }

    @Step("Отображение элементов подсказки \"Новая карта SberPay\"")
    public ProfilePage sberPayPromptDisplaying() {
        for (SelenideElement element : sberPayPromptWithoutAppElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Подсказка \"Новая карта SberPay\" не отображается")
    public ProfilePage sberPayPromptNotDisplaying() {
        for (SelenideElement element : sberPayPromptWithoutAppElements) {
            element.should(Condition.not(Condition.visible));
        }
        return this;
    }

    @Step("Открыть первый заказ")
    public ProfilePage clickOpenFirstOrder() {
        firstHistoryLabelOrderId.should(Condition.visible).click();
        return this;
    }

    @Step("Нажать кнопку \"Отменить заказ\"")
    public ProfilePage clickCancelOrder() {
        orderCancelButton.should(Condition.visible).click();
        return this;
    }

    @Step("Подтвердить отмену заказа")
    public ProfilePage clickConfirmCancelOrder() {
        orderConfirmCancelButton.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение отмененного заказа")
    public ProfilePage canceledOrderDisplaying() {
        canceledOrderTitle.should(Condition.visible);
        return this;
    }



}