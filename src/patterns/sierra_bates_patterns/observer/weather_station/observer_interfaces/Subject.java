package patterns.sierra_bates_patterns.observer.weather_station.observer_interfaces;

/**
 * Created by a on 13.02.17.
 */
public interface Subject {
    void registerObserver(Observer o ) ;
    void removeObserver(Observer o);
    void notifyObservers();
}
