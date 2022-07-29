package com.unipi.ipap.springlookupinjectionannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    /**
     * In UserService which is a Singleton, we injected WeatherService
     * which has Prototype scope (different objects).
     *
     * Problem:
     * Prototype bean loses its behavior and acts like Singleton
     *
     * Solution: @Lookup method injection
     */

    @Autowired
    private UserService userService;

    @GetMapping("/scope")
    public List<String> getWeatherForecast() throws InterruptedException {
        // The problem is that both responses return the same result
        String response1 = userService.getCurrentTempFromWeatherAPI(); // 022-07-29T19:49:57.062547600->10
        Thread.sleep(1000);
        String response2 = userService.getCurrentTempFromWeatherAPI(); // 022-07-29T19:49:57.062547600->10
        return List.of(response1, response2);
    }

}
