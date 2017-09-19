package de.marcusjanke.casestudies.weatherforecast.datasources;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import de.marcusjanke.casestudies.weatherforecast.model.WeatherForecast;

/**
 * Test to check OpenWeatherMapDataSource
 * 
 * @author marcus
 *
 */
public class OpenWeatherMapDataSourceIntegrationTest {

	/**
	 * test if a WeatherForecast can be returned, requires valid open weather map API key
	 * 
	 * @throws NotAllowedException
	 * @throws ClientValidationException
	 */
	@Test
	public void testOpenWeatherMapForecast() throws NotAllowedException, ClientValidationException {
		WeatherForecastDataSource openWeatherMapDataSource = new OpenWeatherMapDataSource();
		WeatherForecast resp = openWeatherMapDataSource.getWeatherForecastForCity("berlin");
		assertThat(resp).isNotNull();
	}

	/**
	 * test if a OpenWeatherMapDataSource checks city, requires valid open weather map API key
	 * 
	 * @throws NotAllowedException
	 * @throws ClientValidationException
	 */
	@Test(expected = ClientValidationException.class)
	public void testOpenWeatherMapForecastCityCheck() throws NotAllowedException, ClientValidationException {
		WeatherForecastDataSource openWeatherMapDataSource = new OpenWeatherMapDataSource();
		openWeatherMapDataSource.getWeatherForecastForCity(null);
	}
}
