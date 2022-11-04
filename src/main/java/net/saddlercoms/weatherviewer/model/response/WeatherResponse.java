package net.saddlercoms.weatherviewer.model.response;

import java.util.List;

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
//	private WindType wind;
	//  8. dt: a long integer
	private Long dt;
	
	public WeatherResponse() {  }

	
	public List<WeatherType> getWeather() { return weather; } 
	public void setWeather(List<WeatherType> value) { this.weather = value; } 
	
	public String getBase() { return base; }
	public void setBase(String base) { this.base = base; }

	public MainType getMain() { return main; }
	public void setMain(MainType main) { this.main = main; }
	
	public Long getDt() { return dt; } 
	public void setDt(Long value) { this.dt = value; }

	@Override
	public String toString() {
		return "WeatherResponse [weather=" + weather + ", base=" + base + ", main=" + main + ", dt=" + dt + "]";
	}


}
