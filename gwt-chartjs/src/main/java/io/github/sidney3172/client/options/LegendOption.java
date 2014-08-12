package io.github.sidney3172.client.options;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Created by sidney3172 on 11/08/14.
 */
public class LegendOption extends ChartOption{

    protected LegendOption(){
        super();
    }

    public static LegendOption get(){
        return JavaScriptObject.createObject().cast();
    }

    /**
     * Template String of legend widget.
     * For example <code><ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].points[0].x%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul></code>
     * @param template
     */
    public final native void setLegendTemplate(String template)/*-{
        this.legendTemplate = template;
    }-*/;
}
