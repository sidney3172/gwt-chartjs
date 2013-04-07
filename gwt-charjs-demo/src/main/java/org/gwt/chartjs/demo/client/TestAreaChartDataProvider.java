package org.gwt.chartjs.demo.client;

import org.gwt.chartjs.client.data.AreaChartData;
import org.gwt.chartjs.client.data.AreaChartDataProvider;
import org.gwt.chartjs.client.data.AreaSeries;
import org.gwt.chartjs.client.data.SeriesBuilder;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class TestAreaChartDataProvider implements AreaChartDataProvider{

	private AreaChartData data;

	@Override
	public JavaScriptObject getData() {
		return data;
	}

	@Override
	public void reload(AsyncCallback<AreaChartData> callback) {
		data = createChartData();
		callback.onSuccess(data);
	}

	private static AreaChartData createChartData(){
		AreaChartData data = JavaScriptObject.createObject().cast();
		data.setLabels(new String[] {"January","February","March","April","May","June","July"});
		data.setSeries(createSeries());
		return data;
	}

	private static JsArray<AreaSeries> createSeries() {
		JsArray<AreaSeries> series = JavaScriptObject.createArray().cast();
		AreaSeries s = SeriesBuilder
				.create()
				.withFillColor("rgba(220,220,220,0.5)")
				.withStoreColor("rgba(220,220,220,1)")
				.withPointColor("rgba(220,220,220,1)")
				.withPointStrokeColor("#fff")
				.withData(
						new double[] { Random.nextInt(400), Random.nextInt(400), Random.nextInt(400), Random.nextInt(400), Random.nextInt(400), Random.nextInt(400), Random.nextInt(400) })
				.get();
		series.push(s);
		series.push(SeriesBuilder
				.create()
				.withFillColor("rgba(151,187,205,0.5)")
				.withStoreColor("rgba(151,187,205,1)")
				.withPointColor("rgba(151,187,205,1)")
				.withPointStrokeColor("#fff")
				.withData(
						new double[] { Random.nextInt(400), Random.nextInt(400), Random.nextInt(400), Random.nextInt(400), Random.nextInt(400), Random.nextInt(400), Random.nextInt(400) })
						.get());

		return series;
	}

}