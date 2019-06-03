public enum URLFields {
    TEMP("temp"),
    FEEL_SLIKE("feels_like"),
    WIND_SPEED("wind_speed"),
    PRESSURE_MM("pressure_mm"),
    HUMIDITY("humidity"),
    WEATHER_INFO("fact"),

    ACCESS_TOKEN("37a445e3-c35d-4056-abb5-f582b081cb61"),
    URL("https://api.weather.yandex.ru/v1/forecast"),
    HEADER("X-Yandex-API-Key");

    private String field;

    URLFields(String field) {
        this.field = field;
    }

    public String getValue(){
        return field;
    }
}
