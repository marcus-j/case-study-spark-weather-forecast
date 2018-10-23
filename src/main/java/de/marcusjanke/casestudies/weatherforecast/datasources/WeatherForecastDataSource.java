package de.marcusjanke.casestudies.weatherforecast.datasources;

import de.marcusjanke.casestudies.weatherforecast.model.WeatherForecast;

/**
 * WeatherForecastDataSource interface
 * 
 * @author marcus
 *
 */
public interface WeatherForecastDataSource {

	/**
	 * get forecast for speciic city
	 * 
	 * @param city
	 * @return WeatherForecastResponse
	 * @throws NotAllowedException
	 * @throws ClientValidationException
	 */
	public WeatherForecast getWeatherForecastForCity(String city) throws NotAllowedException, ClientValidationException;
}
