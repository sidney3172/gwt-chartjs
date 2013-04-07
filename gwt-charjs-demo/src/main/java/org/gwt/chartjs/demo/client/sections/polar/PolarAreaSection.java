package org.gwt.chartjs.demo.client.sections.polar;

import org.gwt.chartjs.client.PolarAreaChart;
import org.gwt.chartjs.demo.client.TestPieChartDataProvider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class PolarAreaSection extends Composite{

	private static LineSectionUiBinder uiBinder = GWT
			.create(LineSectionUiBinder.class);

	interface LineSectionUiBinder extends UiBinder<Widget, PolarAreaSection> {
	}

	@UiField PolarAreaChart polarAreaChart;
	
	public PolarAreaSection() {
		initWidget(uiBinder.createAndBindUi(this));
		polarAreaChart.setDataProvider(new TestPieChartDataProvider());
	}
}
