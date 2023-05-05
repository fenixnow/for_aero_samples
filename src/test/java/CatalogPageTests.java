import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CatalogPage;
import pages.MainPage;

import java.util.Set;

public class CatalogPageTests extends BaseTest {

    private static MainPage mainPage;
    private static CatalogPage catalogPage;
    private static CartPage cartPage;

    @BeforeAll
    public static void init() {
        mainPage = new MainPage();
        catalogPage = new CatalogPage();
        cartPage = new CartPage();
    }

    @Test
    @Description("Поиск товара \"Огурцы гладкие\"")
    @Owner("Марк Серегин")
    @Story("Тесты примеры")
    @DisplayName("Поиск товара по ключевым словам")
    public void searchSpecificProduct() {
        mainPage
                .fastLogin(testPhone2, testCode);
        catalogPage
                .catalogIconClick()
                .findProductsFieldClick()
                .writeSmoothCucumbersText()
                .smoothCucumbersDisplaying();
    }

    @Test
    @Description("Сортировка в поиске")
    @Story("Тесты примеры")
    @DisplayName("Проверка сортировки поисковых результатов")
    public void searchWithSorting() {
        mainPage.login();

        catalogPage.catalogIconClick()
                .findProductsFieldClick()
                .writeSmoothCucumbersText()
                .searchSortingClick()
                .searchResultDescendingDisplaying()
                .searchSortingClick()
                .searchResultAscendingDisplaying();
    }


    @Test
    @Description("Категории в поиске")
    @Owner("Марк Серегин")
    @Story("Тесты примеры")
    @DisplayName("Проверка категорий в поиске по каталогу")
    public void checkingSearch() {
        mainPage
                .fastLogin(testPhone2, testCode);
        catalogPage
                .catalogIconClick()
                .changeDeliveryAddress()
                .findProductsFieldClick()
                .writeMilkText()
                .milkCategoriesDisplaying();

        Set<String> categories1 = catalogPage.getDisplayedCategories();

        catalogPage
                .writeFlavorText()
                .flavorCategoriesDisplaying();

        Set<String> categories2 = catalogPage.getDisplayedCategories();

        catalogPage.checkOldAndNewCategories(categories1, categories2);
    }

    @Test
    @Description("Добавление найденного товара в поиске в корзину")
    @Owner("Марк Серегин")
    @Story("Тесты примеры")
    @DisplayName("Добавление найденного товара в корзину")
    public void checkingAddItemToBasketFromSearch() {
        mainPage
                .fastLogin(testPhone2, testCode);
        catalogPage
                .catalogIconClick()
                .findProductsFieldClick()
                .writeMilkText();
        String addedItem = catalogPage
                .clickToCartFirstItemInSearch();
        catalogPage
                .cartWidgetClick();
        cartPage
                .checkProductExisting(addedItem)
                .clickToDeleteAllItemsFromCart();
    }

    @Test
    @Description("Проверка добавления первого популярного товара в корзину")
    @Owner("Марк Серегин")
    @Story("Тесты примеры")
    @DisplayName("Добавление товара в корзину")
    public void checkingAddItemToBasket() {
        mainPage
                .fastLogin(testPhone2, testCode);
        catalogPage
                .catalogIconClick()
                .setDeliveryAddressIfNeed()
                .clickToCartFirstItemInPopular();
        catalogPage
                .firstPopularItemDisplayedInCart();
        cartPage
                .clickToDeleteAllItemsFromCart();
    }

    @Test
    @Description("Добавление товара в избранное")
    @Owner("Марк Серегин")
    @Story("Тесты примеры")
    @DisplayName("Проверка добавления первого популярного товара в избранное")
    public void checkingAddItemToFavorite() {
        mainPage
                .fastLogin(testPhone2, testCode);
        String addedItem = catalogPage
                .catalogIconClick()
                .clickToOpenCloseFavouriteList()
                .clickToDeleteAllItemsFromFavorite()
                .clickToOpenCloseFavouriteList()
                .clickToFavoriteFirstItemInPopular();
        catalogPage
                .clickToOpenCloseFavouriteList()
                .itemInFavoritesDisplaying(addedItem);
    }

    @Test
    @Description("Добавление товара в список")
    @Owner("Марк Серегин")
    @Story("Тесты примеры")
    @DisplayName("Проверка добавления первого популярного товара в список")
    public void checkingAddItemToList() {
        mainPage
                .fastLogin(testPhone2, testCode);
        String addedItem = catalogPage
                .catalogIconClick()
                .addToListFirstPopularItem();
        //TODO: проверить наличиие элемента в списке
    }

    @Test
    @Description("Проверка открытия детальной страницы товара")
    @DisplayName("Проверка страницы товара")
    public void checkingProductPage() {
        mainPage
                .fastLogin(testPhone2, testCode);
        catalogPage
                .catalogIconClick()
                .clickToOpenFirstItemInPopular()
                .productPageElementsDisplaying();
    }

    @Test
    @Description("Отображение списка подкатегорий выбранной категории")
    @DisplayName("Отображение списка подкатегорий выбранной категории")
    public void checkingSubCategoryPage() {
        mainPage
                .fastLogin(testPhone2, testCode);
        catalogPage
                .catalogIconClick()
                .clickToOpenHitsCategory()
                .categoryPageElementsDisplaying();
    }

    @Test
    @Description("Проверка поиска товара в открытой категории")
    @DisplayName("Проверка поиска товара в открытой категории")
    public void checkingSearchInCategory() {
        mainPage
                .fastLogin(testPhone2, testCode);
        catalogPage
                .catalogIconClick()
                .clickToOpenHitsCategory()
                .findProductsFieldClick()
                .writeSmoothCucumbersText()
                .smoothCucumbersDisplaying();
    }

    @Test
    @Description("История покупок без истории")
    @DisplayName("История покупок без истории")
    public void checkingHistoryWithoutPurchases() {
        mainPage
                .fastLogin(testPhone2, testCode);
        catalogPage
                .catalogIconClick()
                .clickToOpenHistoryRecommendation()
                .historyWithoutPurchasesDisplaying();
    }

    @Test
    @Description("Изначальное отображение блока поиска в разделе \"Каталог\"")
    @DisplayName("Изначальное отображение блока поиска в разделе \"Каталог\"")
    public void checkingInitialSearchBlock() {
        mainPage
                .fastLogin(testPhone2, testCode);
        catalogPage
                .catalogIconClick()
                .initialSearchBlockDisplaying();
    }

    @Test
    @Description("Изначальное отображение блока \"Рекомендуем\" в разделе \"Каталог\"")
    @DisplayName("Изначальное отображение блока \"Рекомендуем\" в разделе \"Каталог\"")
    public void checkingInitialRecommendedBlock() {
        mainPage
                .fastLogin(testPhone2, testCode);
        catalogPage
                .catalogIconClick()
                .initialRecommendedBlockDisplaying();
    }

    @Test
    @Description("Изначальное отображение блока \"Популярное\" в разделе \"Каталог\"")
    @DisplayName("Изначальное отображение блока \"Популярное\" в разделе \"Каталог\"")
    public void checkingInitialPopularBlock() {
        mainPage
                .fastLogin(testPhone2, testCode);
        catalogPage
                .catalogIconClick()
                .initialPopularBlockDisplaying();
    }

    @Test
    @Description("Изначальное отображение блока \"Категории\" в разделе \"Каталог\"")
    @DisplayName("Изначальное отображение блока \"Категории\" в разделе \"Каталог\"")
    public void checkingInitialCategoryBlock() {
        mainPage
                .fastLogin(testPhone2, testCode);
        catalogPage
                .catalogIconClick()
                .initialCategoryBlockDisplaying();
    }


}
