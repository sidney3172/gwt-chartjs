package io.github.sidney3172.demo.client.sections.radar;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiHandler;
import io.github.sidney3172.client.RadarChart;
import io.github.sidney3172.demo.client.TestAreaChartDataProvider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class RadarSection extends Composite{

	private static LineSectionUiBinder uiBinder = GWT
			.create(LineSectionUiBinder.class);

	interface LineSectionUiBinder extends UiBinder<Widget, RadarSection> {
	}

	@UiField RadarChart radarChart;
	
	public RadarSection() {
		initWidget(uiBinder.createAndBindUi(this));
		radarChart.setDataProvider(new TestAreaChartDataProvider());
	}

    @UiHandler("radarChart")
    protected void randomize(ClickEvent event){
        radarChart.update();
    }
}
