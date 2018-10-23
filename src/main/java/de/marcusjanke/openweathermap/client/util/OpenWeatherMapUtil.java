package de.marcusjanke.openweathermap.client.util;

import java.util.Objects;

import de.marcusjanke.openweathermap.client.model.List;

/**
 * Collection of model mappers and utilities
 * 
 * @author marcus
 *
 */
public class OpenWeatherMapUtil {

	/**
	 * map forecast list to pressure value
	 * 
	 * @param list
	 * @return pressure value
	 */
	public static double mapToPressure(List list) {
		requireNonNullForecastList(list);
		return list.getMain().getPressure();
	}

	/**
	 * map forecast list to daily temperature
	 * 
	 * @param list
	 * @return daily temperature
	 */
	public static double mapToDailyTemperature(List list) {
		requireNonNullForecastList(list);
		return list.getMain().getTempMax();
	}

	/**
	 * map forecast list to nightly temperature
	 * 
	 * @param list
	 * @return nightly temperature
	 */
	public static double mapToNightlyTemperature(List list) {
		requireNonNullForecastList(list);
		return list.getMain().getTempMin();
	}
	
	private static void requireNonNullForecastList(List list) {
		Objects.requireNonNull(list, "forecast list cannot be null");
		Objects.requireNonNull(list.getMain(), "forecast list's main cannot be null");		
	}
}
