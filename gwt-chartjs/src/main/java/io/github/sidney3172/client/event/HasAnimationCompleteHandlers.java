package io.github.sidney3172.client.event;

import com.google.gwt.event.shared.HasHandlers;

/**
 * Interface describe methods required for adding new handlers of {@link AnimationCompleteEvent}
 * @author sidney3172
 *
 */
public interface HasAnimationCompleteHandlers extends HasHandlers{

	/**
	 * Add {@link AnimationCompleteEvent} handler to widget.
	 * @param handler
	 */
	public void addAnimationCompleteHandler(AnimationCompleteHandler handler);
}
