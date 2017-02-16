package patterns.sierra_bates_patterns.observer.weather_station;


/**
 * Created by a on 13.02.17.
 */
public class WeatherStation {
    private final String dd = "DD";
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

      //  StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
      // ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
