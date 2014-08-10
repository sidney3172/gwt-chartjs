package io.github.sidney3172.demo.client.sections.line;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiHandler;
import io.github.sidney3172.client.LineChart;
import io.github.sidney3172.client.data.Series;
import io.github.sidney3172.client.event.DataSelectionEvent;
import io.github.sidney3172.demo.client.TestAreaChartDataProvider;

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
	private TestAreaChartDataProvider provider;
	public LineSection() {
		initWidget(uiBinder.createAndBindUi(this));
        provider = new TestAreaChartDataProvider();
		lineChart.setDataProvider(provider);
	}

    @UiHandler("lineChart")
    protected void printDots(DataSelectionEvent event){

    }

    @UiHandler("lineChart")
    protected void onClick(ClickEvent event){
        lineChart.update();
    }
}
