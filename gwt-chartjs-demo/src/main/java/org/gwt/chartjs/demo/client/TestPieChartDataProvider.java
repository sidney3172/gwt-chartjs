package org.gwt.chartjs.demo.client;

import org.gwt.chartjs.client.data.PieChartDataProvider;
import org.gwt.chartjs.client.data.Series;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class TestPieChartDataProvider implements PieChartDataProvider{

	private JsArray<Series> data;

	public JsArray<Series> getData() {
		return data;
	}

	public void reload(AsyncCallback<JsArray<Series>> callback) {
		data = getSeries();
		callback.onSuccess(data);
	}

	private JsArray<Series> getSeries(){
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

}