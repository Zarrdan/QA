package Properties;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:url.properties"
})
public interface Propertyurl extends Config {

    @Key("base.url.yandex")
    String baseURLYandex();

}
