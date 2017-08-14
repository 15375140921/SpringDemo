package com.gta.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Desc: BaseController 基类
 * User: jiangningning
 * Date: 2017/8/14
 * Time: 9:52
 */
public abstract class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder){

        binder.registerCustomEditor(String.class, new StringTrimmerEditor(" \t\r\n\f", true));


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));

    }

}
