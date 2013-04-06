package org.gwt.chartjs.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;


public class LineChart extends Chart{

	@Override
	public void draw() {
		drawLine(canvas, TestDataCreator.get());
	}
	
	private native void drawLine(Element canvas, JavaScriptObject data)/*-{
		var myLine = new Chart(canvas.getContext("2d")).Line(data);
	}-*/;
	
}
