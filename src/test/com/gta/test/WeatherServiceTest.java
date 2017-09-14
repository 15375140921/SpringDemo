package com.gta.test;

import com.gta.service.WeatherService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * WeatherServiceTest
 * Created by ningning.jiang on 2017/9/12.
 */
public class WeatherServiceTest extends BaseTest {

    @Autowired
    private WeatherService weatherService;

    @Test
    public void getDataByCityName() throws Exception {
        weatherService.getDataByCityName("灵璧");
    }

}