package io.github.sidney3172.client;

import com.google.gwt.core.client.GWT;
import io.github.sidney3172.client.data.AreaChartData;
import io.github.sidney3172.client.data.AreaChartDataProvider;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class BarChart extends ChartWithOptions {
	
	private AreaChartDataProvider provider;
	
	@Override
	public void draw() {
		reload();
		
	}
	
	private native void drawBar(JavaScriptObject data)/*-{
        canvas = this.@io.github.sidney3172.client.ChartWithOptions::getNativeElement()();
        nativeCanvas = this.@io.github.sidney3172.client.ChartWithOptions::getNativeCanvas()();
        if(nativeCanvas != null) {
            nativeCanvas.destroy();
        }

        var options = this.@io.github.sidney3172.client.ChartWithOptions::constructOptions()();
        nativeCanvas = new $wnd.Chart(canvas.getContext("2d")).Bar(data, options);
        this.@io.github.sidney3172.client.ChartWithOptions::setNativeCanvas(Lcom/google/gwt/core/client/JavaScriptObject;)(nativeCanvas);
	}-*/;

	@Override
	public void update() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider is not specified before invoking update()");
        drawBar(provider.getData());
	}

	@Override
	public void reload() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider is not specified before invoking reload()");

		//TODO : show loading
		provider.reload(new AsyncCallback<AreaChartData>() {
			
			@Override
			public void onSuccess(AreaChartData result) {
                drawBar(result);
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
