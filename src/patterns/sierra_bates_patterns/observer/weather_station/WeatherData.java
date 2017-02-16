package patterns.sierra_bates_patterns.observer.weather_station;


import patterns.sierra_bates_patterns.observer.weather_station.observer_interfaces.Observer;
import patterns.sierra_bates_patterns.observer.weather_station.observer_interfaces.Subject;

import java.util.ArrayList;

/**
 * Created by a on 13.02.17.
 */
public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temp, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }

    //other WeatherData here
}
