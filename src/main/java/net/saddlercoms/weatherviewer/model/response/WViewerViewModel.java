package net.saddlercoms.weatherviewer.model.response;

import java.time.LocalDateTime;

import net.saddlercoms.weatherviewer.model.MainType;

public class WViewerViewModel {
	private String mainForecast;
	private String description;
	private Double temperature;
	private Double feelsLike;
	private Long weatherTimeUTC;
	private LocalDateTime weatherTimeJavaDT;

	public WViewerViewModel() {  }

	public WViewerViewModel(Double temperature, Double feelsLike, Long weatherTimeUTC, LocalDateTime weatherTimeJavaDT) { 
		this.temperature = temperature;
		this.feelsLike = feelsLike;
		this.weatherTimeUTC = weatherTimeUTC;
		this.weatherTimeJavaDT = weatherTimeJavaDT;			      
	}
	
	public WViewerViewModel(String main, String description, Double temperature, Double feelsLike, Long weatherTimeUTC, LocalDateTime weatherTimeJavaDT) { 
		this.temperature = temperature;
		this.feelsLike = feelsLike;
		this.mainForecast = main;
		this.description = description;
		this.weatherTimeUTC = weatherTimeUTC;
		this.weatherTimeJavaDT = weatherTimeJavaDT;			      
	}
	
	public String getMainForecast() { return mainForecast; } 
	public void setMainForecast(String value) { this.mainForecast = value; } 
	
	public String getDescription() { return description; } 
	public void setDescription(String value) { this.description = value; } 
	
	public Double getTemperature() { return temperature; }
	public void setTemperature(Double value) { this.temperature = value; }

	public Double getFeelsLike() { return feelsLike; }
	public void setFeelsLike(Double value) { this.feelsLike = value; }

	public Long getWeatherTimeUTC() { return weatherTimeUTC; }
	public void setWeatherTimeUTC(Long value) { this.weatherTimeUTC = value; }

	public LocalDateTime getWeatherTimeJavaDT() { return weatherTimeJavaDT; }
	public void setWeatherTimeJavaDT(LocalDateTime value) { this.weatherTimeJavaDT = value; }

	@Override
	public String toString() {
		return "WViewerViewModel [mainForecast=" + mainForecast + ", description=" + description + ", temperature="
				+ temperature + ", feelsLike=" + feelsLike + ", weatherTimeUTC=" + weatherTimeUTC
				+ ", weatherTimeJavaDT=" + weatherTimeJavaDT + "]";
	}
	

}
