package io.github.sidney3172.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.rpc.AsyncCallback;
import io.github.sidney3172.client.data.PieChartDataProvider;
import io.github.sidney3172.client.data.Series;


public class DoughnutChart extends ChartWithTooltip {
	
	private PieChartDataProvider provider;
	
	@Override
	public void draw() {
		reload();
		
	}
	
	private native void drawDoughnut(JavaScriptObject data)/*-{
        canvas = this.@io.github.sidney3172.client.Chart::getNativeElement()();
        nativeCanvas = this.@io.github.sidney3172.client.Chart::getNativeCanvas()();
        if(nativeCanvas != null) {
            nativeCanvas.destroy();
        }

        var options = this.@io.github.sidney3172.client.Chart::constructOptions()();
        nativeCanvas = new $wnd.Chart(canvas.getContext("2d")).Doughnut(data, options);
        this.@io.github.sidney3172.client.Chart::setNativeCanvas(Lcom/google/gwt/core/client/JavaScriptObject;)(nativeCanvas);


	}-*/;

	@Override
	public void update() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider is not initialized before invoking update()");
		drawDoughnut(provider.getData());
	}

	@Override
	public void reload() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider is not initialized before invoking reload()");
		
		//TODO: show loading
		provider.reload(new AsyncCallback<JsArray<Series>>() {
			
			@Override
			public void onSuccess(JsArray<Series> result) {
                drawDoughnut(result);
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
