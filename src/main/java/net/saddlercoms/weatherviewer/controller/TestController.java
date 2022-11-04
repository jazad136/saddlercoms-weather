package net.saddlercoms.weatherviewer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.saddlercoms.weatherviewer.model.response.PingResponse;

@RestController
@RequestMapping("/")
public class TestController {
	
	@GetMapping("/ping") 
	@ResponseStatus(HttpStatus.OK)
	public PingResponse test() { return new PingResponse(true);	}

	
}