package io.github.sidney3172.client.options;

import java.util.List;

/**
 * Interface describes method related to Options management of chart
 */
public interface HasOptions {

    public void setOptions(List<ChartOption> options);

    public void addOption(ChartOption option);

    public List<ChartOption> getOptions();

    public void clearOptions();

}
