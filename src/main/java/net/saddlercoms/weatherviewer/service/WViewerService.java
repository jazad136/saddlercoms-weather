package net.saddlercoms.weatherviewer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.saddlercoms.weatherviewer.config.WeatherViewerConfig;
import net.saddlercoms.weatherviewer.model.response.WeatherResponse;

@Service
public class WViewerService {
	private String weatherAppId;
	private RestTemplate restTemplate;
	
	private WViewerService(RestTemplate restTemplate, WeatherViewerConfig config) { 
		this.weatherAppId = config.getWeatherKey();
		this.restTemplate = restTemplate;
	}
	
	public WeatherResponse getNowWeatherResponse() { 
		return restTemplate.getForObject("https://api.openweathermap.org/data/2.5/"
				+ "weather?zip=48507,us"
				+ "&"
				+ "appid=" + weatherAppId
				+ "&"
				+ "units=imperial", WeatherResponse.class);
	}
}
