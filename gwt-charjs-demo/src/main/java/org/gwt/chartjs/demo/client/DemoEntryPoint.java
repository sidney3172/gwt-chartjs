package org.gwt.chartjs.demo.client;

import org.gwt.chartjs.demo.client.examples.GettingStarted;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

public class DemoEntryPoint implements EntryPoint, ValueChangeHandler<String>{

	private DemoView demoView;
	private GettingStarted gettingStarted;
	
	@Override
	public void onModuleLoad() {
		History.addValueChangeHandler(this);
		History.fireCurrentHistoryState();
	}
	
	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		RootPanel.get().clear();
		if(token.isEmpty()){
			if(demoView == null)
				demoView = new DemoView();
			RootPanel.get().add(demoView);
		}
		else if(token.equalsIgnoreCase("getting_started")){
			if(gettingStarted == null)
				gettingStarted = new GettingStarted();
			RootPanel.get().add(gettingStarted);
		}
	}

}
