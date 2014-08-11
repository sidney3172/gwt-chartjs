package io.github.sidney3172.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import io.github.sidney3172.client.data.PieChartDataProvider;
import io.github.sidney3172.client.data.Series;


public class PieChart extends Chart {
	
	private PieChartDataProvider provider;
	
	@Override
	public void draw() {
		reload();
	}
	
	private native JavaScriptObject drawPie(Element canvas, JavaScriptObject data, JavaScriptObject nativeCanvas)/*-{
        if(nativeCanvas != null)
            nativeCanvas.destroy();

        return new $wnd.Chart(canvas.getContext("2d")).Pie(data);
	}-*/;

	@Override
	public void update() {
		if(provider == null)
			throw new NullPointerException("PieChartDataProvider not initialized before invoking update()");
        nativeCanvas = drawPie(canvas, provider.getData(),nativeCanvas);
	}

	@Override
	public void reload() {
		if(provider == null)
			throw new NullPointerException("PieChartDataProvider not initialized before invoking update()");
		
		//TODO: show loading
		provider.reload(new AsyncCallback<JsArray<Series>>() {
			
			@Override
			public void onSuccess(JsArray<Series> result) {
                nativeCanvas = drawPie(canvas, provider.getData(),nativeCanvas);
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
