package org.gwt.chartjs.doc.client.start;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GettingStartedView extends Composite{

	private static GettingStartedViewUiBinder uiBinder = GWT
			.create(GettingStartedViewUiBinder.class);

	interface GettingStartedViewUiBinder extends
			UiBinder<Widget, GettingStartedView> {
	}

	public GettingStartedView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
