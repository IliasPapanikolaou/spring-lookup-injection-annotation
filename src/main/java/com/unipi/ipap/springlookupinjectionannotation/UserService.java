package com.unipi.ipap.springlookupinjectionannotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service // default scope is singleton
public class UserService {

//    @Autowired
//    private WeatherService weatherService;
//
//    public String getCurrentTempFromWeatherAPI() {
//        return weatherService.getTodaysTemp();
//    }

    /**
     * Solution 1:
     * Not recommended solution: Bypass inverse of control
     */

//    @Autowired
//    ApplicationContext applicationContext;
//
//    public String getCurrentTempFromWeatherAPI() {
//        return applicationContext.getBean(WeatherService.class).getTodaysTemp();
//    }

    /**
     * Solution 2:
     * Use ObjectFactory class and .getObject method
     * Not recommended because it always creates new objects and occupies memory
     */

//    @Autowired
//    private ObjectFactory<WeatherService> weatherServiceObjectFactory;
//
//    public String getCurrentTempFromWeatherAPI() {
//        return weatherServiceObjectFactory.getObject().getTodaysTemp();
//    }

    /**
     * Solution 3: recommended
     * Use of @Lookup annotation
     * @link <a href="https://www.baeldung.com/cglib">cglib</a>
     *
     * Spring internally uses cglib library to dynamically @Overrides this method and
     * returns an object instead of null
     *
     * Limitations:
     * - Class WeatherService must not be final, it must be public
     * - Method WeatherService must not be private, static or final, it must be public
     */
    @Lookup
    public WeatherService getWeatherServiceBean() {
        return null;
    }

    public String getCurrentTempFromWeatherAPI() {
        return getWeatherServiceBean().getTodaysTemp();
    }
}
