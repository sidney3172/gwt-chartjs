package org.gwt.chartjs.demo.client;

import org.gwt.chartjs.client.LineChart;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is a root view of demo application.<br/>
 * @author sidney3172
 */
public class DemoView extends Composite{

	private static DemoViewUiBinder uiBinder = GWT
			.create(DemoViewUiBinder.class);

	interface DemoViewUiBinder extends UiBinder<Widget, DemoView> {
	}

	@UiField LineChart titleChart;
	
	public DemoView() {
		initWidget(uiBinder.createAndBindUi(this));
		titleChart.setDataProvider(new TestAreaChartDataProvider());
	}
}
