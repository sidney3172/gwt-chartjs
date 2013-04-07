package org.gwt.chartjs.demo.client.sections.line;

import org.gwt.chartjs.client.LineChart;
import org.gwt.chartjs.demo.client.TestAreaChartDataProvider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class LineSection extends Composite{

	private static LineSectionUiBinder uiBinder = GWT
			.create(LineSectionUiBinder.class);

	interface LineSectionUiBinder extends UiBinder<Widget, LineSection> {
	}

	@UiField LineChart lineChart;
	
	public LineSection() {
		initWidget(uiBinder.createAndBindUi(this));
		lineChart.setDataProvider(new TestAreaChartDataProvider());
	}
}
