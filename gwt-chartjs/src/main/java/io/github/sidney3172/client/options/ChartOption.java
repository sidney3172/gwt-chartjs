package io.github.sidney3172.client.options;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.List;

/**
 * Base class for all chart options
 */
public class ChartOption extends JavaScriptObject{

    protected ChartOption(){
        super();
    }

    public static ChartOption get(){
        return JavaScriptObject.createObject().cast();
    }

    public final native void appendTo(JavaScriptObject parent)/*-{
        for(var key in this) parent[key]=this[key];
    }-*/;
}
