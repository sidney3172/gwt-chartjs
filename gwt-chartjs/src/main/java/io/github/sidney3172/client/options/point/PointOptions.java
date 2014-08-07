package io.github.sidney3172.client.options.point;

import io.github.sidney3172.client.Chart;

/**
 * Class is a container for point parameters for {@link Chart}
 * @author sidney3172
 */
public class PointOptions {

	private int radius;
	private int strokeWidth;

	public PointOptions() {
		this(3);
	}

	public PointOptions(int radius) {
		this(radius, 1);
	}

	public PointOptions(int radius, int strokeWidth) {
		this.radius = radius;
		this.strokeWidth = strokeWidth;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getStrokeWidth() {
		return strokeWidth;
	}

	public void setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

}
