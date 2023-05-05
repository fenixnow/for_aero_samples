package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import driver.EmulatorActions;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    EmulatorActions emulatorActions = new EmulatorActions();

    /**
     * Заголовок
     */
    private final SelenideElement backButton = $x("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]");
    private final SelenideElement shareButton = $(By.id("ru.vkusvill:id/menu_product_share"));
    private final SelenideElement addToFavoriteButton = $(By.id("ru.vkusvill:id/menu_product_fav"));

    /**
     * Информация
     */
    private final SelenideElement image = $(By.id("ru.vkusvill:id/bg"));
    private final SelenideElement rating = $x("//*[@resource-id='ru.vkusvill:id/llListProductInfo']//*[@resource-id='ru.vkusvill:id/tv_rating']");
    private final SelenideElement productTitle = $(By.id("ru.vkusvill:id/tv_title"));

    /**
     * Действия
     */
    private final SelenideElement addToCartButton = $(By.id("ru.vkusvill:id/iv_product_add"));
    private final SelenideElement chooseLpButton = $(By.id("ru.vkusvill:id/iv_product_lp"));
    private final SelenideElement addToListButton = $(By.id("ru.vkusvill:id/iv_product_basket"));

    /**
     * Отзывы
     */
    private final SelenideElement allReviewsButton = $(By.id("ru.vkusvill:id/llListProductReviewAll"));

    /**
     * Корзина
     */
    private final SelenideElement cart = $(By.id("ru.vkusvill:id/cartWidget"));

    /**
     * Фотография на весь экран
     */
    private final SelenideElement fullscreenImageContainer = $x("//*[@resource-id='ru.vkusvill:id/container']/*[4]");
    private final SelenideElement fullScreenImageCloseButton = fullscreenImageContainer.$(By.id("ru.vkusvill:id/ivClose"));
    private final SelenideElement fullscreenImage = fullscreenImageContainer.$(By.id("ru.vkusvill:id/imageView"));
    private final ElementsCollection fullscreenImageItems = fullscreenImageContainer.$$x(".//*[@resource-id='ru.vkusvill:id/rvPreview']/*");

    /**
     * Сообщения поверх экрана
     */
    private final SelenideElement toastIcon = $(By.id("ru.vkusvill:id/imageView_toast1"));
    private final SelenideElement toastText = $(By.id("ru.vkusvill:id/tv_toast"));

    /**
     * Страница отзывы
     */
    private final SelenideElement reviewsTitle = $x("//*[@text='Отзывы']");
    private final SelenideElement reviewsCbAll = $(By.id("ru.vkusvill:id/cb_rating_all"));
    private final SelenideElement reviewsCbAllText = $(By.id("ru.vkusvill:id/textView_rating"));
    private final SelenideElement reviewsCb5 = $(By.id("ru.vkusvill:id/cb_rating_5"));
    private final SelenideElement reviewsCb5Text = $x("//*[@resource-id='ru.vkusvill:id/ll_rating_5']//*[@text='Супер']");
    private final SelenideElement reviewsCb4 = $(By.id("ru.vkusvill:id/cb_rating_4"));
    private final SelenideElement reviewsCb4Text = $x("//*[@resource-id='ru.vkusvill:id/ll_rating_4']//*[@text='Хорошо']");
    private final SelenideElement reviewsCb3 = $(By.id("ru.vkusvill:id/cb_rating_3"));
    private final SelenideElement reviewsCb3Text = $x("//*[@resource-id='ru.vkusvill:id/ll_rating_3']//*[@text='Приемлемо']");
    private final SelenideElement reviewsCb2 = $(By.id("ru.vkusvill:id/cb_rating_2"));
    private final SelenideElement reviewsCb2Text = $x("//*[@resource-id='ru.vkusvill:id/ll_rating_2']//*[@text='Можно лучше']");
    private final SelenideElement reviewsCb1 = $(By.id("ru.vkusvill:id/cb_rating_1"));
    private final SelenideElement reviewsCb1Text = $x("//*[@resource-id='ru.vkusvill:id/ll_rating_1']//*[@text='Ужасно']");
    private final SelenideElement reviewsManufacturerTitle = $x("//*[@text='Производитель']");
    private final ElementsCollection reviewsManufacturerItems = $$x("//*[@resource-id='ru.vkusvill:id/rv']//*[@resource-id='ru.vkusvill:id/recyclerView']/*");
    private final SelenideElement reviewsManufacturerAllItemText = reviewsManufacturerItems.get(0).$x(".//*[@text='Все']");

    /**
     * Всплывающее окно поделиться
     */
    private final SelenideElement popupShare = $(By.id("android:id/contentPanel"));

    @Step("Отображение картинки")
    public ProductPage imageDisplaying() {
        image.should(Condition.visible);
        return this;
    }

    @Step("Кликнуть на картинку")
    public ProductPage clickImage() {
        image.should(Condition.visible).click();
        return this;
    }

    @Step("Пролистать картинку влево")
    public ProductPage swipeLeftImage() {
        emulatorActions.horizontalSwipe(0.8, 0.2, 0.2, 200);
        return this;
    }

    @Step("Пролистать картинку вправо")
    public ProductPage swipeRightImage() {
        emulatorActions.horizontalSwipe(0.2, 0.2, 0.8, 200);
        return this;
    }

    @Step("Закрыть полноэкранную картинку")
    public ProductPage closeFullscreenImage() {
        fullScreenImageCloseButton.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение выбранной картинки")
    public ProductPage fullScreenImageDisplaying(int index) {
        fullscreenImage.should(Condition.visible);
        fullscreenImageItems.should(CollectionCondition.sizeGreaterThan(index));
        var currentIndex = 0;
        for (var item : fullscreenImageItems) {
            var selectedView = item.$(By.id("ru.vkusvill:id/chosenView"));
            if (currentIndex == index) {
                selectedView.should(Condition.visible);
            } else {
                selectedView.should(Condition.disappear);
            }
            currentIndex++;
        }
        return this;
    }

    @Step("Кликнуть на корзину")
    public ProductPage clickCart() {
        cart.should(Condition.visible).click();
        return this;
    }
    
    @Step("Добавить в корзину")
    public ProductPage clickAddToCart() {
        addToCartButton.should(Condition.visible).click();
        return this;
    }

    @Step("Добавить в избранное")
    public ProductPage clickAddToFavorite() {
        addToFavoriteButton.should(Condition.visible).click();
        return this;
    }

    @Step("Выбрать любимым")
    public ProductPage clickChooseLp() {
        chooseLpButton.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение сообщения \"Купите на 500 ₽ и выберите Любимый продукт со скидкой 20%\"")
    public ProductPage toastNegativeChooseLpDisplaying() {
        toastIcon.should(Condition.visible);
        toastText
                .should(Condition.visible)
                .shouldHave(Condition.text("Купите на 500 ₽ и выберите Любимый продукт со скидкой 20%"));

        return this;
    }

    @Step("Поделиться")
    public ProductPage clickShare() {
        shareButton.should(Condition.visible).click();
        return this;
    }

    @Step("Кликнуть на рейтинг")
    public ProductPage clickRating() {
        rating.should(Condition.visible).click();
        return this;
    }

    @Step("Кликнуть на кнопку все отзывы")
    public ProductPage clickAllReviews() {
        emulatorActions.verticalSwipeToFindElement(0.8, 0.5, 0.2, allReviewsButton, 10);
        allReviewsButton.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение страницы отзывов товара")
    public ProductPage reviewsPageDisplaying() {
        reviewsTitle.should(Condition.visible);
        reviewsCbAll.should(Condition.visible);

        reviewsCbAllText.should(Condition.visible).shouldHave(Condition.not(Condition.exactText("")));
        reviewsCb5.should(Condition.visible);
        reviewsCb5Text.should(Condition.visible);
        reviewsCb4.should(Condition.visible);
        reviewsCb4Text.should(Condition.visible);
        reviewsCb3.should(Condition.visible);
        reviewsCb3Text.should(Condition.visible);
        reviewsCb2.should(Condition.visible);
        reviewsCb2Text.should(Condition.visible);
        reviewsCb1.should(Condition.visible);
        reviewsCb1Text.should(Condition.visible);
        reviewsManufacturerTitle.should(Condition.visible);
        reviewsManufacturerItems.should(CollectionCondition.sizeGreaterThanOrEqual(1));
        reviewsManufacturerAllItemText.should(Condition.visible);
        return this;
    }

    @Step("Отображение всплывающего окна \"Поделиться\"")
    public ProductPage popupShareDisplaying() {
        popupShare.should(Condition.visible);
        return this;
    }

    @Step("Вернуться назад")
    public ProductPage clickBack() {
        backButton.should(Condition.visible).click();
        return this;
    }

    public String getProductName() {
        return productTitle.should(Condition.visible).getText();
    }

}
