package com.gta.controller;

import com.gta.model.WeatherResponse;
import com.gta.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc: WeatherController 天气控制类
 * User: jiangningning
 * Date: 2017/9/13
 * Time: 14:01
 */
@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @ResponseBody
    @GetMapping("/getWeather/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
        return weatherService.getDataByCityName(cityName);
    }

    @ResponseBody
    @GetMapping("/getWeather")
    public String getWeatherByCityName(){
        return "A";
    }


}
