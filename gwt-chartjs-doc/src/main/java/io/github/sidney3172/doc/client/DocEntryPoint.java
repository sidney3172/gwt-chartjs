package io.github.sidney3172.doc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class DocEntryPoint implements EntryPoint{

	@Override
	public void onModuleLoad() {
		RootPanel.get().add(new DocView());
	}
}
