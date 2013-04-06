package org.gwt.chartjs.demo.client.sections.doughnut;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DoughnutSection extends Composite{

	private static LineSectionUiBinder uiBinder = GWT
			.create(LineSectionUiBinder.class);

	interface LineSectionUiBinder extends UiBinder<Widget, DoughnutSection> {
	}

	public DoughnutSection() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
