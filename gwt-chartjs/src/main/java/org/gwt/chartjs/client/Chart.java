package org.gwt.chartjs.client;

import org.gwt.chartjs.client.resources.Resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.SimplePanel;

public abstract class Chart extends SimplePanel {

	protected CanvasElement canvas;

	public Chart() {
		Resources res = GWT.create(Resources.class);
		res.chartStyle().ensureInjected();
		setStylePrimaryName(res.chartStyle().chart());
		canvas = Document.get().createCanvasElement();
		getElement().appendChild(canvas);
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		ChartJs.ensureInjected();
		draw();
	}

	protected abstract void draw();
	
	public void setPixelWidth(int width) {
		canvas.setWidth(width);
	}

	public void setPixelHeight(int height) {
		canvas.setHeight(height);
	}
	
	}
