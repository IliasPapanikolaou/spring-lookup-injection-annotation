package com.unipi.ipap.springlookupinjectionannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@Scope("prototype") // Bean scope prototype
public class WeatherService {

    String time = LocalDateTime.now().toString();
    int temp = new Random().nextInt(40);

    public String getTodaysTemp() {
        return time + "->" + temp;
    }
}
