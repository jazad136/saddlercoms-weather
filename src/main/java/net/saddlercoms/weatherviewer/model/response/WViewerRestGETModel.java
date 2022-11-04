package net.saddlercoms.weatherviewer.model.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WViewerRestGETModel {
	private String mainForecast;
	private String description;
	private Double temperature;
	private Double feelsLike;
	private Long weatherTimeUTC;
	private LocalDateTime weatherTimeJavaDT;

	public WViewerRestGETModel() {  }

	public WViewerRestGETModel(WeatherResponse response, Long weatherTimeUTC, LocalDateTime weatherTimeJavaDT) { 
		this.temperature = response.getMain().getTemp();
		this.feelsLike = response.getMain().getFeelsLike();
		this.mainForecast = response.getWeather().get(0).getMain();
		this.description = response.getWeather().get(0).getDescription();
		this.weatherTimeUTC = weatherTimeUTC;
		this.weatherTimeJavaDT = weatherTimeJavaDT;			      
	}
	
	@JsonProperty("frcSky") public String getMainForecast() { return mainForecast; } 
	@JsonProperty("frcSky") public void setMainForecast(String value) { this.mainForecast = value; } 
	
	@JsonProperty("description") public String getDescription() { return description; } 
	@JsonProperty("description") public void setDescription(String value) { this.description = value; } 
	
	@JsonProperty("temp") public Double getTemperature() { return temperature; }
	@JsonProperty("temp") public void setTemperature(Double value) { this.temperature = value; }

	@JsonProperty("feelsLike") public Double getFeelsLike() { return feelsLike; }
	@JsonProperty("feelsLike") public void setFeelsLike(Double value) { this.feelsLike = value; }

	@JsonProperty("timeUTC") public Long getWeatherTimeUTC() { return weatherTimeUTC; }
	@JsonProperty("timeUTC") public void setWeatherTimeUTC(Long value) { this.weatherTimeUTC = value; }

	@JsonProperty("time") public LocalDateTime getWeatherTimeJavaDT() { return weatherTimeJavaDT; }
	@JsonProperty("time") public void setWeatherTimeJavaDT(LocalDateTime value) { this.weatherTimeJavaDT = value; }

	@Override
	public String toString() {
		return "WViewerViewModel [mainForecast=" + mainForecast + ", description=" + description + ", temperature="
				+ temperature + ", feelsLike=" + feelsLike + ", weatherTimeUTC=" + weatherTimeUTC
				+ ", weatherTimeJavaDT=" + weatherTimeJavaDT + "]";
	}
	

}
