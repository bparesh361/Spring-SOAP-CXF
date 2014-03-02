package com.test.vo;

import java.util.Date;

public class TemperatureInfo {
	
	private Date date;
	private double min;
	private double max;
	private double avg;
		
	public TemperatureInfo() {
		super();
	}
	
	public TemperatureInfo(Date date, double min, double max, double avg) {
		super();
		this.date = date;
		this.min = min;
		this.max = max;
		this.avg = avg;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	

}
