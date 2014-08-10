package io.github.sidney3172.demo.client.sections.doughnut;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiHandler;
import io.github.sidney3172.client.DoughnutChart;
import io.github.sidney3172.demo.client.TestPieChartDataProvider;

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
		doughnutChart.setDataProvider(new TestPieChartDataProvider());
	}

    @UiHandler("doughnutChart")
    protected void randomize(ClickEvent event){
        doughnutChart.update();
    }
}
