package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Ant extends Movable implements ISteerable, ICollider{ 

	private int maxSpeed =5;
	private int foodLevel = 50;
	private int foodConsumptionRate =1;
	private int healthLevel= 10;
	private int lastFlagReached = 0;
	private int lives = 3;
	private int antColor;
	private Point loc;
	private int size = 50;
	private int tick;
	private static GameWorld gw;
	
	/*public Ant(int size, int x, int y, int r, int g, int b) {
		super(size, x, y, r, g, b);
		antColor = ColorUtil.rgb(r, g, b);
		loc = new Point(x, y);
	}*/
	
	private static Ant jill = null;
	private Ant(int size, int x, int y, int r, int g, int b, GameWorld gw) {//15, 0, 0, 255, 80, 80
		super(size, x, y, r, g, b);
		antColor = ColorUtil.rgb(r, g, b);
		loc = new Point(x,y);
		this.gw = gw;
	}
	
	public static Ant getAnt(){//int size, int x, int y, int r, int g, int b) {
		if(jill == null) {
			jill = new Ant(50, 750, 750, 255, 80, 80, gw);
			
		}
		return jill;
	}
	
	public void decreaseHealth() {
		healthLevel = healthLevel - 1;
		System.out.println("Health level is currently "+ healthLevel);
		System.out.println("You have "+ lives+ " lives left");
		
		if(healthLevel<=0) {
			
			lives = lives -1;
			
			maxSpeed = (50*(healthLevel/10));
			if(lives <= 0)
			{	
				setSpeed(0);
				System.out.println("GAME OVER");
				healthLevel = 0;
				lives = 0;
			}
			else {
				healthLevel = 10;
				maxSpeed = 50;
			}
			
		}
		
		
	}
	
	
	public void goLeft() {
		System.out.println("Move to the left");
		int s = getSpeed();
		int h = getHeading();
		//System.out.println("Value of speed: " + s);
		//System.out.println("Value of heading:" + h);//mod 360?
		h = h +90;
		if(h>360) {
			//h = 0;
			h = h % 360;
			setHeading(h);
		}
		
		else if(h<0) {
			h = h + 360;
			h = h % 360;
			setHeading(h);
		}
		
		else {
			
			setHeading(h);
		}
	
		
		//System.out.println("Value of speed: " + s);
		System.out.println("Value of heading:" + h);
		if(foodLevel > 0) {
		move(s, h, GameWorld.elapsedTime());
		}
	}
	
	public void goRight() {
		System.out.println("Move to the right");
		int s = getSpeed();
		int h = getHeading();//added super
		//System.out.println("Value of speed: " + s);
		System.out.println("Value of heading:" + h);
		
		h = h - 90;
		if(h<0) {
			h = h + 360;
			h = h % 360;
			setHeading(h);
		}
		
		else if(h>360) {
			//h = 0;
			h= h % 360;
			setHeading(h);
		}
	
		else {
			
			setHeading(h);
		}
		//h = h + 90;
		
		
		//System.out.println("Value of speed: " + s);
		System.out.println("Value of heading:" + h);
		
		if(foodLevel > 0) {
			move(s, h, tick);
		}
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
	
	public void setHealthLevel(int h) {
		healthLevel = h;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setFlag(int i) {
		lastFlagReached = i;
	}
	
	public int getLastFlagReached() {
		return lastFlagReached;
	}

	
	/*public void handleCollision(GameObject o) {
		if(o instanceof Spider) {
			gw.attack();
			System.out.println("You got injured by a spider");
		}
		
		/*else if(o instanceof Flag) {
			//int i = ((Flag) o).getSequenceNumber();
			gw.gotFlag(((Flag) o).getSequenceNumber());///Null pointer exception
		}
		
		
		else if(o instanceof FoodStation) {
			gw.gotFood();
			System.out.println("You got to a foodstation");
		}
	}
	
	
	public boolean collidesWith(GameObject go) {
		boolean result = false;
		Point goLoc = go.getLocation(); 
		Point thisLoc = this.getLocation();
		int thisCenterX = (int) thisLoc.getX() + this.size/2;
		int thisCenterY = (int) thisLoc.getY() + this.size/2;
		int otherCenterX = (int) goLoc.getX() + go.getSize()/2;
		int otherCenterY = (int) goLoc.getY() + go.getSize()/2;
		
		int dx = thisCenterX - otherCenterX;
		int dy = thisCenterY - otherCenterY;
		
		int distBetweenCenters = (dx*dx + dy*dy);
		
		int thisRadius = this.size/2;
		int otherRadius = go.getSize()/2;
		int radiiSqr = (thisRadius*thisRadius + 2*thisRadius*otherRadius + otherRadius*otherRadius);
		
		if(distBetweenCenters <= radiiSqr) {
			result = true;
		}
		
		return result;
	}*/
	

	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		Point p = getLocation();
		int locX = (int)p.getX();
		int locY = (int)p.getY();
		int x = (int)pCmpRelPrnt.getX();
		int y = (int)pCmpRelPrnt.getY();
		g.setColor(ColorUtil.rgb(255,0,0));
		int s = getSize();
		g.fillArc(locX, locY, 2*s, 2*s, 0, 360);
		
	}
	
	

}