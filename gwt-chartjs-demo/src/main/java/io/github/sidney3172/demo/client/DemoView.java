package io.github.sidney3172.demo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import io.github.sidney3172.client.BarChart;
import io.github.sidney3172.client.LineChart;

/**
 * This is a root view of demo application.<br/>
 * @author sidney3172
 */
public class DemoView extends Composite{

	private static DemoViewUiBinder uiBinder = GWT
			.create(DemoViewUiBinder.class);

	interface DemoViewUiBinder extends UiBinder<Widget, DemoView> {
	}

	@UiField
    BarChart titleChart;
	
	public DemoView() {
		initWidget(uiBinder.createAndBindUi(this));
        titleChart.showScale(false);
        titleChart.showTooltips(false);
        titleChart.setResponsive(true);
        titleChart.setMaintainAspectRatio(false);
		titleChart.setDataProvider(new TitleDataProvider());
	}
}
