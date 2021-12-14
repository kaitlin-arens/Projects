package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {
	private int size;
	private Point location;
	private int color;
	//protected int sequenceNumber;
	
	
	public GameObject(int size, int x, int  y, int r, int g, int b) {
		this.size = size;
		location = new Point(x, y);
		color = ColorUtil.rgb(r, g, b);
		//System.out.println("Color value" + color);
	}
	
	public int getSize(){
		return size;
	}
	
	public Point getLocation(){
		//System.out.println("getLocation here");
		return location;
	}
	
	
	public abstract void setLocation(int x, int y);
	
	public int getColor() {
		return color;
	}
	
	public abstract void setColor(int r, int g, int b);
}
