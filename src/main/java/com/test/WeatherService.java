package com.test;

import java.util.Date;
import java.util.List;

import com.test.vo.TemperatureInfo;

public interface WeatherService {
	
	public List<TemperatureInfo> getTemperature(String cityName,List<Date> dates);

}
