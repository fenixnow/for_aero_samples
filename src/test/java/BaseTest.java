import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import config.ConfigReader;
import helper.RunHelper;

import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

/**
 * Базовый тестовый класс, расширяем тестовый класс
 */
public class BaseTest {

    private static final Boolean enableVideo = ConfigReader.emulatorConfig.enableVideo();

    public String testPhone2 = "8889995555";
    public String testCode = "100500";
    public SelenideElement appUpdateWindowTitle = $(AppiumBy.xpath("//*[@text='Обновите сервисы Google Play']"));


    @BeforeAll
    public static void setup() {

        Configuration.browser = RunHelper.runHelper().getDriverClass().getName(); //инициализируем андройд драйвер
        Configuration.browserSize = null;
        Configuration.timeout = 15000;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;

        SelenideLogger.addListener("AllureListener", new AllureSelenide().savePageSource(false));
    }

    /**
     * Перед каждым тестом открываем приложение
     */
    @BeforeEach
    public void startDriver() {
//        step("Открыть приложение", (Allure.ThrowableRunnableVoid) Selenide::open);
        step("Открыть приложение", SelenideAppium::launchApp);
    }

    /**
     * После каждого теста закрываем AndroidDriver чтобы тест атомарным был
     */
    @AfterEach
    public void afterEach() {


        String sessionId = Selenide.sessionId().toString();
    step("Закрытие сессии", Selenide::closeWebDriver);



    }

}
