package io.github.sidney3172.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for handling {@link AnimationCompleteEvent}
 * @author sidney3172
 *
 */
public interface AnimationCompleteHandler extends EventHandler{

	/**
	 * Method will be invoked when animation is complete
	 * @param event : object contains reference to the instance of chart
	 */
	public void onAnimationComplete(AnimationCompleteEvent event);
	
}
