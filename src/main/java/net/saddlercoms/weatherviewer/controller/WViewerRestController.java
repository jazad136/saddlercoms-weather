package net.saddlercoms.weatherviewer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.saddlercoms.weatherviewer.config.WeatherViewerConfig;
import net.saddlercoms.weatherviewer.model.response.WViewerRestGETModel;
import net.saddlercoms.weatherviewer.model.response.WeatherResponse;
import net.saddlercoms.weatherviewer.service.WeatherService;

@RestController
@RequestMapping(path="/")
public class WViewerRestController {

	RestTemplate restTemplate;
	WeatherService weatherService;
	private String weatherAppId;
	public WViewerRestController(WeatherService weatherService, WeatherViewerConfig config) { 
		this.weatherService = weatherService;
		weatherAppId = config.getWeatherKey();
	}
	
	@GetMapping(path="/openapi")
	@ResponseStatus(HttpStatus.OK)
	public WeatherResponse getWeather() { 
//		return restTemplate.getForObject("https://api.openweathermap.org/data/2.5/"
//				+ "weather?zip=48507,us"
//				+ "&"
//				+ "appid=" + weatherAppId
//				+ "&"
//				+ "units=imperial", WeatherResponse.class);
		return weatherService.getCurrentWeather();
	}
	
	@GetMapping(path="/")
	@ResponseStatus(HttpStatus.OK)
	public WViewerRestGETModel getTranslatedWeather() {
		WeatherResponse currentWeather = weatherService.getCurrentWeather();
		return new WViewerRestGETModel(currentWeather, weatherService.getJavaDT(currentWeather));
	}
	
}
