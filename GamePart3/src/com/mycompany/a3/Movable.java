package com.mycompany.a3;
import com.codename1.charts.models.Point;
import java.lang.Math;
 

public abstract class Movable extends GameObject{
	private int heading;
	private int speed;
	private Point location;
	//private int width;
	//private int height;

	
	

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
		//System.out.println("Speed: " + speed);
		return speed;
	}
	
	
	public void move(int heading, int speed, int time) {
		//System.out.println("Heading " + heading);
		Point oldLoc= getLocation();
		float x = oldLoc.getX();
		float y = oldLoc.getY();
		
		//System.out.println("Original location " + x + " ," + y);
		//System.out.println("Speed: "+ getSpeed());
		
		int dist = getSpeed() * ((time)/1000);
		
		//System.out.println("Speed " + speed);
	
		int theta = (int) Math.toRadians(90-getHeading());
		double deltaX = Math.cos(theta)*dist;
		double deltaY = Math.sin(theta)*dist;
		
		int newX = (int)deltaX + (int)x;
		int newY = (int)deltaY + (int)y;
		//System.out.println("New value of deltax: " + deltaX);
		//System.out.println("New value of deltay: " + deltaY);
		//System.out.println("MV height" + Game.getMVHeight());
		//setX(newX);
		if(newX > (Game.getMVWidth()+Game.getLeftContX())) {
			newX = Game.getMVWidth();
			setHeading(270);
			//this.move(225, speed);
		}
		else if(newX < Game.getLeftContX()) {
			newX = Game.getLeftContX();
			setHeading(90);
		}
		
		else if(newY > Game.getMVHeight()) {
			//System.out.println("Over mv height " + Game.getMVHeight());
			newY = Game.getMVHeight(); 
			setHeading(180);
		}
		
		else if(newY<0){
			newY = 0;
			setHeading(0);
		}
		
		//System.out.println("NEW location " + newX + " ," + newY);
		setLocation(newX, newY);
	}

}
