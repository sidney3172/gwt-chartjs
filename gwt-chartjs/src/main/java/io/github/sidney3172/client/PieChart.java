package io.github.sidney3172.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import io.github.sidney3172.client.data.PieChartDataProvider;
import io.github.sidney3172.client.data.Series;


public class PieChart extends ChartWithTooltip {
	
	private PieChartDataProvider provider;
	
	@Override
	public void draw() {
		reload();
	}
	
	private native void drawPie(JavaScriptObject data)/*-{
        canvas = this.@io.github.sidney3172.client.Chart::getNativeElement()();
        nativeCanvas = this.@io.github.sidney3172.client.Chart::getNativeCanvas()();
        if(nativeCanvas != null) {
            nativeCanvas.destroy();
        }

        options = this.@io.github.sidney3172.client.Chart::constructOptions()();
        nativeCanvas = new $wnd.Chart(canvas.getContext("2d")).Pie(data,options);
        this.@io.github.sidney3172.client.Chart::setNativeCanvas(Lcom/google/gwt/core/client/JavaScriptObject;)(nativeCanvas);
	}-*/;

	@Override
	public void update() {
		if(provider == null)
			throw new NullPointerException("PieChartDataProvider not initialized before invoking update()");
        drawPie(provider.getData());
	}

	@Override
	public void reload() {
		if(provider == null)
			throw new NullPointerException("PieChartDataProvider not initialized before invoking update()");
		
		//TODO: show loading
		provider.reload(new AsyncCallback<JsArray<Series>>() {
			
			@Override
			public void onSuccess(JsArray<Series> result) {
                drawPie(provider.getData());
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
