package net.saddlercoms.weatherviewer.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.saddlercoms.weatherviewer.config.WeatherViewerConfig;
import net.saddlercoms.weatherviewer.model.response.WViewerRestGETModel;
import net.saddlercoms.weatherviewer.model.response.WeatherResponse;

@RestController
@RequestMapping(path="/")
public class WViewerRestController {

	RestTemplate restTemplate;
	private String weatherAppId;
	public WViewerRestController(RestTemplate restTemplate, WeatherViewerConfig config) { 
		this.restTemplate = restTemplate;
		weatherAppId = config.getWeatherKey();
	}
	
	@GetMapping(path="/openapi")
	@ResponseStatus(HttpStatus.OK)
	public WeatherResponse getWeather() { 
		return restTemplate.getForObject("https://api.openweathermap.org/data/2.5/"
				+ "weather?zip=48507,us"
				+ "&"
				+ "appid=" + weatherAppId
				+ "&"
				+ "units=imperial", WeatherResponse.class);
	}
	
	@GetMapping(path="/")
	@ResponseStatus(HttpStatus.OK)
	public WViewerRestGETModel getTranslatedWeather() { 
		WeatherResponse theWeather = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/"
				+ "weather?zip=48507,us"
				+ "&"
				+ "appid=" + weatherAppId
				+ "&"
				+ "units=imperial", WeatherResponse.class);
		
		return new WViewerRestGETModel(theWeather, theWeather.getDt(), getJavaDT(theWeather));
		
	}
	private LocalDateTime getJavaDT(WeatherResponse nowResponse) { 
		long epoch = nowResponse.getDt();
		Instant instant = Instant.ofEpochSecond(epoch);
		ZonedDateTime utcDate = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
		
		// Thanks goes out to: 
		// https://stackoverflow.com/questions/42280454/changing-localdatetime-based-on-time-difference-in-current-time-zone-vs-eastern
		ZoneId newZone = ZoneId.of("America/New_York");	
		ZonedDateTime easternDate = utcDate.withZoneSameInstant(newZone);
		return easternDate.toLocalDateTime();
	}
}
