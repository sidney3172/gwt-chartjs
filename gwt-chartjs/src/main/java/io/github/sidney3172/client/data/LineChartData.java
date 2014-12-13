package io.github.sidney3172.client.data;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by sidney3172 on 13/08/14.
 */
public class LineChartData extends JavaScriptObject{

    public final native void setLabels(String[] label)/*-{
        this.labels = labels;
    }-*/;

    public final native void addLabel(String label)/*-{
        labels.push(label);
    }-*/;

    public final native String[] getLabels()/*-{
        return this.labels;
    }-*/;

    public final native void setDataset(Dataset[] dataset)/*-{
        this.datasets = dataset;
    }-*/;

    public final native Dataset[] getDataset()/*-{
        return this.datasets;
    }-*/;

}
