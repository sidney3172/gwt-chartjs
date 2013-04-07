package org.gwt.chartjs.demo.client.examples.line;

import org.gwt.chartjs.client.LineChart;
import org.gwt.chartjs.demo.client.examples.TestAreaChartDataProvider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class LineChartExample extends Composite{

	private static LineChartExampleUiBinder uiBinder = GWT
			.create(LineChartExampleUiBinder.class);

	interface LineChartExampleUiBinder extends
			UiBinder<Widget, LineChartExample> {
	}
	
	@UiField LineChart lineChart;

	public LineChartExample() {
		initWidget(uiBinder.createAndBindUi(this));
		lineChart.setDataProvider(new TestAreaChartDataProvider());
	}
	
	@UiHandler("updateButton")
	protected void updateButtonClicked(ClickEvent event){
		lineChart.update();
	}
	
	@UiHandler("reloadButton")
	protected void reloadButtonClicked(ClickEvent event){
		lineChart.reload();
	}
}
