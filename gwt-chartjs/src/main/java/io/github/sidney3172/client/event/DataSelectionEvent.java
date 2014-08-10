package io.github.sidney3172.client.event;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import io.github.sidney3172.client.data.Series;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sidney3172 on 08/08/14.
 */
public class DataSelectionEvent extends GwtEvent<DataSelectionHandler> {

    private static Type<DataSelectionHandler> TYPE = new Type<DataSelectionHandler>();

    private Object sender;
    private LinkedList<Series> series;

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

    public static void fire(HasDataSelectionEventHandlers source, Object sender, JavaScriptObject data) {
        DataSelectionEvent event = new DataSelectionEvent(sender);
        JSONObject array = new JSONObject(data);
        event.series = new LinkedList<Series>();
        for(String key : array.keySet()){

            JSONObject obj = array.get(key).isObject();
            if(obj != null){
                Series series1 = JavaScriptObject.createObject().cast();
                series1.setValue(obj.get("value").isNumber().doubleValue());
                series1.setColor(obj.get("fillColor").isString().stringValue());
                event.series.add(series1);
            }
        }
        source.fireEvent(event);
    }

    public List<Series> getSeries(){
        return series;
    }
}
