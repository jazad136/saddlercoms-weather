package net.saddlercoms.weatherviewer.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherViewerConfig {

	private String WEATHER_KEY_ENV = "OPEN_WEATHER_API_KEY";
	private String weatherKey;
	
	public WeatherViewerConfig(Environment env) { 
		String weatherKey = env.getProperty(WEATHER_KEY_ENV);
		this.weatherKey = weatherKey;
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) { 
		return builder.build();
	}
	
	public String getWeatherKey() { return weatherKey; } 
	
	
}
