package de.marcusjanke.casestudies.weatherforecast.model;

/**
 * WeatherForecast object
 * 
 * @author marcus
 *
 */
public class WeatherForecast {

	private final double averageDailyTemperature;
	private final double averageNightlyTemperature;
	private final double averagePressure;

	/**
	 * create new WeatherForecast
	 * 
	 * @param averageDailyTemperature
	 * @param averageNightlTemperature
	 * @param averagePressure
	 */
	public WeatherForecast(double averageDailyTemperature, double averageNightlTemperature, double averagePressure) {
		super();
		this.averageDailyTemperature = averageDailyTemperature;
		this.averageNightlyTemperature = averageNightlTemperature;
		this.averagePressure = averagePressure;
	}

	/**
	 * 
	 * @return avg max temp
	 */
	public double getAverageDailyTemperature() {
		return averageDailyTemperature;
	}

	/**
	 * 
	 * @return avg min temp
	 */
	public double getAverageNightlyTemperature() {
		return averageNightlyTemperature;
	}

	/**
	 * 
	 * @return avg pressure
	 */
	public double getAveragePressure() {
		return averagePressure;
	}

}
