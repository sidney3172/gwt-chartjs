package io.github.sidney3172.client.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Interface describe methods required for adding new handlers of {@link io.github.sidney3172.client.event.AnimationCompleteEvent}
 * @author sidney3172
 *
 */
public interface HasDataSelectionEventHandlers extends HasHandlers{

	/**
	 * Add {@link io.github.sidney3172.client.event.AnimationCompleteEvent} handler to widget.
	 * @param handler
	 */
	public HandlerRegistration addDataSelectionHandler(DataSelectionHandler handler);
}
