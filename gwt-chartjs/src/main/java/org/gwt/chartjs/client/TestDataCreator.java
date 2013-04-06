package org.gwt.chartjs.client;

import org.gwt.chartjs.client.data.AreaChartData;
import org.gwt.chartjs.client.data.AreaSeries;
import org.gwt.chartjs.client.data.Series;
import org.gwt.chartjs.client.data.SeriesBuilder;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class TestDataCreator {
	public static AreaChartData get(){
		return createChartData();
	}
	
	public static JsArray<Series> getSeries(){
		JsArray<Series> array = JsArray.createArray().cast();
		
		Series series1 = JavaScriptObject.createObject().cast();
		series1.setColor("#D97041");
		series1.setValue(Math.random());
		array.push(series1);
		
		Series series2 = JavaScriptObject.createObject().cast();
		series2.setColor("#C7604C");
		series2.setValue(Math.random());
		array.push(series2);
		
		Series series3 = JavaScriptObject.createObject().cast();
		series3.setColor("#21323D");
		series3.setValue(Math.random());
		array.push(series3);
		
		Series series4 = JavaScriptObject.createObject().cast();
		series4.setColor("#9D9B7F");
		series4.setValue(Math.random());
		array.push(series4);
		
		return array;
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
						new double[] { 65, 59, 90, 81, 56, 55, 40 })
				.get();
		series.push(s);
		series.push(SeriesBuilder
				.create()
				.withFillColor("rgba(151,187,205,0.5)")
				.withStoreColor("rgba(151,187,205,1)")
				.withPointColor("rgba(151,187,205,1)")
				.withPointStrokeColor("#fff")
				.withData(
						new double[] { 28, 48, 40, 19, 96, 27,
							100 }).get());

		return series;
	}

}
