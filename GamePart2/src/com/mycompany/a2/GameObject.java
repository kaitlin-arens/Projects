package com.mycompany.a2;

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
		//location.setX(x);
		//location.setY(y);
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
	
	
	public void setLocation(int x, int y) {
		location.setX(x);
		location.setY(y);
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int r, int g, int b) {
		color = ColorUtil.rgb(r, g, b);
	}
}

