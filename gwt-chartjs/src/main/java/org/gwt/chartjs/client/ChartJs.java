package org.gwt.chartjs.client;

import org.gwt.chartjs.client.resources.Resources;

import com.google.gwt.core.shared.GWT;

public final class ChartJs {

	private static boolean injected = false;
	
	public static void ensureInjected(){
		if(injected)
			return;
		
		Resources res = GWT.create(Resources.class);
		String source = res.chartJsSource().getText();
		eval(source);
		
	}
	
	private static native void eval(String source)/*-{
		eval(source);
	}-*/;
	
}
