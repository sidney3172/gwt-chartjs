package org.gwt.chartjs.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;


public class PieChart extends Chart{
	
	@Override
	public void draw() {
		drawPie(canvas, TestDataCreator.getSeries());
	}
	
	private native void drawPie(Element canvas, JavaScriptObject data)/*-{
		var myLine = new Chart(canvas.getContext("2d")).Pie(data);
	}-*/;
	
}
