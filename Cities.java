public enum Cities {
    TOKYO(35.6895, 139.69171, "Токио"),
    MOSCOW(55.75222, 37.61556, "Москва"),
    SAINT_PETERSBURG(59.89444, 59.89444, "Сантк-Петербург"),
    DIMITROVGRAD(54.21386, 49.61838, "Димитровград");

    private double lat;
    private double lon;
    private String name;

    Cities(double lat, double lon, String name) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getName(){
        return name;
    }
}
