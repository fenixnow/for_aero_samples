package helper;

import config.ConfigReader;
import driver.EmulatorDriver;
import driver.SelenoidMobileDriver;

public class RunHelper {
    private RunHelper() {
    }

    /**
     * Статичный консртуктор для вызова методов из класса без создания экземпляра
     * @return
     */
    public static RunHelper runHelper() {
        return new RunHelper();
    }

    /**
     * Реализуем AndroidDriver через кастомные классы для каждого варианта девайса
     * @return
     */
    public Class<?> getDriverClass() {
        String deviceHost = ConfigReader.emulatorConfig.deviceHost();

        switch (deviceHost) {
            case "browserstack":
                //    return BrowserstackMobileDriver.class; можно создать этот класс и реализовать доп логику для BrowserStack
            case "selenoid":
                 return SelenoidMobileDriver.class;
            case "emulator":
                return EmulatorDriver.class;
            case "real":
                //    return RealMobileDriver.class; можно создать этот класс и реализовать логику для реальных девайсов (доп поля нужны)
            default:
                throw new RuntimeException("В файле конфигурации нет параметра deviceHost: " +
                        "browserstack/selenoid/emulator/real");
        }
    }
}
