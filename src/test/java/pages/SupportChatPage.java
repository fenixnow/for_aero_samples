package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SupportChatPage {

    private SelenideElement supportLink = $(MobileBy.xpath("//*[@text='Проблемы со входом? Будем рады помочь в чате.']"));
    private SelenideElement backButton = $(MobileBy.xpath("(//android.widget.ImageButton[@content-desc=\"Перейти вверх\"])"));
    private SelenideElement chatTitle = $(MobileBy.xpath("//*[@text='Написать ВВ']"));
    private SelenideElement supportAutoMessage = $(MobileBy.xpath("//*[@text='Задайте вопрос специалисту поддержки.']"));
    private SelenideElement attachFileButton = $(MobileBy.id("ru.vkusvill:id/imageView_file"));
    private SelenideElement inputMessageField = $(MobileBy.xpath("//*[@text='Сообщение..']"));
    private SelenideElement sendMessageButton = $(MobileBy.id("ru.vkusvill:id/button_input"));
    private SelenideElement sentMessage = $(MobileBy.xpath("//*[@text='Здравствуйте']"));
    private SelenideElement supportMessageModalOkButton = $(MobileBy.xpath("//*[@text='OK']"));
    private SelenideElement supportMessageModal = $(MobileBy.xpath("//*[@text='Мы получили ваше обращение и уже занимаемся поиском свободного оператора. \n" +
            "Пожалуйста, ожидайте. \n" +
            "Чат поддержки работает для вас круглосуточно и без выходных.']"));

    private SelenideElement[] chatPageElements = {
            backButton,
            chatTitle,
            supportAutoMessage,
            attachFileButton,
            inputMessageField,
            sendMessageButton
    };

    @Step("Вызываем страницу чата на странице ввода смс-кода")
    public SupportChatPage supportLinkClick () {
        supportLink.should(Condition.visible).click();
        return this;
    }

    @Step("Отображение элементов страницы чата поддержки")
    public SupportChatPage chatPageElementsDisplaying () {
        for (SelenideElement element: chatPageElements) {
            element.should(Condition.visible);
        }
        return this;
    }

    @Step("Нажимаем кнопку назад в чате")
    public SupportChatPage clickBackButton () {
        chatPageElements[0].should(Condition.visible).click();
        return this;
    }

    @Step("Отправка сообщения в чате поддержки")
    public SupportChatPage sendMessageInSupportChat() {
        chatPageElements[4].sendKeys("Здравствуйте");
        chatPageElements[5].should(Condition.visible).click();
        return this;
    }

    @Step("Принимаем сообщение от поддержки, нажав \"ОК\" и проверяем наше сообщение")
    public SupportChatPage confirmMessageAndCheckSentMessage () {
        supportMessageModal.should(Condition.visible);
        supportMessageModalOkButton.should(Condition.visible).click();
        sentMessage.should(Condition.visible);
        return this;
    }
}
