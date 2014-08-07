package io.github.sidney3172.demo.client.sections.pie;

import io.github.sidney3172.client.PieChart;
import io.github.sidney3172.demo.client.TestPieChartDataProvider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class PieSection extends Composite{

	private static LineSectionUiBinder uiBinder = GWT
			.create(LineSectionUiBinder.class);

	interface LineSectionUiBinder extends UiBinder<Widget, PieSection> {
	}
	
	@UiField PieChart pieChart;

	public PieSection() {
		initWidget(uiBinder.createAndBindUi(this));
		pieChart.setDataProvider(new TestPieChartDataProvider());
	}
}
