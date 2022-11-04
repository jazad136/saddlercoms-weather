package net.saddlercoms.weatherviewer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.saddlercoms.weatherviewer.model.response.PingResponse;
import net.saddlercoms.weatherviewer.model.response.WeatherResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class WeatherVControllerTests {
	
	@Autowired
	public TestRestTemplate testRestTemplate;
	
	public static final Logger LOG = LoggerFactory.getLogger(WeatherVControllerTests.class);
	@BeforeAll
	public static void beforeAll() { 
		LOG.warn("***TESTS***");
	}
	@AfterAll
	public static void afterAll() { 
		LOG.warn("***END TESTS***");
	}
	

	@Configuration
	@ComponentScan(basePackages={"net.saddlercoms.weatherviewer"})
	public static class TestInfrastructureConfig
	{
		
	}
	@Test
	public void test_pingResponseReturnsSuccessTrue() { 
		ResponseEntity<PingResponse> pingResponse = testRestTemplate.getForEntity("/ping", PingResponse.class);
		assertThat(pingResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(pingResponse.getBody()).isExactlyInstanceOf(PingResponse.class);
		assertThat(pingResponse.getBody().getSuccess()).isEqualTo(true);
		LOG.warn(pingResponse.getBody().toString());
	}

	@Test
	public void test_weatherResponseIsSuccessful() { 
		ResponseEntity<WeatherResponse> weatherResponse = testRestTemplate.getForEntity("/", WeatherResponse.class);
		assertThat(weatherResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(weatherResponse.getBody()).isExactlyInstanceOf(WeatherResponse.class);
		LOG.warn(weatherResponse.getBody().toString());
	}
}
