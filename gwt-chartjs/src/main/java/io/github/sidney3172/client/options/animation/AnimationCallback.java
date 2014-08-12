package io.github.sidney3172.client.options.animation;

/**
 * Callback used to handle animation state changes for charts
 * @author sidney3172
 */
public interface AnimationCallback {

    /**
     * Method will be invoked during animation in progress
     */
    public void onProgress();

    /**
     * Method will be invoked when animation complete
     */
    public void onAnimationComplete();

}
