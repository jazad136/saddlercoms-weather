package net.saddlercoms.weatherviewer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainType {
	private Double temp;
	private Double feels_like;
	private Double temp_min;
	private Double temp_max;
	private Integer pressure;
	private Integer humidity;
	
	@JsonProperty("temp") public Double getTemp() { return temp; }
	@JsonProperty("temp") public void setTemp(Double temp) { this.temp = temp; }
	
	@JsonProperty("feels_like") public Double getFeelsLike() { return feels_like; }
	@JsonProperty("feels_like") public void setFeelsLike(Double feels_like) { this.feels_like = feels_like; }
	
	@JsonProperty("temp_min") public Double getTempMin() { return temp_min; }
	@JsonProperty("temp_min") public void setTempMin(Double temp_min) { this.temp_min = temp_min; }
	
	@JsonProperty("temp_max") public Double getTempMax() { return temp_max; }
	@JsonProperty("temp_max") public void setTempMax(Double temp_max) { this.temp_max = temp_max; }
	
	@JsonProperty("pressure") public Integer getPressure() { return pressure; }
	@JsonProperty("pressure") public void setPressure(Integer pressure) { this.pressure = pressure; }
	
	@JsonProperty("humidity") public Integer getHumidity() { return humidity; }
	@JsonProperty("humidity") public void setHumidity(Integer humidity) { this.humidity = humidity; }
	
	@Override
	public String toString() {
		return "MainType [temp=" + temp 
				+ ", feels_like=" + feels_like 
				+ ", temp_min=" + temp_min 
				+ ", temp_max=" + temp_max + 
				", pressure=" + pressure + 
				", humidity=" + humidity 
				+ "]";
	}
}
