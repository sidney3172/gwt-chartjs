package org.gwt.chartjs.client;

import org.gwt.chartjs.client.data.AreaChartData;
import org.gwt.chartjs.client.data.AreaChartDataProvider;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class BarChart extends Chart{
	
	private AreaChartDataProvider provider;
	
	@Override
	public void draw() {
		reload();
		
	}
	
	private native void drawBar(Element canvas, JavaScriptObject data)/*-{
		var myLine = new $wnd.Chart(canvas.getContext("2d")).Bar(data);
	}-*/;

	@Override
	public void update() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider is not specified before invoking update()");
		
		drawBar(canvas, provider.getData());
	}

	@Override
	public void reload() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider is not specified before invoking reload()");

		//TODO : show loading
		provider.reload(new AsyncCallback<AreaChartData>() {
			
			@Override
			public void onSuccess(AreaChartData result) {
				drawBar(canvas, result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void setDataProvider(AreaChartDataProvider provier){
		this.provider = provier;
	}
	
}
