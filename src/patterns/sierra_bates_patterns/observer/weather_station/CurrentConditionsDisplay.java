package patterns.sierra_bates_patterns.observer.weather_station;

import patterns.sierra_bates_patterns.observer.weather_station.observer_interfaces.DisplayElement;
import patterns.sierra_bates_patterns.observer.weather_station.observer_interfaces.Observer;
import patterns.sierra_bates_patterns.observer.weather_station.observer_interfaces.Subject;

/**
 * Created by a on 13.02.17.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private  float temp;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
    this.temp=temp;
    this.humidity=humidity;
    display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temp
                + "F degrees and " + humidity + "% humidity");
    }
}
