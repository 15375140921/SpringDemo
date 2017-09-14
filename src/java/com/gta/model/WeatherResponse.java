package com.gta.model;

import java.io.Serializable;

/**
 * Desc: WeatherResponse 天气响应实体类
 * User: jiangningning
 * Date: 2017/9/12
 * Time: 16:44
 */
public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Weather data; // 消息数据
    private String status; // 消息状态
    private String desc; // 消息描述

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
