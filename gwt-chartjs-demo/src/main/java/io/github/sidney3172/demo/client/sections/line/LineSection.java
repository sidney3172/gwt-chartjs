package io.github.sidney3172.demo.client.sections.line;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import io.github.sidney3172.client.LineChart;
import io.github.sidney3172.client.event.DataSelectionEvent;
import io.github.sidney3172.client.options.LegendOption;
import io.github.sidney3172.demo.client.TestAreaChartDataProvider;

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
        lineChart.setAnimationEnabled(false);
        lineChart.setAnimationSteps(150);
        lineChart.showTooltips(false);
        lineChart.setScaleFontColor("red");
        lineChart.showScale(false);
        LegendOption legend = LegendOption.get();
        legend.setLegendTemplate("<ul class=\\\"<%=name.toLowerCase()%>-legend\\\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\\\"background-color:<%=datasets[i].lineColor%>\\\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>");
//        lineChart.addOption(legend);
	}

    @UiHandler("lineChart")
    protected void printDots(DataSelectionEvent event){

    }

    @UiHandler("lineChart")
    protected void onClick(ClickEvent event){
        lineChart.update();
//        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
//            @Override
//            public void execute() {
//                GWT.log(lineChart.getLegend());
//            }
//        });

    }
}
