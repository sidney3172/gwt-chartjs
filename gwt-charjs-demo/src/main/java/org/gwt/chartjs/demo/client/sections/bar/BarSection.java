package org.gwt.chartjs.demo.client.sections.bar;

import org.gwt.chartjs.client.BarChart;
import org.gwt.chartjs.demo.client.examples.TestAreaChartDataProvider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class BarSection extends Composite{

	private static LineSectionUiBinder uiBinder = GWT
			.create(LineSectionUiBinder.class);

	interface LineSectionUiBinder extends UiBinder<Widget, BarSection> {
	}
	
	@UiField BarChart barChart;

	public BarSection() {
		initWidget(uiBinder.createAndBindUi(this));
		barChart.setDataProvider(new TestAreaChartDataProvider());
	}
}
