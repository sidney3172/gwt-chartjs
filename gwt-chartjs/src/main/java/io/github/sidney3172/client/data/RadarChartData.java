package io.github.sidney3172.client.data;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by sidney3172 on 13/08/14.
 */
public class RadarChartData extends JavaScriptObject{

    public final native void setData(Data[] data)/*-{
        this.data = data;
    }-*/;

    public final native void getData()/*-{
        return this.data;
    }-*/;
}
