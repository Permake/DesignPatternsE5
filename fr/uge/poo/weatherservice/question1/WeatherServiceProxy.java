package fr.uge.poo.weatherservice.question1;

public class WeatherServiceProxy implements WeatherService {

    private final Object  lock = new Object();
    private final WeatherServiceNTS serviceNTS = new WeatherServiceNTS();
    @Override
    public int query(String city) {
        synchronized (serviceNTS) {
            return serviceNTS.query(city);
        }
    }
}
