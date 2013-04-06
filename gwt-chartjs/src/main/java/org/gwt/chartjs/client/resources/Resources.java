package org.gwt.chartjs.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface Resources extends ClientBundle{
	@Source("js/chart.min.js")
	TextResource chartJsSource();
	
	@Source("js/chart.css")
	ChartStyle chartStyle();
}
