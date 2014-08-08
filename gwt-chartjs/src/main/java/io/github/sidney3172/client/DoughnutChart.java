package io.github.sidney3172.client;

import io.github.sidney3172.client.data.PieChartDataProvider;
import io.github.sidney3172.client.data.Series;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class DoughnutChart extends Chart {
	
	private PieChartDataProvider provider;
	
	@Override
	public void draw() {
		reload();
		
	}
	
	private native JavaScriptObject drawDoughnut(Element canvas, JavaScriptObject data)/*-{
		return new $wnd.Chart(canvas.getContext("2d")).Doughnut(data);
	}-*/;

	@Override
	public void update() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider is not initialized before invoking update()");
		drawDoughnut(canvas, provider.getData());
	}

	@Override
	public void reload() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider is not initialized before invoking reload()");
		
		//TODO: show loading
		provider.reload(new AsyncCallback<JsArray<Series>>() {
			
			@Override
			public void onSuccess(JsArray<Series> result) {
                drawDoughnut(canvas, result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void setDataProvider(PieChartDataProvider provider){
		this.provider = provider;
	}
	
}
