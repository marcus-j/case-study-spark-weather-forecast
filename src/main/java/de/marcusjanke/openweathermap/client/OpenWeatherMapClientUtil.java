package de.marcusjanke.openweathermap.client;

import de.marcusjanke.casestudies.weatherforecast.datasources.ClientValidationException;
import de.marcusjanke.casestudies.weatherforecast.datasources.NotAllowedException;

import static java.util.Objects.isNull;

final class OpenWeatherMapClientUtil {

	private OpenWeatherMapClientUtil() {
	}

	static void validateApiKey(String apiKey) throws NotAllowedException {
		if (isNull(apiKey)) {
			throw new NotAllowedException();
		}
	}

	static void validateCity(String city) throws ClientValidationException {
		if (isNull(city)) {
			throw new ClientValidationException();
		}
	}
}
