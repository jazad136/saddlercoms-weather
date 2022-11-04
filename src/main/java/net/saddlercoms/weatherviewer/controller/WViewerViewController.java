package net.saddlercoms.weatherviewer.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.saddlercoms.weatherviewer.model.response.WViewerViewModel;
import net.saddlercoms.weatherviewer.model.response.WeatherResponse;
import net.saddlercoms.weatherviewer.service.WViewerService;

@Controller
@RequestMapping("/browser")
public class WViewerViewController {
//	private RestTemplate restTemplate;
	WViewerService weatherService;
	
	public WViewerViewController(WViewerService service) { 
		this.weatherService = service;
	}
	
	@GetMapping("/static")
	public String indexStatic() { 
		return "index-static";
	}
	@GetMapping()
	public String index(Model model) { 
		// https://stackoverflow.com/questions/535004/unix-epoch-time-to-java-date-object
		WeatherResponse nowResponse = weatherService.getNowWeatherResponse();
		String main = nowResponse.getWeather().get(0).getMain();
		String description = nowResponse.getWeather().get(0).getDescription();
		Double temperature = nowResponse.getMain().getTemp();
		Double feelsLike = nowResponse.getMain().getFeelsLike();
		Long weatherTimeUTC = nowResponse.getDt();
		LocalDateTime weatherTime = getJavaDT(nowResponse);
//		String weatherTimeString = weatherTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
		String weatherTimeString = weatherTime.format(DateTimeFormatter.ofPattern("MMM. dd, uuuu, h:mm a 'Eastern'"));
		WViewerViewModel weaMod = new WViewerViewModel(main, description, temperature, feelsLike, weatherTimeUTC, weatherTime);
		model.addAttribute("weamod", weaMod);
//		model.addAttribute("tempStr", weaMod.getTemperature() + " degrees F");
//		model.addAttribute("feelsLikeStr", weaMod.getFeelsLike() + " degrees F");
		model.addAttribute("timeStr", weatherTimeString);
		return "full-forecast";
	}
	
	private LocalDateTime getJavaDT(WeatherResponse nowResponse) { 
		long epoch = nowResponse.getDt();
		Instant instant = Instant.ofEpochSecond(epoch);
		ZonedDateTime utcDate = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
		//https://stackoverflow.com/questions/42280454/changing-localdatetime-based-on-time-difference-in-current-time-zone-vs-eastern
		ZoneId newZone = ZoneId.of("America/New_York");	
		ZonedDateTime easternDate = utcDate.withZoneSameInstant(newZone);
		return easternDate.toLocalDateTime();
	}
	
	
}
