package com.mycompany.a1;
import com.codename1.charts.models.Point;
import java.lang.Math;


public abstract class Movable extends GameObject{
	private int heading;
	private int speed;
	
	

	public Movable(int size, int x, int  y, int r, int g, int b) {
		super(size, x, y, r, g, b);
		
	}
	
	public void setSpeed(int s) {
		speed = s;
	}
	
	public void setHeading(int h) {
		heading = h;
	}
	
	public abstract void setLocation(int x, int y);
	public abstract void setColor(int r, int g, int b);
	
	public int getHeading() {
		return heading;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	
	public Point move(int heading, int speed) {
		Point oldLoc= super.getLocation();
		float x = oldLoc.getX();
		float y = oldLoc.getY();
	
		int theta = 90 - heading;
		double deltaX = Math.cos(theta)*speed;
		double deltaY = Math.sin(theta)*speed;
		
		float float1 = (float)deltaX;
		float float2 = (float)deltaY;
		
		Point newLoc = new Point();
		newLoc.setX(float1 + x);
		newLoc.setY(float2 + y);
		
		return newLoc;
	}

}
