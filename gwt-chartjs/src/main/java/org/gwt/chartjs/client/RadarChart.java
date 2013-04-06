package org.gwt.chartjs.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;


public class RadarChart extends Chart{
	
	@Override
	public void draw() {
		drawRadar(canvas, TestDataCreator.get());
	}
	
	private native void drawRadar(Element canvas, JavaScriptObject data)/*-{
		var myLine = new Chart(canvas.getContext("2d")).Radar(data,{scaleShowLabels : false, pointLabelFontSize : 10});
}-*/;
	
}
