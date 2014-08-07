package org.gwt.chartjs.doc.client;

import org.gwt.chartjs.doc.client.resources.ChartDocResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Section extends HTMLPanel {

	protected String token = "";
	private static ChartDocResources res;
	static{
		res = GWT.create(ChartDocResources.class);
	}
	
	public Section(SafeHtml safeHtml) {
		super(safeHtml);
		setStylePrimaryName(res.docStyle().section());
	}
	
	public Section(String html){
		super(html);
		setStylePrimaryName(res.docStyle().section());
	}
	
	public String getToken(){
		return token;
	}
	
}
