package de.marcusjanke.openweathermap.client.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temp",
    "temp_min",
    "temp_max",
    "pressure",
    "sea_level",
    "grnd_level",
    "humidity",
    "temp_kf"
})
public class Main {

    @JsonProperty("temp")
    private double temp;
    @JsonProperty("temp_min")
    private double tempMin;
    @JsonProperty("temp_max")
    private double tempMax;
    @JsonProperty("pressure")
    private double pressure;
    @JsonProperty("sea_level")
    private double seaLevel;
    @JsonProperty("grnd_level")
    private double grndLevel;
    @JsonProperty("humidity")
    private int humidity;
    @JsonProperty("temp_kf")
    private int tempKf;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("temp")
    public double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(double temp) {
        this.temp = temp;
    }

    @JsonProperty("temp_min")
    public double getTempMin() {
        return tempMin;
    }

    @JsonProperty("temp_min")
    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    @JsonProperty("temp_max")
    public double getTempMax() {
        return tempMax;
    }

    @JsonProperty("temp_max")
    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    @JsonProperty("pressure")
    public double getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("sea_level")
    public double getSeaLevel() {
        return seaLevel;
    }

    @JsonProperty("sea_level")
    public void setSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
    }

    @JsonProperty("grnd_level")
    public double getGrndLevel() {
        return grndLevel;
    }

    @JsonProperty("grnd_level")
    public void setGrndLevel(double grndLevel) {
        this.grndLevel = grndLevel;
    }

    @JsonProperty("humidity")
    public int getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("temp_kf")
    public int getTempKf() {
        return tempKf;
    }

    @JsonProperty("temp_kf")
    public void setTempKf(int tempKf) {
        this.tempKf = tempKf;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
