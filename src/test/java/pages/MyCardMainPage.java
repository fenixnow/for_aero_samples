package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import driver.EmulatorActions;

import static com.codeborne.selenide.Selenide.*;

public class MyCardMainPage extends CreatingCardPage {

    protected String listName;

    EmulatorActions emulatorActions = new EmulatorActions();

    protected SelenideElement cardNumber = $(MobileBy.xpath("//*[@text='Карта G293201']"));
    protected SelenideElement userName = $(MobileBy.id("ru.vkusvill:id/tv_toolbar_subtitle"));
    protected SelenideElement copyCardNumberIcon = $(MobileBy.id("ru.vkusvill:id/iv_toolbar_title_copy"));
    protected SelenideElement gearSettingsIcon = $(MobileBy.id("ru.vkusvill:id/menu_profile_settings"));
    protected SelenideElement bellNotificationsIcon = $(MobileBy.id("ru.vkusvill:id/imageView_icon"));
    protected SelenideElement newsForFreeStory = $(MobileBy.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1][@text='Новинки к выходным']"));
    protected SelenideElement recipientSalmonWithBlueCheeseStory = $(MobileBy.xpath("//*[@text='Рецепт сёмги с голубым сыром']"));
    protected SelenideElement whatIsBirdWatchingStory = $(MobileBy.xpath("//*[@text='Что такое бёрдвотчинг?']"));
    protected SelenideElement cheeseDiscountsStory = $(MobileBy.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4][@text='Сырррные скидки']"));
    protected SelenideElement listProductsWithDiscountsStory = $(MobileBy.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1][@text='Подборка продуктов со скидками']"));
    protected SelenideElement citrusForColdsStory = $(MobileBy.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2][@text='Цитрусовые от простуды']"));
    protected SelenideElement recipientFatStory = $(MobileBy.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3][@text='Рецепт сала']"));
    protected SelenideElement turnOnProfitStory = $(MobileBy.xpath("//android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4][@text='Включаем выгоду']"));
    protected SelenideElement turnOnProfitLabel = $(MobileBy.id("ru.vkusvill:id/content"));
    protected SelenideElement turnOnProfitLabelTitle = $(MobileBy.xpath("//*[@text='Включаем выгоду']"));
    protected SelenideElement favoriteProductLabel = $(MobileBy.xpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup"));
    protected SelenideElement favoriteProductLabelTitle = $(MobileBy.xpath("//*[@text='Любимый продукт']"));
    protected SelenideElement favoriteProductLabelDetailsButton = $(MobileBy.xpath("//android.widget.RelativeLayout/android.widget.TextView[2][@text='Детали']"));
    protected SelenideElement diverseFoodLabel = $(MobileBy.xpath("//android.widget.LinearLayout[3]"));
    protected SelenideElement diverseFoodLabelDetailsButton = $(MobileBy.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView[2][@text='Детали']"));
    protected SelenideElement diverseFoodLabelTitle = $(MobileBy.xpath("//*[@text='Разнообразное питание']"));
    protected SelenideElement sixDiscountsLabelTitle = $(MobileBy.xpath("//*[@text='6 скидок']"));
    protected SelenideElement sixDiscountsLabelChooseShopButton = $(MobileBy.xpath("//*[@text='Выбрать магазин']"));
    protected SelenideElement achievementsLabel = $(MobileBy.id("ru.vkusvill:id/rl_menu_achievements"));
    protected SelenideElement achievementsLabelTitle = $(MobileBy.xpath("//*[@text='Достижения']"));
    protected SelenideElement bonusesLabel = $(MobileBy.id("ru.vkusvill:id/rl_menu_bonuses"));
    protected SelenideElement bonusesLabelTitle = $(MobileBy.xpath("//*[@text='Бонусы']"));
    protected SelenideElement bonusesLabelDescription = $(MobileBy.xpath("//*[@text='Бонусов пока нет']"));
    protected SelenideElement listsLabel = $(MobileBy.id("ru.vkusvill:id/rl_menu_lists"));
    protected SelenideElement listsLabelTitle = $(MobileBy.xpath("//*[@text='Списки']"));
    protected SelenideElement childClubLabel = $(MobileBy.id("ru.vkusvill:id/cl_child_club"));
    protected SelenideElement childClubLabelTitle = $(MobileBy.xpath("//*[@text='Детский клуб']"));
    protected SelenideElement gourmandLabel = $(MobileBy.id("ru.vkusvill:id/cl_gourment"));
    protected SelenideElement gourmandLabelTitle = $(MobileBy.xpath("//*[@text='Народный гурман']"));
    protected SelenideElement b2bProfileLabelCloseButton = $(MobileBy.id("ru.vkusvill:id/img_b2b_close"));
    protected SelenideElement b2bProfileLabelTitle = $(MobileBy.xpath("//*[@text='B2B профиль']"));
    protected SelenideElement b2bProfileLabelDescription = $(MobileBy.xpath("//*[@text='Покупайте как юридическое лицо или ИП на специальных условиях']"));
    protected SelenideElement specialSuggestionsHeader = $(MobileBy.xpath("//*[@text='Спецпредложения']"));
    protected SelenideElement discountForYourCardLabelTitle = $(MobileBy.xpath("//*[@text='Скидка\n" + "по вашей карте']"));
    protected SelenideElement discountOnMultipleItemsLabelTitle = $(MobileBy.xpath("//*[@text='Скидка от\n" + "нескольких\n" + "товаров']"));
    protected SelenideElement scanPurchaseMySelfLabelTitle = $(MobileBy.xpath("//*[@text='Отсканируйте свои покупки сами']"));
    protected SelenideElement scanPurchaseMySelfLabelDescription = $(MobileBy.xpath("//*[@text='Сканируйте штрих-коды сами, а потом просто оплачивайте на кассе.']"));
    protected SelenideElement receiptsLabelTitle = $(MobileBy.xpath("//*[@text='Рецепты']"));
    protected SelenideElement scanQROnBoxOfficeButton = $(MobileBy.id("ru.vkusvill:id/ll_qr"));
    protected SelenideElement scanQROnBoxOfficeButtonTitle = $(MobileBy.xpath("//*[@text='Сканировать QR на кассе']"));
    protected SelenideElement orderPicked = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/content']"));
    protected SelenideElement listsPageTitle = $(MobileBy.xpath("//*[@text='Списки']"));
    protected SelenideElement backButton = $(MobileBy.accessibilityId("Перейти вверх"));
    protected SelenideElement newListButton = $(MobileBy.xpath("//*[@text='Новый список']"));
    protected SelenideElement createListWindowTitle = $(MobileBy.xpath("//*[@text='Свойства списка']"));
    protected SelenideElement createListWindowInputField = $(MobileBy.id("android:id/input"));
    protected SelenideElement createListWindowCancelButton = $(MobileBy.xpath("//*[@text='ОТМЕНА']"));
    protected SelenideElement createListWindowSaveButton = $(MobileBy.xpath("//*[@text='СОХРАНИТЬ']"));
    protected SelenideElement createdListIcon = $(MobileBy.id("ru.vkusvill:id/ivListPic"));
    protected SelenideElement createdListTitle = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/tvTitle']"));
    protected SelenideElement createdListItemsCounter = $(MobileBy.id("ru.vkusvill:id/tvCount"));
    protected SelenideElement createdListDetailPageTitle = $(MobileBy.xpath("//android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"));
    protected SelenideElement createdListDetailPageActionsButton = $(MobileBy.id("ru.vkusvill:id/textView_count"));
    protected SelenideElement createdListDetailPageSearchIcon = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/ll_search']/*[@resource-id='ru.vkusvill:id/imageView_search']"));
    protected SelenideElement createdListDetailPageSearchPlaceholder = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/ll_search']/*[@resource-id='ru.vkusvill:id/textView_search']"));
    protected SelenideElement createdListDetailPageRemindHeader = $(MobileBy.xpath("//*[@text='Напомнить']"));
    protected SelenideElement createdListDetailPageRemindSwitcher = $(MobileBy.id("ru.vkusvill:id/switch_remind"));
    protected SelenideElement createdListDetailPageListCount = $(MobileBy.id("ru.vkusvill:id/tvBasketCount"));
    protected SelenideElement createdListDetailPageChoseShopButton = $(MobileBy.id("ru.vkusvill:id/button_shop_select"));
    protected SelenideElement createdListDetailPageListSum = $(MobileBy.id("ru.vkusvill:id/tvBasketSum"));
    protected SelenideElement createdListDetailPageBackButton = $(MobileBy.xpath("(//android.widget.ImageButton[@content-desc=\"Перейти вверх\"])[2]"));

    /**
     * Рекомендуем
     */
    private SelenideElement recommendedHeader = $x("//android.widget.TextView[@text='Рекомендуем']");
    private SelenideElement recommendedList = $x("//*[@text='Рекомендуем']/parent::*/parent::*//androidx.recyclerview.widget.RecyclerView/parent::*");
    private ElementsCollection recommendedItems = $$x("//*[@text='Рекомендуем']/parent::*/parent::*//android.widget.FrameLayout//android.widget.TextView");
    private SelenideElement historyToolbar = $x("//*[@resource-id='ru.vkusvill:id/toolbar']//*[@text='История покупок']");

    protected SelenideElement[] myCardMainPageHeaderElements = {
            cardNumber,
            userName,
            copyCardNumberIcon,
            bellNotificationsIcon,
            gearSettingsIcon
    };

    protected SelenideElement[] myCardMainPageStories1 = {
            newsForFreeStory,
            recipientSalmonWithBlueCheeseStory,
            cheeseDiscountsStory
    };

    protected SelenideElement[] myCardMainPageStories2 = {
            listProductsWithDiscountsStory,
            whatIsBirdWatchingStory,
            citrusForColdsStory,
            recipientFatStory,
            turnOnProfitStory
    };

    protected SelenideElement[] myCardMainPageLabelsWithContent1 = {
            turnOnProfitLabel,
            turnOnProfitLabelTitle,
            favoriteProductLabel,
            favoriteProductLabelTitle,
            favoriteProductLabelDetailsButton,
            diverseFoodLabel,
            diverseFoodLabelTitle,
            diverseFoodLabelDetailsButton,
            sixDiscountsLabelTitle,
            sixDiscountsLabelChooseShopButton,
    };

    protected SelenideElement[] myCardMainPageLabelsWithContent2 = {
            achievementsLabel,
            achievementsLabelTitle,
            bonusesLabel,
            bonusesLabelTitle,
            bonusesLabelDescription,
            listsLabel,
            listsLabelTitle,
            childClubLabel,
            childClubLabelTitle,
            gourmandLabel,
            gourmandLabelTitle,
            b2bProfileLabelTitle,
            b2bProfileLabelDescription,
            b2bProfileLabelCloseButton,
            specialSuggestionsHeader,
            discountForYourCardLabelTitle,
            discountOnMultipleItemsLabelTitle,
            scanPurchaseMySelfLabelTitle,
            scanPurchaseMySelfLabelDescription,
            receiptsLabelTitle,
            scanQROnBoxOfficeButton,
            scanQROnBoxOfficeButtonTitle
    };

    protected SelenideElement[] listsPageElements = {
            listsPageTitle,
            backButton,
            newListButton
    };

    protected SelenideElement[] createListWindowElements = {
            createListWindowTitle,
            createListWindowInputField,
            createListWindowCancelButton,
            createListWindowSaveButton
    };

    protected SelenideElement[] createdListElements = {
            createdListIcon,
            createdListTitle,
            createdListItemsCounter
    };

    protected SelenideElement[] createdListDetailPageElements = {
            createdListDetailPageTitle,
            createdListDetailPageActionsButton,
            createdListDetailPageBackButton,
            createdListDetailPageSearchIcon,
            createdListDetailPageSearchPlaceholder,
            createdListDetailPageRemindHeader,
            createdListDetailPageRemindSwitcher,
            createdListDetailPageChoseShopButton,
            createdListDetailPageListCount,
            createdListDetailPageListSum
    };

    @Step("Заходим на страницу настроек \"Моя карта\"")
    public MyCardMainPage enterSettingsPage() {
        myCardMainPageHeaderElements[4].should(Condition.visible).click();
        return this;
    }
/**
 * Вспомогательный шаг
 */
    @Step("Заходим на страницу настроек \"Моя карта\"")
    public MyCardMainPage clickMyCardIconIfMainPageNotOpened() {
        if(!(myCardMainPageHeaderElements[0].is(Condition.visible))) {
            myCardButton.should(Condition.visible).click();
        }
        return this;
    }

    @Step("Отображение элементов страницы \"Моя карта\"")
    public MyCardMainPage myCardMainPageElementsDisplaying() {
        for (SelenideElement element : myCardMainPageHeaderElements) {
            element.should(Condition.visible);
        }
        for (int i = 0; i<3; i++) {
            emulatorActions.horizontalSwipe
                    (
                            0.5,
                            0.2,
                            0.4,
                            200
                    );
        }
        for (int i = 0; i<3; i++) {
            emulatorActions.verticalSwipe
                    (
                            0.9,
                            0.01,
                            0.4,
                            200
                    );
        }
        return this;
    }

    @Step("Нажать иконку \"Копировать\" рядом с номером карты")
    public MyCardMainPage clickCopyCardNumber() {
        myCardMainPageHeaderElements[2].should(Condition.visible).click();
        return this;
    }

    @Step("Копированный номер карты сохранён в буфере обмена")
    public MyCardMainPage copiedCardNumberSaveInClipboard() {
        String cardNumber = myCardMainPageHeaderElements[0].getText();
        String outputCopiedCardNumber = new StringBuilder(cardNumber).insert(cardNumber.length()-7,"№").toString();
        emulatorActions.copiedValueCheck(outputCopiedCardNumber);
        return this;
    }

    @Step("Нажать на лейбл \"Списки\"")
    public MyCardMainPage clickListsLabel() {
        if(orderPicked.is(Condition.visible)) {
                emulatorActions.verticalSwipe(
                        0.5,
                        0.01,
                        0.2,
                        200
                );
        }
        emulatorActions.verticalSwipeToFindElement(
            0.5, 0.01, 0.4,
            listsLabel, 1000, "Label not found"
        );
        listsLabel.click();
        return this;
    }

    @Step("Отображение страницы \"Списки\"")
    public MyCardMainPage listsPageDisplaying() {
        for (SelenideElement element:listsPageElements) {
            element.should(Condition.visible);
        }
        ElementsCollection lists = $$x("//*[@resource-id='ru.vkusvill:id/tvTitle']");
        ElementsCollection deleteButtons = $$x("//*[@resource-id='ru.vkusvill:id/menu_delete']");
        if (lists.size() > 0) {
            for (SelenideElement element: lists) {
                element.should(Condition.visible);
                emulatorActions.horizontalSwipeOnElement
                        (
                                element,
                                -100,
                                200
                        );
            }
        }
        if (deleteButtons.size() > 0) {
            for (SelenideElement delete: deleteButtons) {
                delete.should(Condition.visible).click();
            }
        }
        return this;
    }

    @Step("Нажать на лейбл \"Новый список\"")
    public MyCardMainPage clickNewListButton() {
        newListButton.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение модального окна \"Свойства списка\"")
    public MyCardMainPage createListWindowDisplaying() {
        for (SelenideElement element: createListWindowElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Ввести название нового списка")
    public MyCardMainPage inputNewListName() {
        emulatorActions.clearAllCharsInInputField(createListWindowInputField);
        createListWindowInputField.sendKeys("Тестовый");
        return this;
    }

    @Step("Нажать кнопку \"Сохранить\"")
    public String clickSaveButton() {
        listName = createListWindowInputField.getText();
        createListWindowSaveButton.click();
        return listName;
    }

    @Step("Отображение детальной страницы созданного списка")
    public MyCardMainPage detailListPageDisplaying() {
        for (SelenideElement element: createdListDetailPageElements) {
            element.should(Condition.visible);
        }
        Assertions.assertEquals(listName, createdListDetailPageTitle.getText());
        return this;
    }

    @Step("Отображение созданного списка на странице \"Списки\"")
    public MyCardMainPage createdListDisplayingOnListsPage() {
        createdListDetailPageBackButton.click();
        for (SelenideElement element:createdListElements) {
            element.should(Condition.visible);
        }
        Assertions.assertEquals(listName, createdListTitle.getText());
        return this;
    }

    @Step("Листаем до блока Рекомендуем")
    public MyCardMainPage swipeToRecommended() {
        emulatorActions.verticalSwipeToFindElement(
                0.6,
                0.5,
                0.4,
                recommendedHeader,
                20
        );
        return this;
    }

    @Step("Листаем блок Рекомендуем влево потом вправо")
    public MyCardMainPage swipeRecommendedLeftRight() {
        String firstText = recommendedItems.get(0).getText();

        emulatorActions.horizontalSwipeElement(
                0.8,
                0.2,
                recommendedList
        );
        Assertions.assertNotEquals(firstText, recommendedItems.get(0).getText());

        emulatorActions.horizontalSwipeElement(
                0.2,
                0.8,
                recommendedList
        );
        Assertions.assertEquals(firstText, recommendedItems.get(0).getText());

        return this;
    }

    @Step("Открываем историю покукоп")
    public MyCardMainPage openHistory() {
        for (SelenideElement recommendedItem : recommendedItems) {
            if (recommendedItem.text().equalsIgnoreCase("История покупок")) {
                recommendedItem.click();
            }
        }
        return this;
    }

    @Step("Отображается история покукок")
    public MyCardMainPage historyDisplaying() {
        historyToolbar.should(Condition.visible);
        return this;
    }

}
