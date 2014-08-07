package org.gwt.chartjs.demo.client.sections;

import org.gwt.chartjs.demo.client.resources.ChartDemoResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Section extends HTMLPanel{

	public Section(String arg0){
		super(arg0);
		initTheme();
	}
	
	public Section(SafeHtml arg0){
		super(arg0);
		initTheme();
	}
	
	public void initTheme(){
		ChartDemoResources res = GWT.create(ChartDemoResources.class);
		res.sectionStyle().ensureInjected();
		setStylePrimaryName(res.sectionStyle().section());
	}
}
