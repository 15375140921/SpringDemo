package com.gta.service;

import com.gta.model.WeatherResponse;

/**
 * WeatherService
 * Created by ningning.jiang on 2017/9/12.
 */
public interface WeatherService {

    WeatherResponse getDataByCityName(String cityName);

}
