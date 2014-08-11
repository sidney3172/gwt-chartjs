package io.github.sidney3172.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import io.github.sidney3172.client.options.ChartOption;
import io.github.sidney3172.client.options.HasOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * This chart implementation supports adding various options.
 * @see io.github.sidney3172.client.options package for available options
 */
public abstract class ChartWithOptions extends Chart implements HasOptions{

    protected List<ChartOption> options;

    @Override
    public void setOptions(List<ChartOption> options) {
        this.options = options;
        if(options == null)
            this.options = new ArrayList<ChartOption>();
    }

    @Override
    public void addOption(ChartOption option) {
        if(options == null)
            options = new ArrayList<ChartOption>();
        if(option != null)
            options.add(option);
    }

    @Override
    public List<ChartOption> getOptions() {
        return options;
    }

    @Override
    public void clearOptions() {
        options.clear();
    }

    protected JavaScriptObject constructOptions(){
        if(options == null || options.isEmpty())
            return null;
        JavaScriptObject jsOption = JavaScriptObject.createObject();
        for(ChartOption option : options){
            option.appendTo(jsOption);
        }
        return jsOption;
    }
    
    public native String getLegend()/*-{
        var nativeCanvas = this.@io.github.sidney3172.client.ChartWithOptions::getNativeCanvas()();
        try{
            var code = nativeCanvas.generateLegend();
            return code;
        }
        catch(e){
            console.log(e);
            return null;
        }
    }-*/;
}
