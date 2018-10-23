package de.marcusjanke.casestudies.weatherforecast.datasources;

import de.marcusjanke.casestudies.weatherforecast.model.WeatherForecast;
import de.marcusjanke.openweathermap.client.OpenWeatherMapClient;
import de.marcusjanke.openweathermap.client.model.OpenWeatherMapForecast;
import de.marcusjanke.openweathermap.client.util.OpenWeatherMapUtil;

/**
 * OpenWeatherMap implementation of WeatherForecastDataSource
 * 
 * @author marcus
 *
 */
public class OpenWeatherMapDataSource implements WeatherForecastDataSource {

	private final OpenWeatherMapClient client;

	/**
	 * construct new OpenWeatherMapDataSource
	 */
	public OpenWeatherMapDataSource() {
		super();
		this.client = new OpenWeatherMapClient();
	}

	/**
	 * construct new OpenWeatherMapDataSource
	 *
	 * @param client
	 */
	public OpenWeatherMapDataSource(OpenWeatherMapClient client) {
		super();
		this.client = client;
	}

	@Override
	public WeatherForecast getWeatherForecastForCity(String city)
			throws NotAllowedException, ClientValidationException {
		OpenWeatherMapForecast forecast = client.getForecast(city);
		double averageDailyTemperature = forecast.getList().stream()
				.mapToDouble(OpenWeatherMapUtil::mapToDailyTemperature).average().orElse(-1d);
		double averagePressure = forecast.getList().stream().mapToDouble(OpenWeatherMapUtil::mapToPressure).average()
				.orElse(-1d);
		double averageNightlyTemperature = forecast.getList().stream()
				.mapToDouble(OpenWeatherMapUtil::mapToNightlyTemperature).average().orElse(-1d);
		return new WeatherForecast(averageDailyTemperature, averageNightlyTemperature, averagePressure);
	}
}
