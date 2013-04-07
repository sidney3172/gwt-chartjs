package org.gwt.chartjs.demo.client.sections.doughnut;

import org.gwt.chartjs.client.DoughnutChart;
import org.gwt.chartjs.demo.client.examples.TestPieCharDataProvider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DoughnutSection extends Composite{

	private static LineSectionUiBinder uiBinder = GWT
			.create(LineSectionUiBinder.class);

	interface LineSectionUiBinder extends UiBinder<Widget, DoughnutSection> {
	}

	@UiField DoughnutChart doughnutChart;
	
	public DoughnutSection() {
		initWidget(uiBinder.createAndBindUi(this));
		doughnutChart.setDataProvider(new TestPieCharDataProvider());
	}
}
