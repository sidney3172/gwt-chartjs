package org.gwt.chartjs.demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class DemoEntryPoint implements EntryPoint{

	public void onModuleLoad() {
		RootPanel.get().add(new DemoView());
	}

}
