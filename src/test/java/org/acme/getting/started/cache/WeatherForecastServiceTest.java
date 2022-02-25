package org.acme.getting.started.cache;

import io.quarkus.test.junit.QuarkusTest;
import java.time.LocalDate;
import javax.inject.Inject;
import org.acme.getting.started.cache.WeatherForecastService;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class WeatherForecastServiceTest {

  @Inject
  WeatherForecastService weatherForecastService;

  @Test
  void testWeatherService(){
    StopWatch watch = new StopWatch();
    watch.start();
    String result = weatherForecastService.getDailyForecast(LocalDate.now(), "Berlin");
    watch.stop();
    long first = watch.getTime();
    Assertions.assertEquals("THURSDAY will be sunny in Berlin", result);
    watch.reset();
    watch.start();
    String result2 = weatherForecastService.getDailyForecast(LocalDate.now(), "Berlin");
    watch.stop();
    long second = watch.getTime();
    Assertions.assertEquals("THURSDAY will be sunny in Berlin", result2);
    Assertions.assertTrue(second < first);
  }

}
