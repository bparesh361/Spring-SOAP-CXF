package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.test.vo.TemperatureInfo;

//@WebService
public class WeatherServiceImpl implements WeatherService {

//	@WebMethod
	public List<TemperatureInfo> getTemperature(String cityName,
			List<Date> dates) {
		List<TemperatureInfo> list = new ArrayList<TemperatureInfo>();
		for(Date date : dates){
		list.add(new TemperatureInfo(date,1.1, 1.1, 1.1));
		}
		return list;
	}

	
	
}
