package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import driver.EmulatorActions;

import java.util.*;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    EmulatorActions emulatorActions = new EmulatorActions();

    /**
     * Элементы страницы
     */
    private SelenideElement catalogMenuIcon = $(MobileBy.id("ru.vkusvill:id/bottom_item_catalog"));
    private SelenideElement warningIcon = $(MobileBy.id("ru.vkusvill:id/iv_service_not"));
    private SelenideElement сallToAction = $(MobileBy.xpath("//*[@text='Укажите адрес, чтобы видеть\n" +
            "актуальные цены и ассортимент']"));
    private SelenideElement inputAddressButton = $(MobileBy.xpath("//*[@text='Ввести адрес']"));
    private SelenideElement findProductsField = $(MobileBy.xpath("//*[@class='android.widget.RelativeLayout' and @index='0']"));
    private SelenideElement findProductsFieldAfterClick = $(MobileBy.id("ru.vkusvill:id/et_search"));
    private SelenideElement findProductsFieldPlaceholder = $(MobileBy.xpath("//android.widget.TextView[@text='Найти продукты']"));
    private SelenideElement barCodeButton = $(MobileBy.id("ru.vkusvill:id/iv_barcode"));
    private SelenideElement filterButton = $(MobileBy.id("ru.vkusvill:id/iv_filter"));
    private SelenideElement showFavoriteButton = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/rl_favorites']/*[@resource-id='ru.vkusvill:id/iv_favorites']"));
    private SelenideElement recommendedHeader = $(MobileBy.xpath("//android.widget.TextView[@text='Рекомендуем']"));
    private SelenideElement popularHeader = $(MobileBy.xpath("//*[@text='Популярное']"));
    private SelenideElement addToCartButton = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/ll_cart_empty']//*[@text='В корзину']"));
    private SelenideElement shopsHistoryLabelTitle = $(MobileBy.xpath("//*[@class='android.widget.RelativeLayout']//*[@text='История покупок']"));
    private SelenideElement categoriesHeader = $(MobileBy.xpath("//*[@text='Категории']"));
    private SelenideElement noveltyLabelWithHeader = $(MobileBy.xpath("//*[@class='android.widget.RelativeLayout']//*[@text='Новинки']"));
    private SelenideElement hitsLabelWithHeader = $(MobileBy.xpath("//*[@class='android.widget.RelativeLayout']//*[@text='Хиты']"));
    private SelenideElement turnOnLabelWithHeader = $(MobileBy.xpath("//*[@class='android.widget.RelativeLayout']//*[@text='Включаем выгоду']"));
    private SelenideElement readyMealsLabelWithHeader = $(MobileBy.xpath("//*[@class='android.widget.RelativeLayout']//*[@text='Готовая еда']"));
    private SelenideElement sweetsAndDessertsLabelWithHeader = $(MobileBy.xpath("//*[@class='android.widget.RelativeLayout']//*[@text='Сладости и десерты']"));
    private SelenideElement firstPopularItemNameInFavorites = $(MobileBy.id("ru.vkusvill:id/textView_title"));

    /**
     * Элементы карты выбора магазина
     */
    private SelenideElement myAddressesButton = $(MobileBy.id("ru.vkusvill:id/ll_addresses"));
    private SelenideElement firstAddressInList = $(MobileBy.xpath("//*[@text='городской округ Воркута, Центральная площадь, 1']"));
    private SelenideElement chooseAddressButton = $(MobileBy.id("ru.vkusvill:id/button"));
    private SelenideElement chooseAddressButton2 = $(MobileBy.id("ru.vkusvill:id/btn_select"));
    private SelenideElement itsClearButton = $(MobileBy.id("ru.vkusvill:id/button_rules_ok"));

    /**
     * Первый товар в популярное
     */
    private SelenideElement firstItemInPopularLabel = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/rl_root' and @index='0']"));
    private SelenideElement firstItemInPopularName = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/rl_root' and @index='0']//*[@resource-id='ru.vkusvill:id/textView_title']"));
    private SelenideElement firstItemInPopularAddToList = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/rl_root' and @index='0']//*[@resource-id='ru.vkusvill:id/iv_basket']"));
    private SelenideElement firstItemInPopularAddToFavorite = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/rl_root' and @index='0']//*[@resource-id='ru.vkusvill:id/iv_chosen']"));
    private SelenideElement firstItemInPopularPrice = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/rl_root' and @index='0']//*[@resource-id='ru.vkusvill:id/vPrice']"));
    private SelenideElement firstItemInPopularAddToCart = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/rl_root' and @index='0']//*[@resource-id='ru.vkusvill:id/ll_cart_empty']"));
    private SelenideElement firstPopularItemInCartTitle = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/smContentView']//*[@resource-id='ru.vkusvill:id/tv_title']"));
    private ElementsCollection allItemInPopularRemoveFromList = $$(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/rl_root']//*[@resource-id='ru.vkusvill:id/iv_chosen']"));
    private String firstItemName;

    /**
     * Огурцы гладкие
     */
    private final String searchCardXPath = "//*[@resource-id='ru.vkusvill:id/container']//*[@resource-id='ru.vkusvill:id/slidable_panel']//*[@resource-id='ru.vkusvill:id/rl_root']";
    private SelenideElement smoothCucumbersTitle = $x("//*[@resource-id='ru.vkusvill:id/textView_title' and @text='Огурцы гладкие']");
    private SelenideElement smoothCucumbersToCart = $x(searchCardXPath + "//*[@text='В корзину']");
    private SelenideElement smoothCucumbersToList = $x(searchCardXPath + "//*[@resource-id='ru.vkusvill:id/iv_basket']");
    private SelenideElement smoothCucumbersToFavorite = $x(searchCardXPath + "//*[@resource-id='ru.vkusvill:id/iv_chosen']");
    private SelenideElement smoothCucumbersPrice = $x(searchCardXPath + "//*[@resource-id='ru.vkusvill:id/vPrice']");
    private SelenideElement smoothCucumbersRating = $x(searchCardXPath + "//*[@resource-id='ru.vkusvill:id/tv_rating']");

    /**
     * Категории в поиске
     */
    private final ElementsCollection searchCategoriesSuggestionsTitle = $$x("//*[@resource-id='ru.vkusvill:id/srl']//*[@resource-id='ru.vkusvill:id/rl_root' and @index='0']//*[@resource-id='ru.vkusvill:id/tv']");
    private final ElementsCollection searchCategoriesSuggestionsSubtitle = $$x("//*[@resource-id='ru.vkusvill:id/srl']//*[@resource-id='ru.vkusvill:id/rl_root' and @index='0']//*[@resource-id='ru.vkusvill:id/tv_desc']");

    /**
     * Виджет корзины внизу экрана
     */
    private SelenideElement cartWidget = $(MobileBy.id("ru.vkusvill:id/cartWidget"));
    private SelenideElement cartWidgetWithDeliveryWithMethod = $(MobileBy.id("ru.vkusvill:id/rl_cart_widget_normal"));
    private SelenideElement cartWidgetTitle = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/cartWidget']//*[@text='Корзина']"));
    private SelenideElement cartWidgetSum = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/cartWidget']//*[@resource-id='ru.vkusvill:id/tv_cart_widget_sum']"));
    private SelenideElement cartWidgetInfo = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/cartWidget']//*[@resource-id='ru.vkusvill:id/tv_cart_widget_info_title']"));
    private SelenideElement cartWidgetInfoDesc = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/cartWidget']//*[@resource-id='ru.vkusvill:id/tv_cart_widget_info_desc']"));
    private SelenideElement cartWidgetQuantity = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/cartWidget']//*[@resource-id='ru.vkusvill:id/tv_cart_widget_tov']"));
    private SelenideElement cartWidgetIcon = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/cartWidget']//*[@class='android.widget.ImageView' and @index='0']"));
    private SelenideElement cartWidgetEnterIcon = $(MobileBy.xpath("//*[@resource-id='ru.vkusvill:id/cartWidget']//*[@class='android.widget.ImageView' and @index='2']"));

    /**
     * Окно добавления товара в список
     */
    private SelenideElement addToListWindowTitle = $(MobileBy.id("ru.vkusvill:id/md_title"));
    private SelenideElement addToListWindowChoseListHeader = $(MobileBy.xpath("//*[@text='Выберите список']"));
    private SelenideElement addToListWindowDropDownPlaceholder = $(MobileBy.id("android:id/text1"));
    private SelenideElement addToListWindowDropDown = $(MobileBy.id("ru.vkusvill:id/spBasketList"));
    private SelenideElement addToListWindowItemNameHeader = $(MobileBy.xpath("//*[@text='Наименование продукта']"));
    private SelenideElement addToListWindowItemName = $(MobileBy.id("ru.vkusvill:id/tvProductTitle"));
    private SelenideElement addToListWindowReduceQuantityButton = $(MobileBy.id("ru.vkusvill:id/ivLess"));
    private SelenideElement addToListWindowIncreaseQuantityButton = $(MobileBy.id("ru.vkusvill:id/ivMore"));
    private SelenideElement addToListWindowQuantityText = $(MobileBy.xpath("//*[@text='Количество']"));
    private SelenideElement addToListWindowQuantityText2 = $(MobileBy.xpath("//*[@text=':']"));
    private SelenideElement addToListWindowQuantityValue = $(MobileBy.id("ru.vkusvill:id/tvValue"));
    private SelenideElement addToListCancelButton = $(MobileBy.xpath("//*[@text='ОТМЕНА']"));
    private SelenideElement addToListAddButton = $(MobileBy.xpath("//*[@text='ДОБАВИТЬ']"));

    /**
     * Сортировка по цене
     */
    private final SelenideElement searchOrder = $(MobileBy.id("ru.vkusvill:id/menu_sort"));
    private final ElementsCollection searchPrices = $$x(searchCardXPath + "//*[@resource-id='ru.vkusvill:id/tvPrice']");

    /**
     * Корзина в поиске
     */
    private final SelenideElement addToCartFromSearchTitle = $x(searchCardXPath + "//*[@resource-id='ru.vkusvill:id/textView_title']");
    private SelenideElement addToCartFromSearch = $x(searchCardXPath + "//*[@text='В корзину']");
    private SelenideElement addToCartFromSearchQuantity = $x(searchCardXPath + "//*[@resource-id='ru.vkusvill:id/tv_cart_quantity']");

    /**
     * Карточка товара
     */
    private SelenideElement productBackButton = $x("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]");
    private SelenideElement productShareButton = $x("//android.widget.Button[@content-desc=\"Поделиться\"]");
    private SelenideElement productFavoriteButton = $x("//android.widget.Button[@content-desc=\"Избранный\"]");
    private SelenideElement productImage = $x("//*[@resource-id='ru.vkusvill:id/llListProductSlider']//*[@resource-id='ru.vkusvill:id/viewPager']//*[@resource-id='ru.vkusvill:id/imageView']");
    private SelenideElement productImageRating = $x("//*[@resource-id='ru.vkusvill:id/rating_tov']");
    private SelenideElement productTitle = $x("//*[@resource-id='ru.vkusvill:id/tv_title']");
    private SelenideElement productWeight = $x("//*[@resource-id='ru.vkusvill:id/tv_weight']");
    private SelenideElement productPrice = $x("//*[@resource-id='ru.vkusvill:id/pwPrice']");
    private SelenideElement productReview = $x("//*[@resource-id='ru.vkusvill:id/ll_check']");
    private SelenideElement productCartIcon = $x("//*[@resource-id='ru.vkusvill:id/iv_product_add']");
    private SelenideElement productCartButton = $x("//*[@resource-id='ru.vkusvill:id/tv_product_add']");
    private SelenideElement productFavoriteIcon = $x("//*[@resource-id='ru.vkusvill:id/iv_product_lp']");
    private SelenideElement productFavoriteButton2 = $x("//*[@resource-id='ru.vkusvill:id/tv_product_lp']");
    private SelenideElement productManufacturer = $x("//*[@resource-id='ru.vkusvill:id/llListProductManufacturer']");
    private SelenideElement productExpiry = $x("//*[@resource-id='ru.vkusvill:id/llListProductExpiryDate']");
    private SelenideElement productDesc = $x("//*[@resource-id='ru.vkusvill:id/llListProductDesc1']");
    private SelenideElement productReviews = $x("//*[@resource-id='ru.vkusvill:id/llListProductReviewAll']");

    /**
     * Блок "Рекомендуем"
     */
    private SelenideElement recommendationHistory = $x("//*[@resource-id='ru.vkusvill:id/tv' and @text='История покупок']");
    private ElementsCollection recommendationItems = $$x("(//androidx.recyclerview.widget.RecyclerView[@resource-id='ru.vkusvill:id/rv'])[1]/*");

    /**
     * Блок "Популярное"
     */
    private ElementsCollection popularItems = $$x("(//androidx.recyclerview.widget.RecyclerView[@resource-id='ru.vkusvill:id/rv'])[2]/*");

    /**
     * Блок "Категории"
     */
    private ElementsCollection categoriesItems = $$x("//android.widget.GridView[@resource-id='ru.vkusvill:id/rv']/android.view.ViewGroup");

    // История покупок
    private SelenideElement historyBackButton = $x("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]");
    private SelenideElement historyTitle = $x("//*[@resource-id='ru.vkusvill:id/toolbar']//*[@text='История покупок']");
    private SelenideElement historySortingButton = $(By.id("ru.vkusvill:id/menu_sort"));
    private SelenideElement historySearchInput = $x("//*[@resource-id='ru.vkusvill:id/container']//*[@resource-id='ru.vkusvill:id/slidable_panel']//*[@resource-id='ru.vkusvill:id/ll_search']//*[@text='Найти продукты']");
    private SelenideElement historySearchBarcode = $x("//*[@resource-id='ru.vkusvill:id/container']//*[@resource-id='ru.vkusvill:id/slidable_panel']//*[@resource-id='ru.vkusvill:id/iv_barcode']");
    private SelenideElement historySettingsButton = $x("//*[@resource-id='ru.vkusvill:id/container']//*[@resource-id='ru.vkusvill:id/slidable_panel']//*[@resource-id='ru.vkusvill:id/iv_filter']");
    private SelenideElement historyProduct = $x("//*[@resource-id='ru.vkusvill:id/container']//*[@resource-id='ru.vkusvill:id/slidable_panel']//*[@resource-id='ru.vkusvill:id/rl_root']");

    /**
     * Подкатегории
     */
    private SelenideElement categoryHits = $x("//*[@resource-id='ru.vkusvill:id/tv' and @text='Хиты']");
    private SelenideElement categoryBackButton = $x("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]");
    private SelenideElement categoryTitle = $x("//*[@resource-id='ru.vkusvill:id/toolbar']//*[@text='Хиты']");
    private SelenideElement categorySearch = $x("//*[@resource-id='ru.vkusvill:id/ll_search']//*[@text='Найти продукты']");
    private SelenideElement categoryBarcode = $x("//*[@resource-id='ru.vkusvill:id/iv_barcode']");
    private SelenideElement categoryFilter = $x("//*[@resource-id='ru.vkusvill:id/iv_filter']");
    private SelenideElement categoryAllProducts = $x("//*[@resource-id='ru.vkusvill:id/srl']//*[@text='Все товары категории']");
    private ElementsCollection categorySubcategories = $$x("//*[@resource-id='ru.vkusvill:id/srl']//*[@resource-id='ru.vkusvill:id/rl_root']");

    /**
     * Избранное
     */
    private ElementsCollection favoriteItems = $$x("//*[@resource-id='ru.vkusvill:id/rv']/*");

    private SelenideElement[] catalogPageElements = {
            catalogMenuIcon,
            warningIcon,
            сallToAction,
            inputAddressButton,
            findProductsField,
            barCodeButton,
            filterButton,
            showFavoriteButton,
            recommendedHeader,
            findProductsFieldPlaceholder,
            popularHeader,
            shopsHistoryLabelTitle,
            addToCartButton
    };

    private SelenideElement[] catalogPageCategoriesHeaderAndLabels = {
            categoriesHeader,
            noveltyLabelWithHeader,
            hitsLabelWithHeader,
            turnOnLabelWithHeader,
            readyMealsLabelWithHeader,
            sweetsAndDessertsLabelWithHeader
    };

    private SelenideElement[] firstItemInPopularElements = {
            firstItemInPopularLabel,
            firstItemInPopularName,
            firstItemInPopularAddToFavorite,
            firstItemInPopularPrice,
            firstItemInPopularAddToList,
            firstItemInPopularAddToCart
    };

    private SelenideElement[] smoothCucumbersElements = {
            smoothCucumbersTitle,
            smoothCucumbersToFavorite,
            smoothCucumbersPrice,
            smoothCucumbersRating,
            smoothCucumbersToList,
            smoothCucumbersToCart
    };

    private SelenideElement[] cartWidgetElements = {
            cartWidget,
            cartWidgetTitle,
            cartWidgetInfo,
            cartWidgetInfoDesc,
            cartWidgetQuantity,
            cartWidgetSum,
            cartWidgetIcon,
            cartWidgetEnterIcon
    };

    private SelenideElement[] addToListWindowElements = {
            addToListWindowTitle,
            addToListWindowChoseListHeader,
            addToListWindowDropDownPlaceholder,
            addToListWindowDropDown,
            addToListWindowItemNameHeader,
            addToListWindowItemName,
            addToListWindowReduceQuantityButton,
            addToListWindowIncreaseQuantityButton,
            addToListWindowQuantityText,
            addToListWindowQuantityText2,
            addToListWindowQuantityValue,
            addToListCancelButton,
            addToListAddButton,
    };


    @Step("Отображение иконки \"Каталог\"")
    public CatalogPage catalogIconDisplaying() {
        catalogPageElements[0].should(Condition.visible);
        return this;
    }

    @Step("Нажать на иконку \"Каталог\"")
    public CatalogPage catalogIconClick() {
        catalogPageElements[0].should(Condition.visible).click();
        return this;
    }

    @Step("Отображение элементов страницы \"Каталог\"")
    public CatalogPage catalogPageElementsDisplaying() {
        catalogPageElements[0].click();
        for (SelenideElement element : catalogPageElements) {
            element.should(Condition.visible);
        }
        emulatorActions.verticalSwipeToFindElement(
            0.5, 0.5, 0.47,
            catalogPageCategoriesHeaderAndLabels[0],
            20,
            "Label not found"
        );
        for (SelenideElement element : firstItemInPopularElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Кликнуть на поле \"Найти продукты\"")
    public CatalogPage findProductsFieldClick() {
        catalogPageElements[9].should(Condition.visible).click();
        return this;
    }

    @Step("Написать \"Огурцы гладкие\"")
    public CatalogPage writeSmoothCucumbersText() {
        findProductsFieldAfterClick.should(Condition.visible).sendKeys("Огурцы гладкие");
        emulatorActions.hideKeyBd();
        return this;
    }

    @Step("Кликнуть на кнопку сортировки в поиске")
    public CatalogPage searchSortingClick() {
        searchOrder.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение товаров в поиске в порядке убывания")
    public CatalogPage searchResultDescendingDisplaying() {
        searchPrices.shouldBe(CollectionCondition.sizeGreaterThan(1));
        List<Integer> prices = getSearchResultPrices();
        Assertions.assertFalse(prices.isEmpty());
        Assertions.assertEquals(prices.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()), prices);
        return this;
    }

    @Step("Отображение товаров в поиске в порядке возрастания")
    public CatalogPage searchResultAscendingDisplaying() {
        searchPrices.shouldBe(CollectionCondition.sizeGreaterThan(1));
        List<Integer> prices = getSearchResultPrices();
        Assertions.assertFalse(prices.isEmpty());
        Assertions.assertEquals(prices.stream().sorted().collect(Collectors.toList()), prices);
        return this;
    }

    @Step("Отображение товара \"Огурцы гладкие\"")
    public CatalogPage smoothCucumbersDisplaying() {
        if (!(smoothCucumbersTitle.is(Condition.visible))) {
            emulatorActions.verticalSwipeToFindElement(
                0.5, 0.5, 0.47,
                smoothCucumbersTitle,
                20,
                "Item not found"
            );
        }
        for (SelenideElement element : smoothCucumbersElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    public CatalogPage clickToOpenProduct() {
        smoothCucumbersTitle.should(Condition.visible).click();
        return this;
    }

    @Step("Нажать \"Добавить в корзину\" у товара \"Огурцы гладкие\"")
    public CatalogPage clickToCartSmoothCucumbers() {
        emulatorActions.verticalSwipe
                (
                        0.5,
                        0.5,
                        0.47,
                        200
                );
        smoothCucumbersToCart.should(Condition.visible).click();
        return this;
    }

    @Step("Изменить адрес доставки для правильного отображения подсказок")
    public CatalogPage changeDeliveryAddress() {
        emulatorActions.setLocation(55.7178836, 37.4159348);
        $(AppiumBy.xpath("//*[@resource-id='ru.vkusvill:id/iv_address']")).should(Condition.visible).click();
        $(AppiumBy.xpath("//*[@resource-id='ru.vkusvill:id/iv_map_location']")).should(Condition.visible).click();
        $(AppiumBy.xpath("//*[@resource-id='ru.vkusvill:id/btn_select']")).should(Condition.visible).click();
        $(AppiumBy.xpath("//*[@resource-id='ru.vkusvill:id/button_rules_ok']")).should(Condition.visible).click();
        return this;
    }

    @Step("Написать \"Молоко\"")
    public CatalogPage writeMilkText() {
        findProductsFieldAfterClick.should(Condition.visible).sendKeys("Молоко");
        emulatorActions.hideKeyBd();
        return this;
    }

    @Step("Отображение 3 категорий молока")
    public CatalogPage milkCategoriesDisplaying() {
        Assertions.assertEquals(3, searchCategoriesSuggestionsTitle.size());
        Assertions.assertEquals(3, searchCategoriesSuggestionsSubtitle.size());
        return this;
    }

    @Step("Получение отображённых категорий")
    public Set<String> getDisplayedCategories() {
        HashSet<String> strings = new HashSet<>();
        for (SelenideElement element : searchCategoriesSuggestionsTitle) {
            strings.add(element.getText());
        }
        for (SelenideElement element : searchCategoriesSuggestionsSubtitle) {
            strings.add(element.getText());
        }
        return strings;
    }

    @Step("Написать \"Букет\"")
    public CatalogPage writeFlavorText() {
        findProductsFieldAfterClick.should(Condition.visible).sendKeys("Букет");
        emulatorActions.hideKeyBd();
        return this;
    }

    @Step("Отображение 2 категорий букета")
    public CatalogPage flavorCategoriesDisplaying() {
        Assertions.assertEquals(2, searchCategoriesSuggestionsTitle.size());
        Assertions.assertEquals(2, searchCategoriesSuggestionsSubtitle.size());
        return this;
    }

    @Step("Старые и новые категории не должны пересекаться")
    public void checkOldAndNewCategories(Set<String> categories1, Set<String> categories2) {
//        Assertions.assertTrue(
//                CollectionUtils.intersection(categories1, categories2).isEmpty()
//        );
    }

    @Step("Положить первый найденный товар (молоко) в корзину")
    public String clickToCartFirstItemInSearch() {
        addToCartFromSearchTitle.should(Condition.visible);
        String firstItemName = addToCartFromSearchTitle.text();
        Assertions.assertTrue(firstItemName.toLowerCase().contains("молоко"));
        addToCartFromSearch.should(Condition.visible).click();
        addToCartFromSearchQuantity.should(Condition.visible);
        return firstItemName.substring(0, firstItemName.lastIndexOf(','));
    }

    @Step("Указать адрес (при необходимости)")
    public CatalogPage setDeliveryAddressIfNeed() {
        if (inputAddressButton.is(Condition.visible)) {
            inputAddressButton
                    .click();
            myAddressesButton
                    .should(Condition.visible)
                    .click();
            firstAddressInList
                    .should(Condition.visible)
                    .click();
            chooseAddressButton
                    .should(Condition.visible)
                    .click();
            chooseAddressButton2
                    .should(Condition.visible)
                    .click();
            itsClearButton
                    .should(Condition.visible)
                    .click();
        }
        return this;
    }

    @Step("Положить первый популярный товар в корзину")
    public String clickToCartFirstItemInPopular() {
        catalogPageElements[10].should(Condition.visible);
        emulatorActions.verticalSwipeToFindElement(
            0.6, 0.5,0.57,
            firstItemInPopularElements[5],
            5,
            "Button not found"
        );
        for (SelenideElement element : firstItemInPopularElements) {
            element.should(Condition.visible);
        }
        firstItemName = firstItemInPopularElements[1].getText();
        firstItemInPopularElements[5].click();
        cartWidgetDisplaying();
        cartWidgetClick();
        return firstItemName;
    }

    @Step("Положить первый популярный товар в избранное")
    public String clickToFavoriteFirstItemInPopular() {
        popularHeader.should(Condition.visible);
        emulatorActions.verticalSwipeToFindElement(
            0.6, 0.01, 0.57,
            firstItemInPopularElements[5],
            5,
            "Button not found"
        );
        for (SelenideElement element : firstItemInPopularElements) {
            element.should(Condition.visible);
        }
        String itemName = firstItemInPopularName.getText();
        firstItemInPopularElements[2].click();
        return itemName;
    }

    @Step("Отображение первого популярного товара в избранных")
    public CatalogPage itemInFavoritesDisplaying(String addedItemName) {
        popularHeader.should(Condition.hidden);
        Assertions.assertEquals(addedItemName, firstPopularItemNameInFavorites.getText());
        return this;
    }

    @Step("Открыть/закрыть список избранного")
    public CatalogPage clickToOpenCloseFavouriteList() {
        showFavoriteButton.should(Condition.visible).click();
        return this;
    }

    @Step("Удалить все товары из избранного")
    public CatalogPage clickToDeleteAllItemsFromFavorite() {
        popularHeader.should(Condition.hidden);
        for (SelenideElement element : allItemInPopularRemoveFromList) {
            element.click();
        }
        return this;
    }

    @Step("Отображение виджета корзины")
    public CatalogPage cartWidgetDisplaying() {
        for (SelenideElement element : cartWidgetElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Кликнуть на виджет корзины")
    public CatalogPage cartWidgetClick() {
        cartWidget.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение товара первого популярного товара в корзине")
    public CatalogPage firstPopularItemDisplayedInCart() {
        Assertions.assertTrue(
                (
                        firstPopularItemInCartTitle.is(Condition.visible)
                ));
        return this;
    }

    @Step("Добавить первый популярный товар в список")
    public String addToListFirstPopularItem() {
        popularHeader.should(Condition.visible);
        emulatorActions.verticalSwipeToFindElement(
            0.6, 0.01, 0.57,
            firstItemInPopularElements[5], 5, "Button not found"
        );
        for (SelenideElement element : firstItemInPopularElements) {
            element.should(Condition.visible);
        }
        String itemName = firstItemInPopularName.getText();
        firstItemInPopularAddToList.should(Condition.visible).click();

        for (SelenideElement element : addToListWindowElements) {
            element.should(Condition.visible);
        }
        String addedItemName = addToListWindowItemName.text();
        Assertions.assertTrue(itemName.startsWith(addedItemName));
        addToListAddButton.click();

        return addedItemName;
    }

    @Step("Открыть первый популярный товар")
    public CatalogPage clickToOpenFirstItemInPopular() {
        emulatorActions.verticalSwipeToFindElement
                (
                        0.6,
                        0.01,
                        0.57,
                        firstItemInPopularLabel,
                        10
                );
        firstItemInPopularLabel.click();
        return this;
    }

    @Step("Отображение элементов страницы товара")
    public CatalogPage productPageElementsDisplaying() {
        productBackButton.should(Condition.visible);
        productShareButton.should(Condition.visible);
        productFavoriteButton.should(Condition.visible);
        productImage.should(Condition.visible);
        productImageRating.should(Condition.visible);
        productTitle.should(Condition.visible);
        productWeight.should(Condition.visible);
        productPrice.should(Condition.visible);
        productReview.should(Condition.visible);
        productCartIcon.should(Condition.visible);
        productCartButton.should(Condition.visible);
        productFavoriteIcon.should(Condition.visible);
        productFavoriteButton2.should(Condition.visible);

        emulatorActions.verticalSwipeToFindElement(0.6, 0.5, 0.4, productManufacturer, 5);
        emulatorActions.verticalSwipeToFindElement(0.6, 0.5, 0.4, productExpiry, 5);
        emulatorActions.verticalSwipeToFindElement(0.6, 0.5, 0.4, productDesc, 5);
        emulatorActions.verticalSwipeToFindElement(0.6, 0.5, 0.4, productReviews, 5);

        return this;
    }

    @Step("Открыть категорию \"Хиты\"")
    public CatalogPage clickToOpenHitsCategory() {
        recommendedHeader.should(Condition.visible);
        emulatorActions.verticalSwipeToFindElement(0.55, 0.5, 0.5, categoryHits, 10);
        categoryHits.click();
        return this;
    }

    @Step("Открыть рекомендацию \"История покупок\"")
    public CatalogPage clickToOpenHistoryRecommendation() {
        recommendedHeader.should(Condition.visible);
        recommendationHistory.click();
        return this;
    }

    @Step("Отображение истории без покупок")
    public CatalogPage historyWithoutPurchasesDisplaying() {
        historyBackButton.should(Condition.visible);
        historyTitle.should(Condition.visible);
        historySortingButton.should(Condition.visible);
        historySearchInput.should(Condition.visible);
        historySearchBarcode.should(Condition.visible);
        historySettingsButton.should(Condition.visible);
        historyProduct.should(Condition.disappear);
        return this;
    }

    @Step("Отображение элементы страницы категории")
    public CatalogPage categoryPageElementsDisplaying() {
        categoryBackButton.should(Condition.visible);
        categoryTitle.should(Condition.visible);
        categorySearch.should(Condition.visible);
        categoryBarcode.should(Condition.visible);
        categoryFilter.should(Condition.visible);
        categoryAllProducts.should(Condition.visible);

        Assertions.assertTrue(categorySubcategories.size() > 5);

        return this;
    }

    private List<Integer> getSearchResultPrices() {
        List<Integer> prices = new LinkedList<>();

        for (SelenideElement priceElement : searchPrices) {
            String priceText = priceElement.getText();
            priceText = priceText.replaceAll("[^0-9]", "");
            int price = Integer.parseInt(priceText);
            prices.add(price);
        }

        return prices;
    }

    @Step("Изначальное отображение блока поиска в разделе \"Каталог\"")
    public CatalogPage initialSearchBlockDisplaying() {
        findProductsFieldPlaceholder.should(Condition.visible);
        barCodeButton.should(Condition.visible);
        filterButton.should(Condition.visible);
        showFavoriteButton.should(Condition.visible);

        return this;
    }

    @Step("Изначальное отображение блока \"Рекомендуем\" в разделе \"Каталог\"")
    public CatalogPage initialRecommendedBlockDisplaying() {
        recommendedHeader.should(Condition.visible);
        recommendationItems.shouldBe(CollectionCondition.sizeGreaterThan(1));

        for (SelenideElement item : recommendationItems) {
            SelenideElement image = item.$(By.id("ru.vkusvill:id/iv"));
            SelenideElement title = item.$(By.id("ru.vkusvill:id/tv"));

            image.should(Condition.visible);
            title.should(Condition.visible);
        }

        return this;
    }

    @Step("Изначальное отображение блока \"Популярное\" в разделе \"Каталог\"")
    public CatalogPage initialPopularBlockDisplaying() {
        popularHeader.should(Condition.visible);
        popularItems.shouldBe(CollectionCondition.sizeGreaterThan(1));

        var item = popularItems.get(0);
        SelenideElement image = item.$(By.id("ru.vkusvill:id/imageView"));
        // SelenideElement addToFavoriteButton = item.$(By.id("ru.vkusvill:id/iv_chosen"));
        SelenideElement rating = item.$(By.id("ru.vkusvill:id/tv_rating"));
        SelenideElement addToListButton = item.$(By.id("ru.vkusvill:id/iv_basket"));
        SelenideElement title = item.$(By.id("ru.vkusvill:id/textView_title"));
        SelenideElement price = item.$(By.id("ru.vkusvill:id/vPrice"));
        SelenideElement cartButton = item.$(By.id("ru.vkusvill:id/rl_cart"));

        image.should(Condition.visible);
        // addToFavoriteButton.should(Condition.visible);
        rating.should(Condition.visible);
        addToListButton.should(Condition.visible);
        title.should(Condition.visible);
        price.should(Condition.visible);
        cartButton.should(Condition.visible);

        return this;
    }

    @Step("Изначальное отображение блока \"Категории\" в разделе \"Каталог\"")
    public CatalogPage initialCategoryBlockDisplaying() {
        emulatorActions.verticalSwipeToFindElement(0.55, 0.5, 0.4, categoriesHeader, 10);
        emulatorActions.verticalSwipe(0.7, 0.5, 0.6, 500);
        categoriesItems.shouldBe(CollectionCondition.sizeGreaterThan(1));

        for (SelenideElement item : categoriesItems) {
            SelenideElement image = item.$(By.id("ru.vkusvill:id/iv"));
            SelenideElement title = item.$(By.id("ru.vkusvill:id/tv"));

            image.should(Condition.visible);
            title.should(Condition.visible);
        }

        return this;
    }

    @Step("Вернуться назад")
    public CatalogPage clickBack() {
        categoryBackButton.should(Condition.visible).click();
        return this;
    }

    @Step("Проверка наличия товара в избранном")
    public CatalogPage checkProductExistingInFavorites(String productName, boolean remove) {
        favoriteItems.should(CollectionCondition.sizeGreaterThanOrEqual(1));

        for (var item : favoriteItems) {
            var name = item.$x(".//*[@resource-id='ru.vkusvill:id/textView_title']").should(Condition.visible).text();

            if (name.equals(productName)) {
                if (remove) {
                    item.$x(".//*[@resource-id='ru.vkusvill:id/iv_chosen']").should(Condition.visible).click();
                }
                return this;
            }
        }

        throw new RuntimeException("В избранном нет товара с названием " + productName);
    }

}
