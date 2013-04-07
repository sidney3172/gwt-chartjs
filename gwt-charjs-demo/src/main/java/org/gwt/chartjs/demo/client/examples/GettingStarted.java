package org.gwt.chartjs.demo.client.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GettingStarted extends Composite{

	private static GettingStartedUiBinder uiBinder = GWT
			.create(GettingStartedUiBinder.class);

	interface GettingStartedUiBinder extends UiBinder<Widget, GettingStarted> {
	}

	public GettingStarted() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
