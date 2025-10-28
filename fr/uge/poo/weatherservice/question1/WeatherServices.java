package fr.uge.poo.weatherservice.question1;

public class WeatherServices {
    private WeatherServices() {}

    private static final WeatherService INSTANCE = new WeatherServiceNTS();
    public static WeatherService uniqueService() { return INSTANCE; }
}
