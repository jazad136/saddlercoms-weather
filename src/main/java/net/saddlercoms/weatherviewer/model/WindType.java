package net.saddlercoms.weatherviewer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WindType {
	
	/**  Wind speed. Unit: miles/hour. */
	private Double speed;

	/** Wind direction, degrees (meteorological) */
	private Integer degrees;
	
	/** Wind gust.  Unit: miles/hour */
	private Double gust;
	
	/** Wind speed.  Unit: miles/hour. */
	@JsonProperty("speed") public Double getSpeed() { return speed; }
	@JsonProperty("speed") public void setSpeed(Double speed) { this.speed = speed; }
	
	/** Wind direction, degrees (meteorological) */
	@JsonProperty("deg") public Integer getDegrees() { return degrees; }
	@JsonProperty("deg") public void setDegrees(Integer degrees) { this.degrees = degrees; }
	
	/** Wind gust. Unit: miles/hour */
	@JsonProperty("gust") public Double getGust() { return gust; }
	@JsonProperty("gust") public void setGust(Double gust) { this.gust = gust; }
	
	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", degrees=" + degrees + ", gust=" + gust + "]";
	}
	
	
}
