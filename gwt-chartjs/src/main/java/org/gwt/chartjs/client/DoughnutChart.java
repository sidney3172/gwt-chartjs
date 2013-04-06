package org.gwt.chartjs.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;


public class DoughnutChart extends Chart{
	
	@Override
	public void draw() {
		drawDoughnut(canvas, TestDataCreator.getSeries());
	}
	
	private native void drawDoughnut(Element canvas, JavaScriptObject data)/*-{
		var myLine = new Chart(canvas.getContext("2d")).Doughnut(data);
}-*/;
	
}
