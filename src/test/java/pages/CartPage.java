package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import driver.EmulatorActions;

import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    EmulatorActions emulatorActions = new EmulatorActions();

    private final SelenideElement cartContainer = $(AppiumBy.xpath(".//*[@resource-id='ru.vkusvill:id/slidable_panel']"));
    private final SelenideElement cartTitle = cartContainer.$x(".//*[@text='Корзина']");
    private final SelenideElement closeCartButton = cartContainer.$(By.id("ru.vkusvill:id/iv_close"));
    private SelenideElement serviceTitle = cartContainer.$x(".//*[@resource-id='ru.vkusvill:id/ll_services1']//*[@resource-id='ru.vkusvill:id/tv_service_title']");
    private SelenideElement editDeliveryTimeButton = cartContainer.$(By.id("ru.vkusvill:id/iv_service_slot"));
    private SelenideElement itemsQuantity = cartContainer.$(By.id("ru.vkusvill:id/tv_tov"));
    private SelenideElement quantityReduceButton = cartContainer.$x(".//*[@resource-id='ru.vkusvill:id/rl_cart_content']/*[1]");
    private SelenideElement quantityIncreaseButton = cartContainer.$(By.id("ru.vkusvill:id/iv_cart_plus"));
    private SelenideElement deleteAllButton = cartContainer.$x(".//*[@text='Удалить все']");
    private SelenideElement confirmClearingCartButton = $(By.id("ru.vkusvill:id/md_buttonDefaultPositive"));
    private SelenideElement cancelClearingCartButton = $(By.id("ru.vkusvill:id/md_buttonDefaultNegative"));
    private SelenideElement deleteAllIcon = cartContainer.$(By.id("ru.vkusvill:id/iv_delete"));
    private SelenideElement orderComments = cartContainer.$x(".//*[@text='Комментарий к заказу']");
    private SelenideElement toTheCollector = cartContainer.$x(".//*[@class='android.widget.LinearLayout']//*[@text='Сборщику']");
    private SelenideElement suggestionCollector = cartContainer.$x(".//*[@text='Напишите, что важно учесть при сборке']");
    private SelenideElement descriptionCollector = cartContainer.$x(".//*[@text='Любые детали, которые важны при выборе товаров']");
    private SelenideElement toTheCourier = cartContainer.$x(".//*[@class='android.widget.LinearLayout']//*[@text='Курьеру']");
    private SelenideElement suggestionCourier = cartContainer.$x(".//*[@text='Напишите, что важно учесть при доставке']");
    private SelenideElement descriptionCourier = cartContainer.$x(".//*[@text='Например, дополнительный номер телефона, если заказ получаете не вы']");
    private SelenideElement deliverySettingsLabel = cartContainer.$(By.id("ru.vkusvill:id/rl_settings"));
    private SelenideElement deliverySettingsTitle = cartContainer.$(By.id("ru.vkusvill:id/tv_settings_title"));
    private SelenideElement deliverySettingsDescription = cartContainer.$(By.id("ru.vkusvill:id/tv_settings_desc"));
    private SelenideElement deliverySettingsEnterIcon = cartContainer.$x(".//*[@resource-id='ru.vkusvill:id/rl_settings']//*[@class='android.widget.ImageView']");
    private SelenideElement greenPrice = cartContainer.$(By.id("ru.vkusvill:id/rl_green_price_bg"));
    private SelenideElement promoCodeLabel = cartContainer.$(By.id("ru.vkusvill:id/root"));
    private SelenideElement promoCodeTitle = cartContainer.$(By.id("ru.vkusvill:id/tv_title"));
    private SelenideElement promoCodeInputFieldPlaceholder = $x(".//*[@text='Введите промокод']");
    private SelenideElement promoCodeApplyButton = cartContainer.$x(".//*[@text='Применить']");
    private SelenideElement recommendationsHeader = cartContainer.$(By.id("ru.vkusvill:id/tv_recommendations"));
    private SelenideElement orderWeight = cartContainer.$x(".//*[@text='Вес заказа']");
    private SelenideElement deliveryPrice = cartContainer.$x(".//*[@text='Доставка']");
    private SelenideElement totalOrderSum = cartContainer.$x(".//*[@text='Общая сумма заказа']");
    private SelenideElement orderWeightValue = cartContainer.$(By.id("ru.vkusvill:id/tv_field_weight"));
    private SelenideElement deliveryPriceValue = cartContainer.$(By.id("ru.vkusvill:id/tv_field_delivery"));
    private SelenideElement totalOrderSumValue = cartContainer.$(By.id("ru.vkusvill:id/tv_field_sum"));
    private SelenideElement payMethodsHeader = cartContainer.$x(".//*[@text='Способ оплаты']");
    private SelenideElement payMethodsDescription = cartContainer.$x(".//*[@text='Выберите способ оплаты']");
    private SelenideElement paymentChooseIcon = cartContainer.$(By.id("ru.vkusvill:id/iv_payment_choose"));
    private SelenideElement deliveryAddressLabel = cartContainer.$x(".//*[@resource-id='ru.vkusvill:id/ll_address']");
    private SelenideElement deliveryAddressEditButton = cartContainer.$x(".//*[@resource-id='ru.vkusvill:id/ll_address']//*[@resource-id='ru.vkusvill:id/iv_address_edit']");
    private SelenideElement deliveryAddressTitle = cartContainer.$x(".//*[@resource-id='ru.vkusvill:id/ll_address']//*[@text='Адрес доставки']");
    private SelenideElement deliveryAddressValue = cartContainer.$x(".//*[@resource-id='ru.vkusvill:id/ll_address']//*[@resource-id='ru.vkusvill:id/tv_shop']");
    private SelenideElement clarifyAddressDetailsButton = cartContainer.$x(".//*[@resource-id='ru.vkusvill:id/ll_address']//*[@text='Уточните детали адреса']");
    private SelenideElement orderButton = cartContainer.$(By.id("ru.vkusvill:id/button"));
    private SelenideElement deleteButton = cartContainer.$x(".//*[@text='Удалить']");

    private SelenideElement firstItemInCart = cartContainer.$x(".//*[@resource-id='ru.vkusvill:id/smContentView']//*[@resource-id='ru.vkusvill:id/tv_title']");
    private SelenideElement deleteAllItems = cartContainer.$x(".//*[@resource-id='ru.vkusvill:id/ll_delete']//*[@text='Удалить все']");
    private SelenideElement positiveButton = cartContainer.$x(".//*[@resource-id='ru.vkusvill:id/md_buttonDefaultPositive']");
    private SelenideElement cartItemCountEmpty = cartContainer.$x(".//*[@text='0 товаров']");

    private ElementsCollection productItems = cartContainer.$$x(".//*[@resource-id='ru.vkusvill:id/ll_widgets']//*[@resource-id='ru.vkusvill:id/rv']/*");

    private SelenideElement[] headerElements = {
            cartTitle,
            closeCartButton
    };

    private SelenideElement closeButton = $(By.id("ru.vkusvill:id/iv_close"));

    /**
     * Время доставки
     */
    private SelenideElement deliveryDate = $(By.id("ru.vkusvill:id/wvDay"));
    private SelenideElement deliverySaveDateButton = $x("//*[@resource-id='ru.vkusvill:id/design_bottom_sheet']//*[@resource-id='ru.vkusvill:id/button']");
    private SelenideElement deliveryTimeTitle = cartContainer.$(By.id("ru.vkusvill:id/tv_service_title"));
    
    private SelenideElement[] cartPageDefaultElements1 = {
            serviceTitle,
            editDeliveryTimeButton,
            //itemsQuantity,
            //quantityReduceButton,
            //quantityIncreaseButton,
            deleteAllButton,
            deleteAllIcon,
            orderComments,
            toTheCollector,
            suggestionCollector,
            descriptionCollector,
            toTheCourier,
            deliverySettingsLabel,
            deliverySettingsTitle,
            deliverySettingsDescription,
            deliverySettingsEnterIcon
    };

    private SelenideElement[] cartPageDefaultElements2 = {
            promoCodeLabel,
            promoCodeTitle,
            promoCodeInputFieldPlaceholder,
            promoCodeApplyButton,
            recommendationsHeader,
            greenPrice,
            deliveryPrice,
            totalOrderSum,
            totalOrderSumValue,
            deliveryPriceValue,
            payMethodsHeader,
            payMethodsDescription,
            paymentChooseIcon,
            deliveryAddressLabel,
            deliveryAddressTitle,
            deliveryAddressValue,
            deliveryAddressEditButton,
            orderButton
    };

    private SelenideElement settingsButton = $(By.id("ru.vkusvill:id/tv_settings_title"));

    /**
     * Настройки заказа
     */
    private SelenideElement settingsTitle = $x("//*[@text='Настройки заказа']");
    private SelenideElement settingsSectionTitle = $x("//*[@text='Что делать, если товара нет в наличии']");
    private SelenideElement settingsCallButton = $x("//*[@text='Позвонить и согласовать замену']");
    private SelenideElement settingsDontCallButton = $x("//*[@text='Не звонить. Убрать товар из заказа']");
    private SelenideElement settingsUseLessText = $x("//*[@text='Использовать меньше фасовочных пакетов']");
    private SelenideElement settingsUseLessButton = $x("(//*[@resource-id='ru.vkusvill:id/sw'])[1]");
    private SelenideElement settingsLeftDoorText = $x("//*[@text='Оставить заказ у двери']");
    private SelenideElement settingsLeftDoorButton = $x("(//*[@resource-id='ru.vkusvill:id/sw'])[2]");
    private SelenideElement settingsDoorCallText = $x("//*[@text='Позвонить и сообщить, что заказ у двери']");
    private SelenideElement settingsDoorCallButton = $x("(//*[@resource-id='ru.vkusvill:id/sw'])[3]");

    /**
     * Комментарий к заказу
     */
    private SelenideElement commentCollectorTitle = $(By.id("ru.vkusvill:id/tv_comment_collector"));
    private SelenideElement commentCollectorDescription = $(By.id("ru.vkusvill:id/et_comment_collector"));
    private SelenideElement commentCourierTitle = $(By.id("ru.vkusvill:id/tv_comment_delivery"));
    private SelenideElement commentCourierDescription = $(By.id("ru.vkusvill:id/et_comment_delivery"));

    /**
     * Меню
     */
    private SelenideElement menuMyCard = $(By.id("ru.vkusvill:id/bottom_item_profile"));
    private SelenideElement menuCatalog = $(By.id("ru.vkusvill:id/bottom_item_catalog"));
    private SelenideElement menuShop = $(By.id("ru.vkusvill:id/bottom_item_shops"));
    private SelenideElement menuProfile = $(By.id("ru.vkusvill:id/bottom_item_history"));
    private SelenideElement menuSupport = $(By.id("ru.vkusvill:id/bottom_item_support"));

    private SelenideElement cartWidget = $(By.id("ru.vkusvill:id/cartWidget"));

    /**
     * Промокод
     */
    private SelenideElement promocode = $(By.id("ru.vkusvill:id/input"));
    private SelenideElement promocodeInput = promocode.$x(".//android.widget.EditText");
    private SelenideElement promocodeButton = promocode.$x(".//android.widget.Button");
    private SelenideElement promocodeMessage = promocode.$x(".//android.widget.TextView");

    /**
     * Способы оплаты
     */
    private SelenideElement paymentTypeButton = $(By.id("ru.vkusvill:id/ll_payment"));
    private SelenideElement selectedPaymentTypeImage = paymentTypeButton.$(By.id("ru.vkusvill:id/iv_payment"));
    private SelenideElement selectedPaymentTypeText = paymentTypeButton.$(By.id("ru.vkusvill:id/tv_payment"));
    private SelenideElement selectedPaymentTypeEdit = paymentTypeButton.$(By.id("ru.vkusvill:id/tv_payment_edit"));
    private SelenideElement paymentTypesTitle = $x("//*[@text='Способы оплаты']");
    private SelenideElement paymentTypesItemsContainer = $x("//*[@resource-id='ru.vkusvill:id/design_bottom_sheet']//*[@resource-id='ru.vkusvill:id/recyclerView']");
    private SelenideElement paymentCard = paymentTypesItemsContainer.$x(".//*[@text='Картой курьеру']");
    private SelenideElement paymentCash = paymentTypesItemsContainer.$x(".//*[@text='Наличными']");
    private SelenideElement paymentAddCard = paymentTypesItemsContainer.$x(".//*[@text='Добавить карту']");
    private SelenideElement paymentAddCardDescription = paymentTypesItemsContainer.$x(".//*[@text='Все операции проходят на стороне банка. Для привязки мы спишем 1 руб. и тут же вернём его.']");
    private SelenideElement paymentSberPay = paymentTypesItemsContainer.$x(".//*[@text='Новая карта SberPay']");

    /**
     * Выбор адреса
     */
    private ElementsCollection addressItems = $$x("//*[@resource-id='ru.vkusvill:id/design_bottom_sheet']//*[@resource-id='ru.vkusvill:id/sml']");
    private SelenideElement pickAddressButton = $x("//*[@resource-id='ru.vkusvill:id/design_bottom_sheet']//*[@resource-id='ru.vkusvill:id/button']");
    private SelenideElement addressAddButton = $x("//*[@resource-id='ru.vkusvill:id/design_bottom_sheet']//*[@resource-id='ru.vkusvill:id/tv_add']");

    /**
     * Уточнить адрес доставки
     */
    private SelenideElement specifyAddressFlat = $(By.id("ru.vkusvill:id/il_address_flat"));
    private SelenideElement specifyAddressButton = $x("//*[@resource-id='ru.vkusvill:id/button' and @text='Продолжить']");

    /**
     * Заказ оформлен
     */
    private SelenideElement toOrdersButton = $(By.id("ru.vkusvill:id/button_orders"));

    @Step("Отображение страницы корзины")
    public CartPage cartPageDisplaying() {

        Assertions.assertTrue(cartContainer.exists(), "slidable_panel не существует");

        for (SelenideElement element : cartPageDefaultElements1) {
            element.should(Condition.visible);
        }
        toTheCourier.should(Condition.visible).click();
        suggestionCourier.should(Condition.visible).click();
        descriptionCourier.should(Condition.visible).click();
        toTheCollector.should(Condition.visible).click();

        for (SelenideElement element2 : cartPageDefaultElements2) {
            emulatorActions.verticalSwipeToFindElement
                    (
                            0.5,
                            0.01,
                            0.4,
                            element2,
                            100
                    );
        }

        return this;
    }

    @Step("Отсутствие страницы корзины")
    public CartPage cartPageNotDisplaying() {
        for (SelenideElement element : cartPageDefaultElements1) {
            element.should(Condition.disappear);
        }
        return this;
    }

    @Step("Нажать кнопку \"Удалить всё\"")
    public CartPage clickDeleteAllButton() {
        deleteAllButton.should(Condition.visible).click();
        return this;
    }

    @Step("Нажать кнопку \"-\"")
    public CartPage clickReduceButton() {
        quantityReduceButton.should(Condition.visible).click();
        return this;
    }

    @Step("Нажать кнопку \"+\" и проверить увеличение количества и стоимоститовара")
    public CartPage clickAndCheckIncrease() {
        var currentCount = getProductCount();
        var currentPrice = getProductPrice();
        quantityIncreaseButton.should(Condition.visible).click();
        var actualCount = getProductCount();
        var actualPrice = getProductPrice();
        Assertions.assertTrue(actualCount > currentCount);
        Assertions.assertTrue(actualPrice > currentPrice);
        return this;
    }

    @Step("Нажать кнопку \"-\" и проверить уменьшение количества и стоимости товара")
    public CartPage clickAndCheckDecrease() {
        var currentCount = getProductCount();
        var currentPrice = getProductPrice();
        quantityReduceButton.should(Condition.visible).click();
        var actualCount = getProductCount();
        var actualPrice = getProductPrice();
        Assertions.assertTrue(actualCount < currentCount);
        Assertions.assertTrue(actualPrice < currentPrice);
        return this;
    }

    public double getProductCount() {
        productItems.should(CollectionCondition.sizeGreaterThanOrEqual(1));
        var rawText = productItems.get(0).$(By.id("ru.vkusvill:id/tv_cart_quantity")).text();
        var rawNumber = rawText.replaceAll("[^\\d,]", "");
        return Double.parseDouble(rawNumber);
    }

    public double getProductPrice() {
        productItems.should(CollectionCondition.sizeGreaterThanOrEqual(1));
        var rawText = productItems.get(0).$(By.id("ru.vkusvill:id/tv_cart_price")).text();
        var rawNumber = rawText.replaceAll("[^\\d,]", "");
        return Double.parseDouble(rawNumber);
    }

    @Step("Нажать кнопку \"Удалить\" справа от товара в корзине")
    public CartPage clickDeleteButton() {
        emulatorActions.horizontalSwipeElement
                (
                        0.5,
                        0.3,
                        firstItemInCart
                );
        deleteButton.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение товара в корзине")
    public CartPage itemInCartDisplaying(String addedItemName) {
        firstItemInCart.should(Condition.visible);
        Assertions.assertTrue(addedItemName.contains(firstItemInCart.getText()));
        return this;
    }

    @Step("Отсутвсвие товара в корзине")
    public CartPage itemInCartNotDisplaying() {
        firstItemInCart.should(Condition.hidden);
        cartItemCountEmpty.should(Condition.visible);
        return this;
    }

    @Step("Удалить все товары из корзины")
    public CartPage clickToDeleteAllItemsFromCart() {
        deleteAllItems.should(Condition.visible).click();
        positiveButton.should(Condition.visible).click();
        return this;
    }

    @Step("Нажать кнопку \"Закрыть\" на странице корзины")
    public CartPage clickCloseButtonInCart() {
        headerElements[1].should(Condition.visible).click();
        return this;
    }

    @Step("Нажать кнопку \"Да\" в окне подтверждения очистки корзины")
    public CartPage clickConfirmButton() {
        confirmClearingCartButton.should(Condition.visible).click();
        return this;
    }

    @Step("Нажать кнопку \"Отмена\" в окне подтверждения очистки корзины")
    public CartPage clickCancelButton() {
        cancelClearingCartButton.should(Condition.visible).click();
        return this;
    }

    @Step("Товар удалён из корзины")
    public CartPage firstPopularItemNotDisplayedInCart() {

        return this;
    }

    @Step("Проверка наличия товара в корзине")
    public CartPage checkProductExisting(String productName) {
        productItems.should(CollectionCondition.sizeGreaterThanOrEqual(1));

        for (var item : productItems) {
            var name = item.$x(".//*[@resource-id='ru.vkusvill:id/tv_title']").should(Condition.visible).text();

            if (productName.contains(name)) return this;
        }

        throw new RuntimeException("В корзине нет товара с названием " + productName);
    }

    @Step("Кликнуть на изменение времени доставки")
    public CartPage clickEditDeliveryTime() {
        editDeliveryTimeButton.should(Condition.visible).click();
        return this;
    }

    @Step("Изменить время доставки на завтра")
    public CartPage editDeliveryTimeToTomorrow() {
        emulatorActions.verticalSwipeElement(0.8, 0.2, deliveryDate);
        return this;
    }

    @Step("Изменить время доставки на сегодня")
    public CartPage editDeliveryTimeToToday() {
        emulatorActions.verticalSwipeElement(0.2, 0.8, deliveryDate);
        return this;
    }

    @Step("Сохранить измененное время доставки")
    public CartPage saveEditDeliveryTime() {
        deliverySaveDateButton.should(Condition.visible).click();
        return this;
    }

    @Step("Проверить отображение время доставки \"Доставка завтра с 8 до 9\"")
    public CartPage deliveryTimeTomorrowDisplaying() {
        return deliveryTimeDisplaying("Доставка завтра c 8 до 9");
    }

    @Step("Проверить отображение время доставки \"Доставка сегодня за 2 часа\"")
    public CartPage deliveryTimeTodayDisplaying() {
        return deliveryTimeDisplaying("Доставка сегодня за 2 часа");
    }

    private CartPage deliveryTimeDisplaying(String text) {
        deliveryTimeTitle.should(Condition.visible).shouldHave(Condition.text(text));
        return this;
    }

    @Step("Открыть настройки заказа")
    public CartPage clickOpenSettings() {
        emulatorActions.verticalSwipeToFindElement(0.5, 0.5, 0.4, settingsButton, 10);
        settingsButton.shouldHave(Condition.text("Настройки заказа"));
        settingsButton.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение настроек заказа")
    public CartPage pageSettingsDisplaying() {
        settingsTitle.should(Condition.visible);
        settingsSectionTitle.should(Condition.visible);
        settingsCallButton.should(Condition.visible);
        settingsDontCallButton.should(Condition.visible);
        settingsUseLessText.should(Condition.visible);
        settingsUseLessButton.should(Condition.visible);
        settingsLeftDoorText.should(Condition.visible);
        settingsLeftDoorButton.should(Condition.visible);
        settingsDoorCallText.should(Condition.visible);
        settingsDoorCallButton.should(Condition.visible);
        return this;
    }

    @Step("Нажать кнопку закрыть корзину")
    public CartPage clickCloseCartPage() {
        closeButton.should(Condition.visible).click();
        return this;
    }

    @Step("Кликнуть комментарий сборщику")
    public CartPage clickCommentCollector() {
        toTheCollector.should(Condition.visible).click();
        return this;
    }

    @Step("Кликнуть комментарий курьеру")
    public CartPage clickCommentCourier() {
        toTheCourier.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение комментария сборщику в корзине")
    public CartPage commentCollectorDisplaying() {
        orderComments.should(Condition.visible);
        toTheCollector.should(Condition.visible);
        commentCollectorTitle
                .should(Condition.visible)
                .shouldHave(Condition.text("Напишите, что важно учесть при сборке"));
        commentCollectorDescription
                .should(Condition.visible)
                .shouldHave(Condition.text("Любые детали, которые важны при выборе товаров"));
        return this;
    }

    @Step("Отображение комментария курьеру в корзине")
    public CartPage commentCourierDisplaying() {
        orderComments.should(Condition.visible);
        toTheCourier.should(Condition.visible);
        commentCourierTitle
                .should(Condition.visible)
                .shouldHave(Condition.text("Напишите, что важно учесть при доставке"));
        commentCourierDescription
                .should(Condition.visible)
                .shouldHave(Condition.text("Например, дополнительный номер телефона, если заказ получаете не вы"));
        return this;
    }

    @Step("Написать комментарий сборщику и проверить его отображение")
    public CartPage writeCommentCollectorAndCheckDisplaying() {
        var message = "Тестовый комментарий сборщику";
        commentCollectorDescription.should(Condition.visible).click();
        commentCollectorDescription.sendKeys(message);
        commentCollectorDescription.shouldHave(Condition.text(message));
        return this;
    }

    @Step("Написать комментарий курьеру и проверить его отображение")
    public CartPage writeCommentCourierAndCheckDisplaying() {
        var message = "Тестовый комментарий курьеру";
        commentCourierDescription.should(Condition.visible).click();
        commentCourierDescription.sendKeys(message);
        commentCourierDescription.shouldHave(Condition.text(message));
        return this;
    }

    @Step("Открыть вкладку \"Моя карта\"")
    public CartPage clickMenuMyCard() {
        menuMyCard.should(Condition.visible).click();
        return this;
    }

    @Step("Открыть вкладку \"Каталог\"")
    public CartPage clickMenuCatalog() {
        menuCatalog.should(Condition.visible).click();
        return this;
    }

    @Step("Открыть вкладку \"Магазин\"")
    public CartPage clickMenuShop() {
        menuShop.should(Condition.visible).click();
        return this;
    }

    @Step("Открыть вкладку \"Профиль\"")
    public CartPage clickMenuProfile() {
        menuProfile.should(Condition.visible).click();
        return this;
    }

    @Step("Открыть вкладку \"Поддержка\"")
    public CartPage clickMenuSupport() {
        menuSupport.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение виджета корзины")
    public CartPage cartWidgetDisplaying() {
        cartWidget.should(Condition.visible);
        return this;
    }

    @Step("Ввести промокод")
    public CartPage enterInvalidPromoCode() {
        emulatorActions.verticalSwipeToFindElement(0.5, 0.5, 0.4, promocode, 10);
        promocode.click();
        promocodeInput.should(Condition.visible).sendKeys("invalid");
        promocodeButton.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение сообщения \"Неверный промокод\"")
    public CartPage invalidPromoCodeMessageDisplaying() {
        promocodeMessage.shouldHave(Condition.text("Неверный промокод"));
        return this;
    }

    @Step("Открыть выбор способа оплаты")
    public CartPage clickOpenPaymentTypes() {
        emulatorActions.verticalSwipeToFindElement(0.8, 0.5, 0.2, paymentTypeButton, 10);
        paymentTypeButton.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение выбора способа оплаты")
    public CartPage pagePaymentTypesDisplaying() {
        paymentTypesTitle.should(Condition.visible);
        paymentTypesItemsContainer.should(Condition.visible);
        paymentCard.should(Condition.visible);
        paymentCash.should(Condition.visible);
        paymentAddCard.should(Condition.visible);
        paymentAddCardDescription.should(Condition.visible);
        paymentSberPay.should(Condition.visible);
        return this;
    }

    @Step("Выбрать способ \"Картой курьеру\"")
    public CartPage clickPaymentTypeCard() {
        paymentCard.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение выбранного способа оплаты \"Картой курьеру\"")
    public CartPage selectedPaymentTypeCardDisplaying() {
        selectedPaymentTypeImage.should(Condition.visible);
        selectedPaymentTypeText.shouldHave(Condition.text("Картой курьеру"));
        selectedPaymentTypeEdit.should(Condition.visible);
        return this;
    }

    @Step("Кликнуть на изменить адрес")
    public CartPage clickEditAddress() {
        emulatorActions.verticalSwipeToFindElement(0.8, 0.5, 0.2, deliveryAddressEditButton, 5);
        deliveryAddressEditButton.click();
        return this;
    }

    @Step("Выбрать первый адрес")
    public String pickFirstAddress() {
        return pickAddress(0);
    }

    @Step("Выбрать второй адрес")
    public String pickSecondAddress() {
        return pickAddress(1);
    }

    private String pickAddress(int index) {
        addressItems.should(CollectionCondition.sizeGreaterThan(index));
        var item = addressItems.get(index);
        var address = item.$(By.id("ru.vkusvill:id/tv_title")).text();
        item.should(Condition.visible).click();
        emulatorActions.verticalSwipeToFindElement(0.8, 0.5, 0.2, pickAddressButton, 10);
        pickAddressButton.should(Condition.visible).click();
        return address;
    }

    public CartPage checkCurrentAddress(String address) {
        emulatorActions.verticalSwipeToFindElement(0.8, 0.5, 0.2, deliveryAddressValue, 5);
        deliveryAddressValue.shouldHave(Condition.text(address));
        return this;
    }

    public CartPage clickAddAddress() {
        addressAddButton.should(Condition.visible).click();
        return this;
    }

    @Step("Кликнуть на виджет корзины")
    public CartPage cartWidgetClick() {
        cartWidget.should(Condition.visible).click();
        return this;
    }

    @Step("Кликнуть на кнопку \"Заказать\"")
    public CartPage clickOrder() {
        emulatorActions.verticalSwipeToFindElement(0.8, 0.5, 0.2, orderButton, 5);
        orderButton.click();
        return this;
    }

    @Step("Уточнить адрес доставки, если необходимо")
    public CartPage specifyAddressIfNeeded() {
        if (specifyAddressFlat.is(Condition.disappear)) return this;
        specifyAddressFlat.click();
        var editText = specifyAddressFlat.$x(".//android.widget.EditText");
        editText.should(Condition.visible).sendKeys("1");
        specifyAddressButton.should(Condition.visible).click();
        return this;
    }

    @Step("Кликнуть на кнопку \"К заказам\"")
    public CartPage clickToOrders() {
        toOrdersButton.should(Condition.visible).click();
        return this;
    }

}
