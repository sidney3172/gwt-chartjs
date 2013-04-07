package org.gwt.chartjs.demo.client.sections.pie;

import org.gwt.chartjs.client.PieChart;
import org.gwt.chartjs.demo.client.examples.TestPieCharDataProvider;

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
		pieChart.setDataProvider(new TestPieCharDataProvider());
	}
}
