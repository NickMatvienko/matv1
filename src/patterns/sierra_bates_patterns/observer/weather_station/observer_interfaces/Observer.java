package patterns.sierra_bates_patterns.observer.weather_station.observer_interfaces;

/**
 * Created by a on 13.02.17.
 */
public interface Observer {
    void update(float temp, float humidity, float pressure) ;
}
