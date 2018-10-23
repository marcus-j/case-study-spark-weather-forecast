package de.marcusjanke.openweathermap.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import de.marcusjanke.casestudies.weatherforecast.datasources.ClientValidationException;
import de.marcusjanke.casestudies.weatherforecast.datasources.NotAllowedException;
import de.marcusjanke.openweathermap.client.model.OpenWeatherMapForecast;

/**
 * OpenWeatherMapClient for forecast method (GET http://api.openweathermap.org/data/2.5/forecast) only
 * 
 * @author marcus
 *
 */
public class OpenWeatherMapClient {

	private static final Logger logger = LoggerFactory.getLogger(OpenWeatherMapClient.class);
	private static final ObjectMapper objectMapper = new ObjectMapper();

	private static final String CONFIG_FILE_NAME = "openweathermap.properties";
	private static String API_KEY;
	static {
		String configFilePath = Thread.currentThread().getContextClassLoader().getResource(CONFIG_FILE_NAME).getPath();
		Properties props = new Properties();
		try (InputStream source = new FileInputStream(configFilePath)) {
			props.load(source);
			API_KEY = props.getProperty("openweathermap.apikey");
		} catch (IOException e) {
			logger.error("Could not load open OpenWeatherMap api key", e);
			API_KEY = null;
		}
	}

	/**
	 * get forecast for city
	 * 
	 * @param city
	 * @return OpenWeatherMapForecast
	 * @throws NotAllowedException
	 * @throws ClientValidationException
	 */
	public OpenWeatherMapForecast getForecast(String city) throws NotAllowedException, ClientValidationException {
		OpenWeatherMapForecast forecast = null;
		OpenWeatherMapClientUtil.validateApiKey(API_KEY);
		OpenWeatherMapClientUtil.validateCity(city);
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://api.openweathermap.org/data/2.5/forecast").queryParam("q", city).queryParam("APPID", API_KEY);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			forecast = objectMapper.readValue(response.getEntity(String.class), OpenWeatherMapForecast.class);
		} catch (Exception e) {
			logger.error("Could not access OpenWeatherMap", e);
		}
		return forecast;
	}
}
