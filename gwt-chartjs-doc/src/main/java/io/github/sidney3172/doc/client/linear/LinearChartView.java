package io.github.sidney3172.doc.client.linear;

import io.github.sidney3172.client.LineChart;
import io.github.sidney3172.doc.client.data.TestAreaChartDataProvider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class LinearChartView extends Composite{

	private static GettingStartedViewUiBinder uiBinder = GWT
			.create(GettingStartedViewUiBinder.class);

	interface GettingStartedViewUiBinder extends
			UiBinder<Widget, LinearChartView> {
	}

	@UiField LineChart lineChart;
	
	public LinearChartView() {
		initWidget(uiBinder.createAndBindUi(this));
		lineChart.setDataProvider(new TestAreaChartDataProvider());
	}
}
