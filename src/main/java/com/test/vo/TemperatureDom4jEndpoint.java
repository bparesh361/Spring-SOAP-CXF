package com.test.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.xpath.DefaultXPath;
import org.springframework.ws.server.endpoint.AbstractDom4jPayloadEndpoint;

import com.test.WeatherService;

public class TemperatureDom4jEndpoint extends AbstractDom4jPayloadEndpoint {

	private static final String namespaceUri = "http://com.fks.com/weather/schemas";
	
	private XPath cityPath;
	private XPath datePath;
	private DateFormat dateFormat;
	private WeatherService weatherService;
	
	public TemperatureDom4jEndpoint(){
		// Create the XPath objects, including the namespace
		Map<String, String> namespaceUris = new HashMap<String, String>();
		namespaceUris.put("weather", namespaceUri);
		cityPath = new DefaultXPath(
		"/weather:GetTemperatureRequest/weather:city");
		cityPath.setNamespaceURIs(namespaceUris);
		datePath = new DefaultXPath(
		"/weather:GetTemperatureRequest/weather:date");
		datePath.setNamespaceURIs(namespaceUris);
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}
	
	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	@Override
	protected Element invokeInternal(Element requestElement, Document responseDocument)
			throws Exception {
		System.out.println(" --- inside Temperature --- ");
		String city = cityPath.valueOf(requestElement);
		System.out.println(" --- inside Temperature --- " + city);
		List<Date> dates = new ArrayList<Date>();
		for(Object node : datePath.selectNodes(requestElement)){
			Element element = (Element)node;
			dates.add(dateFormat.parse(element.getText()));		
			System.out.println(" --- inside Temperature --- " + element.getText());
		}
		List<TemperatureInfo> list = weatherService.getTemperature(city, dates);
		Element responseElement = responseDocument.addElement("GetTemperatureResponse");				
		for(TemperatureInfo tempInfo : list){
			Element temperatureElement = responseElement.addElement("TemperatureInfo");
			temperatureElement.addAttribute("city","ahm");
			temperatureElement.addAttribute("date", dateFormat.format(tempInfo.getDate()));
			temperatureElement.addElement("min").setText(Double.toString(tempInfo.getMax()));
			temperatureElement.addElement("max").setText(Double.toString(tempInfo.getMin()));
			temperatureElement.addElement("avg").setText(Double.toString(tempInfo.getAvg()));
		}
		return responseElement;
	}
}




	