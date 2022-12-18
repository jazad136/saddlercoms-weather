package net.saddlercoms.weatherviewer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.saddlercoms.weatherviewer.model.response.WViewerRestGETModel;
import net.saddlercoms.weatherviewer.model.response.WeatherResponse;
import net.saddlercoms.weatherviewer.service.WeatherService;

@RestController
@RequestMapping(path="/")
@CrossOrigin
public class WViewerRestController {

	RestTemplate restTemplate;
	WeatherService weatherService;
	public WViewerRestController(WeatherService weatherService) { 
		this.weatherService = weatherService;
	}
	
	@GetMapping(path="/openapi")
	@ResponseStatus(HttpStatus.OK)
	public WeatherResponse getWeather() {
		return weatherService.getCurrentWeather();
	}
	
	@GetMapping(path="/")
	@ResponseStatus(HttpStatus.OK)
	public WViewerRestGETModel getTranslatedWeather() {
		WeatherResponse currentWeather = weatherService.getCurrentWeather();
		WViewerRestGETModel model = weatherService.setupRestObject(currentWeather);
		return model;
	}
	
}
