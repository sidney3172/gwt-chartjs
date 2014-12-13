package io.github.sidney3172.demo.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import io.github.sidney3172.client.data.AreaChartData;
import io.github.sidney3172.client.data.AreaChartDataProvider;
import io.github.sidney3172.client.data.AreaSeries;
import io.github.sidney3172.client.data.SeriesBuilder;

public class TitleDataProvider implements AreaChartDataProvider{

    private AreaChartData data;

    @Override
    public JavaScriptObject getData() {
        data = createChartData();
        return data;
    }

    @Override
    public void reload(AsyncCallback<AreaChartData> callback) {
        data = createChartData();
        callback.onSuccess(data);
    }

    private AreaChartData createChartData(){
        AreaChartData data = JavaScriptObject.createObject().cast();
        data.setLabels(new String[] {"January","February","March","April","May","June","July"});
        data.setSeries(createSeries());
        return data;
    }

    private JsArray<AreaSeries> createSeries() {
        JsArray<AreaSeries> series = JavaScriptObject.createArray().cast();
        for(int i=0;i<1;i++) {
            AreaSeries s = SeriesBuilder
                    .create()
                    .withLabel("Sample label")
                    .withFillColor("rgba(220,220,220,0.5)")
                    .withStoreColor("rgba(220,220,220,1)")
                    .withPointColor("rgba(220,220,220,1)")
                    .withPointStrokeColor("#fff")
                    .withData(getRandomDigits())
                    .get();
            series.push(s);
        }
        return series;
    }

    private double[] getRandomDigits(){
        double[] values = new double[10];
        for(int i=0;i<10;i++){
            values[i] = 10;
        }
        return values;
    }

}