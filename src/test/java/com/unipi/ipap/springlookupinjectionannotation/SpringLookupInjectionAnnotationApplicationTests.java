package com.unipi.ipap.springlookupinjectionannotation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringLookupInjectionAnnotationApplicationTests {

    @Autowired
    ApplicationContext context;

    @Test
    public void singletonBeanScopeTest() {
        UserService userService1 = context.getBean("userService", UserService.class);
        UserService userService2 = context.getBean("userService", UserService.class);
        Assert.assertEquals(userService1.hashCode(), userService2.hashCode());
    }

    @Test
    public void protoTypeBeanScopeTest() {
        WeatherService weatherService1 = context.getBean("weatherService", WeatherService.class);
        WeatherService weatherService2 = context.getBean("weatherService", WeatherService.class);
        Assert.assertNotEquals(weatherService1.hashCode(), weatherService2.hashCode());
    }

    @Test
    void contextLoads() {
    }

}
