package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import driver.EmulatorActions;

import java.util.HashSet;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;

// Поддержка
public class SupportPage {

    EmulatorActions emulatorActions = new EmulatorActions();

    private SelenideElement supportButton = $(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Поддержка\"]"));
    private SelenideElement title = $(AppiumBy.xpath("//*[@text='Поддержка']"));
    private SelenideElement weLoveToCommunicateHeader = $(AppiumBy.xpath("//*[@text='Мы любим общаться']"));
    private SelenideElement chatTab = $(AppiumBy.xpath("//*[@text='Чат']"));
    private SelenideElement phoneTab = $(AppiumBy.xpath("//*[@text='Телефон']"));
    private SelenideElement mailTab = $(AppiumBy.xpath("//*[@text='Почта']"));
    private SelenideElement vkButton = $(AppiumBy.xpath("//android.widget.RelativeLayout[1]"));
    private SelenideElement youTubeButton = $(AppiumBy.xpath("//android.widget.RelativeLayout[2]"));
    private SelenideElement telegramButton = $(AppiumBy.xpath("//android.widget.RelativeLayout[3]"));
    private SelenideElement tikTokButton = $(AppiumBy.xpath("//android.widget.RelativeLayout[4]"));
    private SelenideElement whatsUpButton = $(AppiumBy.xpath("//android.widget.RelativeLayout[5]"));
    private SelenideElement referenceHeader = $(AppiumBy.xpath("//*[@text='Справка']"));
    private SelenideElement fAQHeader = $(AppiumBy.xpath("//*[@text='Часто задаваемые вопросы']"));
    private SelenideElement howKnowStatusMyOrderTitle = $(AppiumBy.xpath("//*[@text='Как узнать статус моего заказа?']"));
    private SelenideElement howMakeOrderByPhone = $(AppiumBy.xpath("//*[@text='Как сделать заказ по телефону?']"));

    private SelenideElement[] supportElements1 = {
            supportButton,
            title,
            weLoveToCommunicateHeader,
            chatTab,
            phoneTab,
            mailTab,
            vkButton,
            youTubeButton,
            telegramButton,
            tikTokButton,
            whatsUpButton,
            referenceHeader,
            fAQHeader,
            howKnowStatusMyOrderTitle,
            howMakeOrderByPhone,
    };

    private SelenideElement helpList = $(AppiumBy.id("ru.vkusvill:id/rv_categories"));
    private By helpItemBy = AppiumBy.id("ru.vkusvill:id/sl");
    private By helpItemTitleBy = AppiumBy.id("ru.vkusvill:id/tv_title");
    private By helpItemDescBy = AppiumBy.id("ru.vkusvill:id/tv_desc");

    private Pair<String, String>[] requiredHelpItems = new Pair[]{
            Pair.of("Доставка", "Бесплатно привезём вкусные и полезные продукты"),
            Pair.of("Самовывоз", "Оформите онлайн и заберите готовый заказ в магазине"),
            Pair.of("Оплата", "Всё про оплаты, возвраты и чаевые"),
            Pair.of("Каталог", "Поиск, фильтры и оценки товаров"),
            Pair.of("Корзина", "Ассортимент и настройки заказа"),
            Pair.of("Программа лояльности Давайте дружить", "Всё о наших акциях и бонусах"),
            Pair.of("ВкусВилл Праздник", "Кейтеринг, торты и подарки"),
            Pair.of("ВкусВилл План", "План питания и продукты"),//+
            Pair.of("ВкусВилл для бизнеса", "Откройте B2B профиль и работайте с нами"),
            Pair.of("Рекомендуйте и зарабатывайте!", "Получайте 10% в течение 90 дней"),
            Pair.of("Доставка по всей России", "Привезем напрямую со склада ВкусВилла"),
            Pair.of("Экология", "Наши проекты и экодостижения"),
            Pair.of("Добрые покупки", "Благотворительность доступна каждому"),
            Pair.of("Подписаться на рассылку", "Получайте информацию о товарах, скидках и акциях"),
            Pair.of("Вакансии", "Для тех, кто разделяет наши ценности"),
            Pair.of("Публичная оферта", "Здесь важная юридическая информация"),
    };

    private By buildVersionBy = AppiumBy.id("ru.vkusvill:id/tv_version");
    private SelenideElement buildVersion = $(buildVersionBy);

    @Step("Отображение иконки \"Поддержка\"")
    public SupportPage supportIconDisplaying() {
        supportElements1[0].should(Condition.visible);
        return this;
    }

    @Step("Кликнуть иконку \"Поддержка\"")
    public SupportPage clickSupportIcon() {
        supportElements1[0].click();
        return this;
    }

    @Step("Отображение элементов страницы \"Поддержка\"")
    public SupportPage elementsDisplaying() {
        for (SelenideElement element : supportElements1) {
            element.should(Condition.visible);
        }

        Set<Pair<String, String>> actualHelpItems = new HashSet<>();

        //листать экрна вниз до элемента с номером версии и попутно читать элементы помощи
        //максимум 20 раз
        for (int i = 0; i < 20; i++) {
            emulatorActions.verticalSwipe(
                    0.55,
                    0.5,
                    0.4,
                    200
            );

            for (SelenideElement helpItem : helpList.$$(helpItemBy)) {
                SelenideElement titleElement = helpItem.$(helpItemTitleBy);
                SelenideElement descElement = helpItem.$(helpItemDescBy);
                if (titleElement.isDisplayed() && descElement.isDisplayed()) {
                    String title = titleElement.text();
                    String desc = descElement.text();
                    actualHelpItems.add(Pair.of(title, desc));
                }
            }

            if (buildVersion.isDisplayed()) {
                break;
            }
        }

        //убедиться что все элементы найдены на экране
        for (Pair<String, String> requiredHelpItem : requiredHelpItems) {
            if (!actualHelpItems.contains(requiredHelpItem)) {
                throw new RuntimeException("Элемент \"" + requiredHelpItem.getLeft() + " / " + requiredHelpItem.getRight() + "\" не найден в списке справки");
            }
        }

        if (requiredHelpItems.length != actualHelpItems.size()) {
            throw new RuntimeException("В справке находится лишний элемент");
        }

        buildVersion.should(Condition.visible);

        return this;
    }
}