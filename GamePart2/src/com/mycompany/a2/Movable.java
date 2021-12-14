package com.mycompany.a2;
import com.codename1.charts.models.Point;
import java.lang.Math;
 

public abstract class Movable extends GameObject{
	private int heading;
	private int speed;
	private Point location;

	
	

	public Movable(int size, int x, int  y, int r, int g, int b) {
		super(size, x, y, r, g, b);
		
	}
	
	public void setSpeed(int s) {
		speed = s;
	}
	
	public void setHeading(int h) {
		heading = h;
	}
	
	//public abstract void setLocation(int x, int y);
	//public abstract void setColor(int r, int g, int b);
	
	public int getHeading() {
		return heading;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	
	public void move(int heading, int speed) {
		Point oldLoc= getLocation();
		float x = oldLoc.getX();
		float y = oldLoc.getY();
		
		System.out.println("Original location " + oldLoc.getX() + " ," + oldLoc.getY());
	
		int theta = 90 - heading;
		double deltaX = Math.cos(theta)*speed;
		double deltaY = Math.sin(theta)*speed;
		
		int newX = (int)deltaX + (int)x;
		int newY = (int)deltaY + (int)y;
		//System.out.println("New value of x: " + newX);
		//System.out.println("New value of y: " + newY);
		
		//setX(newX);
		super.setLocation(newX, newY);
		
		/*float float1 = (float)deltaX;
		float float2 = (float)deltaY;
		
		Point newLoc = new Point();
		
		newLoc.setX((int)float1 + (int)x);
		newLoc.setY((int)float2 + (int)y);*/
		
		//return newLoc;
	}

}