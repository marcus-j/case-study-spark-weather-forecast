package de.marcusjanke.casestudies.weatherforecast.datasources;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import de.marcusjanke.casestudies.weatherforecast.model.WeatherForecast;
import de.marcusjanke.openweathermap.client.OpenWeatherMapClient;
import de.marcusjanke.openweathermap.client.model.List;
import de.marcusjanke.openweathermap.client.model.Main;
import de.marcusjanke.openweathermap.client.model.OpenWeatherMapForecast;

/**
 * Test to check OpenWeatherMapDataSource
 * 
 * @author marcus
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OpenWeatherMapDataSourceTest {

	private final String TEST_CITY = "berlin";

	@Mock
	private OpenWeatherMapClient client;
	@Mock
	private OpenWeatherMapForecast openWeatherMapForecast;
	@Mock
	private List list1;
	@Mock
	private Main main1;
	@Mock
	private List list2;
	@Mock
	private Main main2;

	/**
	 * test if a WeatherForecast can be returned
	 * 
	 * @throws NotAllowedException
	 * @throws ClientValidationException
	 */
	@Test
	public void testOpenWeatherMapForecastSingleElementForcaset()
			throws NotAllowedException, ClientValidationException {
		mockList(list1, main1, 5d, 0d, 6d);
		when(openWeatherMapForecast.getList()).thenReturn(singletonList(list1));
		when(client.getForecast(TEST_CITY)).thenReturn(openWeatherMapForecast);
		testOpenWeatherMapForecast(TEST_CITY, 5d, 0d, 6d);
	}

	/**
	 * test if a WeatherForecast can be returned
	 * 
	 * @throws NotAllowedException
	 * @throws ClientValidationException
	 */
	@Test
	public void testOpenWeatherMapForecastMultiElementElementForcaset()
			throws NotAllowedException, ClientValidationException {
		mockList(list1, main1, 5d, 0d, 6d);
		mockList(list2, main2, 15d, 10d, 18d);
		when(openWeatherMapForecast.getList()).thenReturn(Arrays.asList(list1, list2));
		when(client.getForecast(TEST_CITY)).thenReturn(openWeatherMapForecast);
		testOpenWeatherMapForecast(TEST_CITY, 10d, 5d, 12d);
	}

	/**
	 * test if a ClientValidationException is returned when null city is provided
	 * 
	 * @throws NotAllowedException
	 * @throws ClientValidationException
	 */
	@Test(expected = ClientValidationException.class)
	public void testOpenWeatherMapForecastClientValidationException()
			throws NotAllowedException, ClientValidationException {
		when(client.getForecast(null)).thenThrow(ClientValidationException.class);
		testOpenWeatherMapForecast(null, 10d, 5d, 12d);
	}

	private void testOpenWeatherMapForecast(String city, double pressure, double minTemp, double maxTemp)
			throws NotAllowedException, ClientValidationException {
		WeatherForecastDataSource openWeatherMapDataSource = new OpenWeatherMapDataSource(client);
		WeatherForecast resp = openWeatherMapDataSource.getWeatherForecastForCity(city);
		assertForecast(resp, pressure, minTemp, maxTemp);
	}

	private void mockList(List list, Main main, double pressure, double minTemp, double maxTemp) {
		when(main.getPressure()).thenReturn(pressure);
		when(main.getTempMax()).thenReturn(maxTemp);
		when(main.getTempMin()).thenReturn(minTemp);
		when(list.getMain()).thenReturn(main);
	}

	private void assertForecast(WeatherForecast resp, double pressure, double minTemp, double maxTemp) {
		assertThat(resp).isNotNull();
		assertThat(resp.getAverageDailyTemperature()).isEqualTo(maxTemp);
		assertThat(resp.getAverageNightlyTemperature()).isEqualTo(minTemp);
		assertThat(resp.getAveragePressure()).isEqualTo(pressure);
	}
}
