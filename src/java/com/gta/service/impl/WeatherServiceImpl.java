package com.gta.service.impl;

import com.gta.model.WeatherResponse;
import com.gta.service.WeatherService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Desc:
 * User: jiangningning
 * Date: 2017/9/12
 * Time: 16:56
 */
@Service
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    private RestTemplate restTemplate;

    private static final String WEATHER_API = "http://www.sojson.com/open/api/weather/json.shtml?city=";

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_API + cityName;
        HttpEntity entity = restTemplate.getForEntity(uri, String.class);
        JSONObject jsonObject = JSONObject.fromObject(entity.getBody().toString());
        System.out.println(jsonObject);
        WeatherResponse weatherResponse = (WeatherResponse) JSONObject.toBean(jsonObject, WeatherResponse.class);
        System.out.println(weatherResponse);
        return weatherResponse;
    }

}
