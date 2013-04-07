package org.gwt.chartjs.client;

import org.gwt.chartjs.client.data.AreaChartData;
import org.gwt.chartjs.client.data.AreaChartDataProvider;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class LineChart extends Chart{

	private AreaChartDataProvider provider = null;
	
	@Override
	public void draw() {
		reload();
		
	}
	
	private native void drawLine(Element canvas, JavaScriptObject data)/*-{
		var myLine = new Chart(canvas.getContext("2d")).Line(data);
	}-*/;

	@Override
	public void update() {
		if(provider == null)
			throw new NullPointerException("Data provider is not spicified before calling update()");
		drawLine(canvas, provider.getData());
	}

	@Override
	public void reload() {
		if(provider == null)
			throw new NullPointerException("Data provider is not spicified before calling reload()");
		//TODO: show some king of loading to user
		provider.reload(new AsyncCallback<AreaChartData>() {
			
			@Override
			public void onSuccess(AreaChartData result) {
				drawLine(canvas,result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				//TODO: show loading error to user 
			}
		});
	}
	
	public void setDataProvider(AreaChartDataProvider provider){
		this.provider = provider;
	}
}
