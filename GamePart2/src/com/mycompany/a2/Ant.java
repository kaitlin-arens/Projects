package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Ant extends Movable implements ISteerable{ 

	private int maxSpeed =50;
	private int foodLevel = 50;
	private int foodConsumptionRate =1;
	private int healthLevel= 10;
	private int lastFlagReached = 0;
	private int lives = 3;
	private int antColor;
	private Point loc;
	
	/*public Ant(int size, int x, int y, int r, int g, int b) {
		super(size, x, y, r, g, b);
		antColor = ColorUtil.rgb(r, g, b);
		loc = new Point(x, y);
	}*/
	
	private static Ant jill = null;
	private Ant(int size, int x, int y, int r, int g, int b) {//15, 0, 0, 255, 80, 80
		super(size, x, y, r, g, b);
		antColor = ColorUtil.rgb(r, g, b);
		loc = new Point(x,y);
	}
	
	public static Ant getAnt(){//int size, int x, int y, int r, int g, int b) {
		if(jill == null) {
			jill = new Ant(15, 0, 0, 255, 80, 80);
			
		}
		return jill;
	}
	
	public void decreaseHealth() {
		healthLevel = healthLevel - 1;
		System.out.println("Health level is currently "+ healthLevel);
		System.out.println("You have "+ lives+ " lives left");
		
		if(healthLevel==0) {
			
			lives = lives -1;
			
			maxSpeed = (50*(healthLevel/10));
			if(lives == 0)
			{	
				super.setSpeed(0);
				System.out.println("GAME OVER");
			}
			else {
				healthLevel = 10;
				maxSpeed = 50;
			}
			
		}
		
	}
	
	
	public void goRight() {
		System.out.println("Move to the right");
		int s = super.getSpeed();
		int h = super.getHeading();
		System.out.println("Value of speed: " + s);
		System.out.println("Value of heading:" + h);
		if(h>=355) {
			h = 0;
			setHeading(h);
		}
		
		else {
			h = h + 5;
			setHeading(h);
		}
		System.out.println("Value of speed: " + s);
		System.out.println("Value of heading:" + h);
		move(s, h);
		
	}
	
	public void goLeft() {
		System.out.println("Move to the left");
		int s = getSpeed();
		int h = getHeading();
		System.out.println("Value of speed: " + s);
		System.out.println("Value of heading:" + h);
		if(h<=0) {
			h = 355;
			setHeading(h);
		}
		
		else {
			h = h - 5;
			setHeading(h);
		}
		System.out.println("Value of speed: " + s);
		System.out.println("Value of heading:" + h);
		move(s, h);
	}
	

	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public int getFoodConsumptionRate() {
		return foodConsumptionRate;
	}
	
	public int getFoodLevel() {
		return foodLevel;
	}
	
	public int getHealthLevel() {
		return healthLevel;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void setFoodLevel(int l) {
		foodLevel = l;
	}
	
	/*public void setLocation(int x, int y) {
		loc = new Point(x, y);
		//return loc;
	}*/
	
	/*public void setColor(int r, int g, int b) {
		antColor = ColorUtil.rgb(r, g, b);
	}*/
	
	public void setFlag(int i) {
		lastFlagReached = i;
	}
	
	public int getLastFlagReached() {
		return lastFlagReached;
	}
	

}