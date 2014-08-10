package io.github.sidney3172.demo.client.sections.bar;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiHandler;
import io.github.sidney3172.client.BarChart;
import io.github.sidney3172.demo.client.TestAreaChartDataProvider;

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

    @UiHandler("barChart")
    protected void randomize(ClickEvent event){
        barChart.update();
    }
}
