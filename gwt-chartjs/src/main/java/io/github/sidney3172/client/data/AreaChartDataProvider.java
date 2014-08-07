package io.github.sidney3172.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AreaChartDataProvider {
	
	public JavaScriptObject getData();
	
	public void reload(AsyncCallback<AreaChartData> callback);
}
