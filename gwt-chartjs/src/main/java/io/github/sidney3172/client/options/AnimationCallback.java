package io.github.sidney3172.client.options;

/**
 * Callback used to handle animation state changes for charts
 * @author sidney3172
 */
public interface AnimationCallback {

    /**
     * Method will be invoked during animation in progress
     * @param progress - from 0 to 1
     */
    public void onProgress(double progress);

    /**
     * Method will be invoked when animation complete
     */
    public void onAnimationComplete();

}
