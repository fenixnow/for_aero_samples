package config;

import org.aeonbits.owner.Config;


/**
 * Чтение ключей из emulator.properties
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:env",
        "system:properties",
        "file:src/test/resources/configs/emulator.properties"
})
public interface EmulatorConfig extends Config {
    //достаем значения по ключу
    @Key("DEVICE_NAME")
    String deviceName();

    @Key("PLATFORM_NAME")
    String platformName();

    @Key("PLATFORM_VERSION")
    String platformVersion();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("app_ios")
    String app_ios();

    @Key("app_android")
    String app_android();

    @Key("remoteURL")
    String remoteURL();

    @Key("newCommandTimeout")
    String newCommandTimeout();

    @DefaultValue("false")
    @Key("ENABLE_VIDEO")
    Boolean enableVideo();

    @Key("deviceHost")
    String deviceHost();

    @DefaultValue("")
    @Key("CI_COMMIT_REF_NAME")
    String branchName();
}
