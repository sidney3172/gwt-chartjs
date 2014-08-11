package io.github.sidney3172.client;

import com.google.gwt.core.client.GWT;
import io.github.sidney3172.client.data.AreaChartData;
import io.github.sidney3172.client.data.AreaChartDataProvider;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class BarChart extends Chart {
	
	private AreaChartDataProvider provider;
	
	@Override
	public void draw() {
		reload();
		
	}
	
	private native JavaScriptObject drawBar(Element canvas, JavaScriptObject data, JavaScriptObject nativeCanvas)/*-{
        if(nativeCanvas != null) {
            nativeCanvas.destroy();
        }

        nativeCanvas = new $wnd.Chart(canvas.getContext("2d")).Bar(data);
        return nativeCanvas;
	}-*/;

	@Override
	public void update() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider is not specified before invoking update()");
        nativeCanvas = drawBar(canvas, provider.getData(), nativeCanvas);
	}

	@Override
	public void reload() {
		if(provider == null)
			throw new NullPointerException("PieCharDataProvider is not specified before invoking reload()");

		//TODO : show loading
		provider.reload(new AsyncCallback<AreaChartData>() {
			
			@Override
			public void onSuccess(AreaChartData result) {
                nativeCanvas = drawBar(canvas, result, nativeCanvas);
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
