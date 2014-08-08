package io.github.sidney3172.client;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import io.github.sidney3172.client.data.AreaChartData;
import io.github.sidney3172.client.data.AreaChartDataProvider;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import io.github.sidney3172.client.event.DataSelectionEvent;

import javax.sound.sampled.Line;


public class LineChart extends Chart {

	private AreaChartDataProvider provider = null;
	private JavaScriptObject nativeCanvas;

	@Override
	public void draw() {
		reload();
		addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                JavaScriptObject data = sendClick(clickEvent.getNativeEvent(), nativeCanvas);
                if(data != null)
                    DataSelectionEvent.fire(LineChart.this, LineChart.this, data);
            }
        });
	}
	
	private native JavaScriptObject drawLine(Element canvas, JavaScriptObject data)/*-{
        if ($wnd.testChart == null || $wnd.testChart == undefined) {
            console.log("not null");
            $wnd.testChart = new $wnd.Chart(canvas.getContext("2d")).Line(data);
            return $wnd.testChart;
        }
        return new $wnd.Chart(canvas.getContext("2d")).Line(data);


	}-*/;

	@Override
	public void update() {
		if(provider == null)
			throw new NullPointerException("Data provider is not specified before calling update()");
        nativeCanvas = drawLine(canvas, provider.getData());
	}

    private native JavaScriptObject sendClick(NativeEvent event, JavaScriptObject canvas)/*-{
        return canvas.getPointsAtEvent(event);
    }-*/;

	@Override
	public void reload() {
		if(provider == null)
			throw new NullPointerException("Data provider is not specified before calling reload()");
		//TODO: show some king of loading to user
		provider.reload(new AsyncCallback<AreaChartData>() {
			
			@Override
			public void onSuccess(AreaChartData result) {
				nativeCanvas = drawLine(canvas,result);
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
