package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${environment}.properties"})

public interface DriverConfig extends Config {
    @Key("browserName")
    @DefaultValue("chrome")
    String browserName();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("pageLoadStrategy")
    @DefaultValue("normal")
    String pageLoadStrategy();

    @Key("browserRemoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String browserRemoteUrl();

}