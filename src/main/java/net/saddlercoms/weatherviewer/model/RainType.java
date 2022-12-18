package net.saddlercoms.weatherviewer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RainType {
	private Integer oneHour;
	private Integer threeHour;
	
	public RainType() { }
	
	@JsonProperty("1h") public Integer getOneHourConcentration() { return oneHour; }
	@JsonProperty("1h") public void setOneHourConcentration(Integer oneHourConcentration) { this.oneHour = oneHourConcentration; }
	
	@JsonProperty("3h") public Integer getThreeHourConcentration() { return threeHour; }
	@JsonProperty("3h") public void setThreeHourConcentration(Integer threeHourConcentration) { this.threeHour = threeHourConcentration; }
	
}
