package io.github.sidney3172.client;

import io.github.sidney3172.client.event.AnimationCompleteEvent;
import io.github.sidney3172.client.event.AnimationCompleteHandler;
import io.github.sidney3172.client.event.HasAnimationCompleteHandlers;
import io.github.sidney3172.client.options.AnimationCallback;
import io.github.sidney3172.client.options.HasAnimation;
import io.github.sidney3172.client.options.IsResponsive;
import io.github.sidney3172.client.options.Type;

import java.util.ArrayList;
import java.util.List;

public abstract class ChartWithAnimation<T> extends Chart implements IsResponsive, HasAnimation,HasAnimationCompleteHandlers {

    protected List<AnimationCallback> callbackList = new ArrayList<AnimationCallback>();

    public ChartWithAnimation(){
        super();
        registerNativeAnimationHandlers();
    }


    @Override
    public void setResponsive(boolean responsive){
        if(!responsive)
            options.clearProperty(RESPONSIVE);
        else
            options.setProperty(RESPONSIVE, true);
    }

    /**
     * Specify should chart be animated or not
     * Default value is <code>true</code>
     * @param enabled
     */
    public void setAnimationEnabled(boolean enabled){
        if(!enabled) //"animation" : false interpreted by chart.js as "true"
            options.clearProperty(ANIMATION);
        else
            options.setProperty(ANIMATION, enabled);
    }

    /**
     * Specify animation easing
     * Default value is {@link io.github.sidney3172.client.options.Type#EASE_OUT_QUART}
     * @param type
     */
    public void setAnimationType(Type type){
        if(type == null)
            options.clearProperty(ANIMATION_EASING);
        else
            options.setProperty(ANIMATION_EASING, type.getValue());
    }

    /**
     * Add animation callback to handle animation state changes
     * @param callback
     */
    public void addAnimationCallback(AnimationCallback callback){
        if(callback != null)
            callbackList.add(callback);
    }

    @Override
    public void setAnimationSteps(int steps) {
        if(steps <= 0)
            throw new IndexOutOfBoundsException("Number of animation steps should be positive. Found '"+steps+"'");

        options.setProperty(ANIMATION_STEPS, steps);
    }

    @Override
    public void addAnimationCompleteHandler(AnimationCompleteHandler handler) {
        addHandler(handler, AnimationCompleteEvent.getType());
    }


    protected void onAnimationProgress(double progress){
        for(AnimationCallback callback : callbackList){
            if(callback != null)
                callback.onProgress(progress);
        }
    }

    protected void onAnimationComplete(){
        for(AnimationCallback callback : callbackList){
            if(callback != null)
                callback.onAnimationComplete();
        }
    }

    protected native void registerNativeAnimationHandlers()/*-{
        options = this.@io.github.sidney3172.client.Chart::constructOptions()();
        self = this;
        options.onAnimationProgress = function(progress){
            self.@io.github.sidney3172.client.Chart::onAnimationProgress(D)(progress);
            return;
        }
        options.onAnimationComplete = function(){
            self.@io.github.sidney3172.client.Chart::onAnimationComplete()();
            return;
        }
    }-*/;
}
