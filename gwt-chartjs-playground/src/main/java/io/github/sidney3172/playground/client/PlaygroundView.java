package io.github.sidney3172.playground.client;

import io.github.sidney3172.playground.client.resources.ChartDocResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is a root view of demo application.<br/>
 * @author sidney3172
 */
public class PlaygroundView extends Composite{

	private static DemoViewUiBinder uiBinder = GWT
			.create(DemoViewUiBinder.class);

	interface DemoViewUiBinder extends UiBinder<Widget, PlaygroundView> {
	}
	

	public PlaygroundView() {
		ChartDocResources res = GWT.create(ChartDocResources.class);
		res.docStyle().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
	}
}
