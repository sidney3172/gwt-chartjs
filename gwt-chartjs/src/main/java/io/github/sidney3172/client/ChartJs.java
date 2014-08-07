package io.github.sidney3172.client;

import io.github.sidney3172.client.resources.Resources;

import com.google.gwt.core.client.GWT;


/**
 * Utility class which helps to inject native chart.js code into browser
 * @author sidney3172
 *
 */
public final class ChartJs {

	private static boolean injected = false;
	
	/**
	 * Method injecting native chart.js code into the browser<br/>
	 * In case code already been injected do nothing
	 */
	public static void ensureInjected(){ //TODO: do real injection (lazy loading)
		if(injected)
			return;
		Resources res = GWT.create(Resources.class);
		String source = res.chartJsSource().getText();
		eval(source);
		injected = true;
	}
	
	private static native void eval(String source)/*-{
		eval(source);
	}-*/;
	
}
