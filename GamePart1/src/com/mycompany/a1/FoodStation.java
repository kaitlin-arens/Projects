package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class FoodStation extends Fixed{
	private int foodColor;
	private int capacity=1;
	
	public FoodStation(int size, int x, int y, int r, int g, int b) {
		super(size, x, y, r, g, b);
		foodColor = ColorUtil.rgb(r, g, b);
		capacity = capacity*size;
	}

	public void setColor(int r, int g, int b) {
		foodColor = ColorUtil.rgb(r, g, b);
		
	}
 
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int i) {
		capacity = i;
	}

}
