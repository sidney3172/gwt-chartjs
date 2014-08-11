package io.github.sidney3172.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import io.github.sidney3172.client.data.AreaChartData;
import io.github.sidney3172.client.data.AreaChartDataProvider;


public class RadarChart extends Chart {
	
	private AreaChartDataProvider provider;
	private boolean scaleShowLabels = false;
	
	@Override
	public void draw() {
		reload();
	}
	
	public void setScaleShowLabels(boolean scaleShowLabels){
		this.scaleShowLabels = scaleShowLabels;
	}
	
	private native JavaScriptObject drawRadar(Element canvas, JavaScriptObject data, boolean scaleShowLabels, JavaScriptObject nativeCanvas)/*-{
        if(nativeCanvas != null)
            nativeCanvas.destroy();

		return new $wnd.Chart(canvas.getContext("2d")).Radar(data,{scaleShowLabels : scaleShowLabels, pointLabelFontSize : 10});
	}-*/;

	@Override
	public void update() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider was not initialized before invoking update()");

        processEvents(drawRadar(canvas, provider.getData(), scaleShowLabels, nativeCanvas));
	}

	@Override
	public void reload() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider was not initialized before invoking reload()");
		
		//TODO: show loading..
		
		provider.reload(new AsyncCallback<AreaChartData>() {
			
			@Override
			public void onSuccess(AreaChartData result) {
                processEvents(drawRadar(canvas, result, scaleShowLabels, nativeCanvas));
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
