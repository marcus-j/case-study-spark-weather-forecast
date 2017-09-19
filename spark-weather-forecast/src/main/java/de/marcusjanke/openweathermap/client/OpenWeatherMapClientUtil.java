package de.marcusjanke.openweathermap.client;

import java.util.Objects;

import de.marcusjanke.casestudies.weatherforecast.datasources.ClientValidationException;
import de.marcusjanke.casestudies.weatherforecast.datasources.NotAllowedException;

public final class OpenWeatherMapClientUtil {

	public static void validateApiKey(String apiKey) throws NotAllowedException {
		if (Objects.isNull(apiKey)) {
			throw new NotAllowedException();
		}
	}

	public static void validateCity(String city) throws ClientValidationException {
		if (Objects.isNull(city)) {
			throw new ClientValidationException();
		}
	}
}
