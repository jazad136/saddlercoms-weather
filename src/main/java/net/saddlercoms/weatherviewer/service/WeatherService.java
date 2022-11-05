package net.saddlercoms.weatherviewer.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.saddlercoms.weatherviewer.config.WeatherViewerConfig;
import net.saddlercoms.weatherviewer.model.response.WeatherResponse;

@Service
public class WeatherService {

	private RestTemplate restTemplate;
	private String weatherAppId;
	private WeatherService(RestTemplate restTemplate, WeatherViewerConfig config) { 
		this.restTemplate = restTemplate;
		this.weatherAppId = config.getWeatherKey();
	}
	
	public WeatherResponse getCurrentWeather() { 
		return restTemplate.getForObject("https://api.openweathermap.org/data/2.5/"
				+ "weather?zip=48507,us"
				+ "&"
				+ "appid=" + weatherAppId
				+ "&"
				+ "units=imperial", WeatherResponse.class);
	}
	
	public LocalDateTime getJavaDT(WeatherResponse nowResponse) { 
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
