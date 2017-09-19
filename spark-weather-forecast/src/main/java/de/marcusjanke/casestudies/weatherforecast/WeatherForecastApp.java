package de.marcusjanke.casestudies.weatherforecast;

import static spark.Spark.*;

import de.marcusjanke.casestudies.weatherforecast.datasources.ClientValidationException;
import de.marcusjanke.casestudies.weatherforecast.datasources.NotAllowedException;
import de.marcusjanke.casestudies.weatherforecast.datasources.OpenWeatherMapDataSource;
import de.marcusjanke.casestudies.weatherforecast.datasources.WeatherForecastDataSource;
import de.marcusjanke.casestudies.weatherforecast.model.WeatherForecast;
import de.marcusjanke.util.json.ObjectToJsonConverter;

/**
 * WeatherForecast app entry point and resource wiring
 * @author marcus
 *
 */
public class WeatherForecastApp {
	
	private static final WeatherForecastDataSource weatherForecastDataSource = new OpenWeatherMapDataSource();
	
	public static void main(String[] args) {
        get("/getData",  (req, res) -> {
        	try {
				WeatherForecast resp = weatherForecastDataSource.getWeatherForecastForCity(req.queryParams("city")); 
				res.status(200);
				return ObjectToJsonConverter.toJson(resp);
			} catch (ClientValidationException e) {
				res.status(400);
				return null;
			} catch (NotAllowedException e) {
				res.status(401);
				return null;
			} catch (Exception e) {
				res.status(500);
				return null;
			} 
        });
	}

}
