package io.github.sidney3172.client.options;

/**
 * Created by sidney3172 on 13/08/14.
 */
public interface IsResponsive {

    final String RESPONSIVE = "responsive";
    final String MAINTAIN_ASPECT_RATIO = "maintainAspectRatio";

    public void setResponsive(boolean responsive);

    public void setMaintainAspectRatio(boolean aspectRatio);

}
