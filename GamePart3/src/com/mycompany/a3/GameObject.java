package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject  implements IDrawable{// ICollider{
	private int size;
	private Point location;
	private int color;
	private GameWorld gw;
	
	//protected int sequenceNumber; 
	
	
	
	public GameObject(int size, int x, int  y, int r, int g, int b) {
		this.size = size;
		location = new Point(x, y);
		//location.setX(x);
		//location.setY(y);
		color = ColorUtil.rgb(r, g, b);
		//System.out.println("Color value" + color);
		//this.gw = gw;
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
		//System.out.println("New value of x: " + location.getX());
		//System.out.println("New value of y: " + location.getY());
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int r, int g, int b) {
		color = ColorUtil.rgb(r, g, b);
	}
	
	public boolean collidesWith(GameObject go) {
		boolean result = false;
		Point goLoc = go.getLocation(); 
		Point thisLoc = this.getLocation();
		//System.out.println("Mades it to collides with");
		int thisCenterX = (int) thisLoc.getX() + this.size/2;
		int thisCenterY = (int) thisLoc.getY() + this.size/2;
		int otherCenterX = (int) goLoc.getX() + go.size/2;
		int otherCenterY = (int) goLoc.getY() + go.size/2;
		
		int dx = thisCenterX - otherCenterX;
		int dy = thisCenterY - otherCenterY;
		
		int distBetweenCenters = (dx*dx + dy*dy);
		
		int thisRadius = this.size/2;
		int otherRadius = go.size/2;
		int radiiSqr = (thisRadius*thisRadius + 2*thisRadius*otherRadius + otherRadius*otherRadius);
		
		if(distBetweenCenters <= radiiSqr) {
			result = true;
		}
		
		return result;
	}
	
	public void handleCollision(GameObject o) {
		System.out.println("Collision occurred.");
		if(o instanceof Flag) {
			int i = ((Flag) o).getSequenceNumber();
			gw.gotFlag(i);
			System.out.println("Mades it to collides with flag");
		}
		
		else if(o instanceof Spider) {	
			gw.attack();					////this line causes a null pointer error
			System.out.println("Mades it to collides with spider");
		}
		
		else if(o instanceof FoodStation) {
			gw.gotFood();
			System.out.println("Mades it to collides with fs");
		}
		
	}
	
}