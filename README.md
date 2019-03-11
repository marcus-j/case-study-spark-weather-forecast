# Case Study: Spark-based Weather Forecast

You need to create an API service which will retrieve the average forecast weather metrics of a specific city. The API should expose a “getData” endpoint to retrieve the averages.

The getData endpoint should return a JSON object with the average of the following metrics:

1. Average of daily temperature
2. Average of nightly temperature
3. Average of pressure

The getData endpoint needs a CITY as the input for the correct response.

Use Spark Java as your API server. ( http://sparkjava.com/ )

Use Open Weather Map to get the data ( https://openweathermap.org/ Free account for forecast
data )

Make sure you use a fully REST api convention and that you return the correct error codes
when necessary.

Bonus points:
- Validate input - watch out for any injection tries that an API user might insert
- Retry logic if the external service is down/slow
- Caching
- API usage docs
- Unit tests
- Integration tests
