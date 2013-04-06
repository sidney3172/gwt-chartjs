package org.gwt.chartjs.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;


public class BarChart extends Chart{
	
	@Override
	public void draw() {
		drawBar(canvas, TestDataCreator.get());
	}
	
	private native void drawBar(Element canvas, JavaScriptObject data)/*-{
	 	console.log(data);
//		var barChartData = {
//			labels : ["January","February","March","April","May","June","July"],
//			datasets : [
//				{
//					fillColor : "rgba(220,220,220,0.5)",
//					strokeColor : "rgba(220,220,220,1)",
//					data : [65,59,90,81,56,55,40]
//				},
//				{
//					fillColor : "rgba(151,187,205,0.5)",
//					strokeColor : "rgba(151,187,205,1)",
//					data : [28,48,40,19,96,27,100]
//				}
//			]
//
//		}
	
	var myLine = new Chart(canvas.getContext("2d")).Bar(data);
}-*/;
	
}
