package net.saddlercoms.weatherviewer.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.saddlercoms.weatherviewer.model.MainType;
import net.saddlercoms.weatherviewer.model.WeatherType;
import net.saddlercoms.weatherviewer.model.WindType;

public class WeatherResponse {
	//	1. coord: complextype
	//	2. weather: complextype
	private List<WeatherType> weather;
	//	3. base: a basic String
	private String base;
	//	4. main: complextype
	private MainType main;
	//  5. visibility: a long integer
	
//	//  6. wind: complextype
	private WindType wind;
	//  8. dt: a long integer
	private Long dt;
	
	public WeatherResponse() {  }
	
	@JsonProperty("weather") public List<WeatherType> getWeather() { return weather; } 
	@JsonProperty("weather") public void setWeather(List<WeatherType> value) { this.weather = value; } 
	
	@JsonProperty("base") public String getBase() { return base; }
	@JsonProperty("base") public void setBase(String base) { this.base = base; }

	@JsonProperty("main") public MainType getMain() { return main; }
	@JsonProperty("main") public void setMain(MainType main) { this.main = main; }
	
	@JsonProperty("wind") public WindType getWind() { return wind; } 
	@JsonProperty("wind") public void setWind(WindType value) { this.wind = value; } 
	
	@JsonProperty("dt") public Long getDt() { return dt; } 
	@JsonProperty("dt") public void setDt(Long value) { this.dt = value; }

	@Override
	public String toString() {
		return "WeatherResponse [weather=" + weather + ", base=" + base + ", main=" + main + ", wind=" + wind + ", dt="
				+ dt + "]";
	}

	


	


}
