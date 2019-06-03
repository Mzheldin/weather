import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class Utils {

    private String responce = null;

    private HttpGet formRequest(double lat, double lon){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(URLFields.URL.getValue())
                .append("?lat=").append(lat)
                .append("&lon=").append(lon)
                .append("&lang=«ru_RU»")
                .append("&limit=1")
                .append("&hours=false")
                .append("&extra=false");
        HttpGet httpGet = new HttpGet(stringBuilder.toString());
        httpGet.setHeader(URLFields.HEADER.getValue(), URLFields.ACCESS_TOKEN.getValue());
        return httpGet;
    }

    private void getResponce(double lat, double lon){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try (Scanner scanner = new Scanner(httpClient.execute(formRequest(lat, lon)).getEntity().getContent())){
            if (scanner.hasNext()) responce = scanner.next();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseResponce(){
        if (responce != null && !responce.equals("")){
            JSONObject jsonResponce = new JSONObject(responce);
            JSONObject weatherInfo = jsonResponce.getJSONObject(URLFields.WEATHER_INFO.getValue());
            System.out.println("Температура (°C) " + weatherInfo.getDouble(URLFields.TEMP.getValue()));
            System.out.println("Ощущаемая температура (°C) " + weatherInfo.getDouble(URLFields.FEEL_SLIKE.getValue()));
            System.out.println("Скорость ветра (в м/с) " + weatherInfo.getDouble(URLFields.WIND_SPEED.getValue()));
            System.out.println("Давление (в мм рт. ст.) " + weatherInfo.getDouble(URLFields.PRESSURE_MM.getValue()));
            System.out.println("Влажность воздуха (в процентах) " + weatherInfo.getDouble(URLFields.HUMIDITY.getValue()));
        }
    }

    public void printWeather(Cities city){
        getResponce(city.getLat(), city.getLon());
        System.out.println("\nПогода в городе " + city.getName() + " :");
        parseResponce();
    }

}
