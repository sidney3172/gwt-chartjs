package org.gwt.chartjs.client;

import org.gwt.chartjs.client.data.AreaChartData;
import org.gwt.chartjs.client.data.AreaChartDataProvider;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class RadarChart extends Chart{
	
	private AreaChartDataProvider provider;
	private boolean scaleShowLabels = false;
	
	@Override
	public void draw() {
		reload();
//		drawRadar(canvas, TestDataCreator.get(), scaleShowLabels);
	}
	
	public void setScaleShowLabels(boolean scaleShowLabels){
		this.scaleShowLabels = scaleShowLabels;
	}
	
	private native void drawRadar(Element canvas, JavaScriptObject data, boolean scaleShowLabels)/*-{
		var myLine = new Chart(canvas.getContext("2d")).Radar(data,{scaleShowLabels : scaleShowLabels, pointLabelFontSize : 10});
	}-*/;

	@Override
	public void update() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider was not initialized before invoking update()");
		
		drawRadar(canvas, provider.getData(), scaleShowLabels);
	}

	@Override
	public void reload() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider was not initialized before invoking reload()");
		
		//TODO: show loading..
		
		provider.reload(new AsyncCallback<AreaChartData>() {
			
			@Override
			public void onSuccess(AreaChartData result) {
				drawRadar(canvas, result, scaleShowLabels);				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void setDataProvider(AreaChartDataProvider provider){
		this.provider = provider;
	}
	
}
