package org.gwt.chartjs.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;


public class PolarAreaChart extends Chart{
	
	@Override
	public void draw() {
		drawBar(canvas, TestDataCreator.getSeries());
	}
	
	private native void drawBar(Element canvas, JavaScriptObject data)/*-{
		var myLine = new Chart(canvas.getContext("2d")).PolarArea(data);
	}-*/;
	
}
