package de.marcusjanke.openweathermap.client;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import de.marcusjanke.casestudies.weatherforecast.datasources.ClientValidationException;
import de.marcusjanke.casestudies.weatherforecast.datasources.NotAllowedException;
import de.marcusjanke.openweathermap.client.OpenWeatherMapClient;
import de.marcusjanke.openweathermap.client.model.OpenWeatherMapForecast;

/**
 * Test to check OpenWeatherMapClient
 * 
 * @author marcus
 *
 */
public class OpenWeatherMapClientIntegrationTest {

	/**
	 * test if a forecast can be returned, requires valid API key
	 * 
	 * @throws NotAllowedException
	 * @throws ClientValidationException
	 */
	@Test
	public void testOpenWeatherMapForecast() throws NotAllowedException, ClientValidationException {
		OpenWeatherMapClient client = new OpenWeatherMapClient();
		OpenWeatherMapForecast forecast = client.getForecast("berlin");
		assertThat(forecast).isNotNull();
	}
}
