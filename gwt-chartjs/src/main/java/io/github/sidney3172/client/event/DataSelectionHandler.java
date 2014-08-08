package io.github.sidney3172.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for handling {@link io.github.sidney3172.client.event.AnimationCompleteEvent}
 * @author sidney3172
 *
 */
public interface DataSelectionHandler extends EventHandler{

	/**
	 * Method will be invoked when animation is complete
	 * @param event : object contains reference to the instance of chart
	 */
	public void onDataSelected(DataSelectionEvent event);
	
}
