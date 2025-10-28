package fr.uge.poo.weatherservice.question2;

import java.util.Optional;

public class WeatherServices {
    private WeatherServices() {
    }

    private static WeatherService INSTANCE;
    private final static Object LOCK = new Object();
    public static Optional<WeatherService> uniqueService() {
        synchronized (LOCK) {
            try {
                if (INSTANCE == null) {
                    return Optional.of(INSTANCE);
                }
                INSTANCE = new WeatherServiceTSFail();
                return Optional.of(INSTANCE);
            } catch (Exception ex) {
                return Optional.empty();
            }
        }
    }
}
