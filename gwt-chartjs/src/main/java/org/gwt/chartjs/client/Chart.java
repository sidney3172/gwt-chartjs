package org.gwt.chartjs.client;

import org.gwt.chartjs.client.event.AnimationCompleteEvent;
import org.gwt.chartjs.client.event.AnimationCompleteHandler;
import org.gwt.chartjs.client.event.HasAnimationCompleteHandlers;
import org.gwt.chartjs.client.options.animation.AnimationOptions;
import org.gwt.chartjs.client.options.animation.HasAnimation;
import org.gwt.chartjs.client.resources.ChartStyle;
import org.gwt.chartjs.client.resources.Resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Base class for all chart widgets<br/>
 * Class describes generic behavior of all chart widgets
 * @author sidney3172
 *
 */
public abstract class Chart extends SimplePanel implements HasAnimationCompleteHandlers, HasAnimation{

	private static Resources resources;
	
	private boolean animationEnabled = true;
	protected AnimationOptions animationOptions;
	
	protected CanvasElement canvas;
	protected ChartStyle style;
	
	
	static{
		resources = GWT.create(Resources.class);
	}
	
	/**
	 * This constructor creates new chart instance with custom {@link ChartStyle}
	 * @param style - new CssResource used for styling charts
	 */
	public Chart(ChartStyle style){
		setChartStyle(style);
		canvas = Document.get().createCanvasElement();
		getElement().appendChild(canvas);
	}
	
	/**
	 * Constructor creates chart with default style
	 */
	public Chart() {
		this(resources.chartStyle());
	}
	
	/**
	 * Set new style to the char widget. New style will be injected automatically.<br/>
	 * NOTICE: new style will be applied after re-drawing of chart<br/>
	 * @param style
	 */
	public void setChartStyle(ChartStyle style){
		style.ensureInjected();
		setStylePrimaryName(style.chart());
	}

	@Override
	protected void onAttach() {
		ChartJs.ensureInjected();
		super.onAttach();
		draw();
	}

	/**
	 * Method re-drawing chart widget without re-requesting data from data provider.<br/>
	 * To update data call {@link #reload()} method instead
	 */
	public abstract void update();
	
	/**
	 * Method requesting data from data provider and re-drawing chart.
	 */
	public abstract void reload();
	
	/**
	 * Method preparing data and invoking native draw method<br/>
	 * This method should not be overridden by sub-classes
	 */
	protected abstract void draw();
	
	/**
	 * Method sets pixel width of chart area
	 * @param width - width in pixels
	 * TODO: replace it with generic {@link #setWidth(String)} and {@link #setSize(String, String)}
	 */
	public void setPixelWidth(int width) {
		canvas.setWidth(width);
	}

	/**
	 * Method sets pixel height of chart area
	 * @param height - height in pixels
	 * TODO: replace it with generic {@link #setHeight(String)} and {@link #setSize(String, String)}
	 */
	public void setPixelHeight(int height) {
		canvas.setHeight(height);
	}
	
	@Override
	public void addAnimationCompleteHandler(AnimationCompleteHandler handler) {
		addHandler(handler, AnimationCompleteEvent.getType());
	}
	
	@Override
	public void setAnimationEnabled(boolean enable) {
		
	}
	
	@Override
	public boolean isAnimationEnabled() {
		return animationEnabled;
	}
	
	@Override
	public void setAnimationOptions(AnimationOptions options) {
		this.animationOptions = options;
		if(animationEnabled && animationOptions == null)
			animationOptions = new AnimationOptions();
	}
}
