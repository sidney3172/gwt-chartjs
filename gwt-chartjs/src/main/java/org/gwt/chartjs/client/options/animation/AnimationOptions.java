package org.gwt.chartjs.client.options.animation;

/**
 * Container for configuration of animation of charts
 * @author sidney3172
 *
 */
public class AnimationOptions {
	/**
	 * Enum contains types of easing of chart animation
	 * @author sidney3172
	 */
	public static enum Type {
		linear("linear"), 
		easeInQuad("easeInQuad"),
		easeOutQuad("easeOutQuad"),
		easeInOutQuad("easeInOutQuad"),
		easeInCubic("easeInCubic"),
		easeOutCubic("easeOutCubic"),
		easeInOutCubic("easeInOutCubic"),
		easeInQuart("easeInQuart"),
		easeOutQuart("easeOutQuart"),
		easeInOutQuart("easeInOutQuart"),
		easeInQuint("easeInQuint"),
		easeOutQuint("easeOutQuint"),
		easeInOutQuint("easeInOutQuint"),
		easeInSine("easeInSine"), 
		easeOutSine("easeOutSine"), 
		easeInOutSine("easeInOutSine"), 
		easeInExpo("easeInExpo"), 
		easeOutExpo("easeOutExpo"), 
		easeInOutExpo("easeInOutExpo"), 
		easeInCirc("easeInCirc"), 
		easeOutCirc("easeOutCirc"), 
		easeInOutCirc("easeInOutCirc"), 
		easeInElastic("easeInElastic"), 
		easeOutElastic("easeOutElastic"),
		easeInOutElastic("easeInOutElastic"),
		easeInBack("easeInBack"), 
		easeOutBack("easeOutBack"), 
		easeInOutBack("easeInOutBack"), 
		easeInBounce("easeInBounce"), 
		easeOutBounce("easeOutBounce"),
		easeInOutBounce("easeInOutBounce");
		
		private String value;
		
		private Type(String value){
			this.value = value;
		}
		
		/**
		 * @return - javascript name of easing function (used in native chart.js code)
		 */
		public String getValue(){
			return value;
		}
	}

	private int steps;
	private Type easing;
	
	/**
	 * Creates default animation with number of steps = 60 and easeQutQuart easing function
	 */
	public AnimationOptions(){
		this(60, Type.easeOutQuart);
	}
	
	/**
	 * Creates animation options with custom parameters
	 * @param steps : number of animation steps
	 * @param easing : type of easing function
	 */
	public AnimationOptions(int steps, Type easing){
		this.steps = steps;
		this.easing = easing;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public Type getEasing() {
		return easing;
	}

	public void setEasing(Type easing) {
		this.easing = easing;
	}
	
	
	
}
