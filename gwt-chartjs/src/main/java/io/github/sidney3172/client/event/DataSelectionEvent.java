package io.github.sidney3172.client.event;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

/**
 * Created by sidney3172 on 08/08/14.
 */
public class DataSelectionEvent extends GwtEvent<DataSelectionHandler> {

    private static Type<DataSelectionHandler> TYPE = new Type<DataSelectionHandler>();

    private Object sender;

    protected DataSelectionEvent(Object sender){
        this.sender = sender;
    }

    public Object getSender(){
        return sender;
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<DataSelectionHandler> getAssociatedType() {
        return TYPE;
    }

    public static Type<DataSelectionHandler> getType(){
        return TYPE;
    }

    @Override
    protected void dispatch(DataSelectionHandler handler) {
        handler.onDataSelected(this);
    }

    public static void fire(HasAnimationCompleteHandlers source, Object sender, JavaScriptObject data) {
        AnimationCompleteEvent event = new AnimationCompleteEvent(sender);
        GWT.log("raw data : "+new JSONObject(data).toString());
        JSONObject array = new JSONObject(data);
        for(String key : array.keySet()){
                GWT.log("[" + key + "] : " + array.get(key).isObject().toString());
        }
        source.fireEvent(event);
    }
}
