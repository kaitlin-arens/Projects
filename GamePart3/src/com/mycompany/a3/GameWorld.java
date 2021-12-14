package com.mycompany.a3;

import java.util.Random;
//import java.util.Iterator;
import java.util.Observable;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Graphics;

public class GameWorld extends Observable{//   add mapview and scoreview classes as observers
	Flag f1;
	Flag f2;
	Flag f3;
	Flag f4;
	Spider s1;
	Spider s2;
	FoodStation fs;
	Ant jill;
	static int tick;
	ScoreView sv;
	MapView mv;
	int width;
	int height;
	boolean bool;
	int bound = 50;
	//int bound2 = 1000;
	Random rnd = new Random();
	int rand = rnd.nextInt(bound);
	//int rand2 = rnd.nextInt(bound2);
	int newRand = getRandom(rand);
	//int newRand2 = getRandom(rand2);
	private Sound ouch;
	private Sound crunch;
	BGSound background;
	private Sound cheer;
	public boolean b = false;
	Game g;
	
	public int getRandom(int r) {
			if(r<10) {r= r+10;}
			return r;
	}
	
	GameObjectCollection theGameObjects;
	
	public GameWorld(Game g){
		this.g = g;
		
		theGameObjects = new GameObjectCollection();
		
		f1 = new Flag(50, 100, 100, 255, 0, 0);//int size, int x, int y, int r, int g, int b
		f2 = new Flag(50, 300, 300, 255, 0, 0);
		f3 = new Flag(50, 500, 500, 255, 0, 0);
		f4 = new Flag(50, 700, 700, 255, 0, 0);
		
		s1 = new Spider(100, 200, 100, 0, 0, 0);
		s2 = new Spider(600, 700, 200, 0, 0, 0);
		int nr = newRand +10;
		fs = new FoodStation(nr, 200, 600, 0, 255, 0);//newRand
		
		jill = Ant.getAnt();//I have an aunt named Jill so I named my ant Jill
		//jill = new Ant(15, 0, 0, 255, 80, 80);
		//Ant.getAnt(15, 0, 0, 255, 80, 80);
		
		theGameObjects.add(f1);
		theGameObjects.add(f2);
		theGameObjects.add(f3);
		theGameObjects.add(f4);
		
		theGameObjects.add(s1);
		theGameObjects.add(s2);
		
		theGameObjects.add(fs);
		
		theGameObjects.add(jill);
	}
		
	
	

	
	public void init() {

		IIterator theElements = theGameObjects.getIterator();
		
		while(theElements.hasNext()) {
			GameObject gmeObj = (GameObject) theElements.getNext();
			//mv.paint(gmeObj);
			
		}
		theElements = theGameObjects.getIterator();
		
		while(theElements.hasNext()) {
			GameObject curObj = (GameObject) theElements.getNext();//curObj and GameObject
			
			IIterator iter2 = theGameObjects.getIterator();
			while(iter2.hasNext()) {
				GameObject otherObj = (GameObject) iter2.getNext();
				if(curObj instanceof Ant) {
					//System.out.println("Congrats to the ant!");
				//if(otherObj != curObj) {//curObj
					//System.out.println("Made it past the first if");
					if(curObj.collidesWith(otherObj)) {//curObj instanceof Ant
						//if(curObj instanceof Ant) {
						
						System.out.println("Made it into the handle collision");
						(curObj).handleCollision(otherObj);//curObj
						}
					}
				}
			}
		//}//
		//}

	}
	
	public GameObject[] getGmeObjs() {
		GameObject[] go = theGameObjects.getGOC();
		return go;
	}
	
	public void map() {
		System.out.println("The map will be displayed here" );
		
		Point Locf1 = f1.getLocation();
		float f1x = Locf1.getX();
		float f1y = Locf1.getY();
		int colorf1 = f1.getColor();
		System.out.println("Flag 1: loc=" + f1x + " ," + f1y + " color=[" + ColorUtil.red(colorf1) + ", " + ColorUtil.green(colorf1)+ ", " + ColorUtil.blue(colorf1) +"] size=" + f1.getSize() + " Sequence Number: "+ f1.sequenceNumber);
		//System.out.println();

		Point Locf2 = f2.getLocation();
		float f2x = Locf2.getX();
		float f2y = Locf2.getY();
		int colorf2 = f2.getColor();
		System.out.println("Flag 2: loc=" + f2x + " ," + f2y + " color=[" + ColorUtil.red(colorf2) + ", " + ColorUtil.green(colorf2)+ ", " + ColorUtil.blue(colorf2) +"] size=" + f2.getSize() + " Sequence Number: "+ f2.sequenceNumber);
		
		Point Locf3 = f3.getLocation();
		float f3x = Locf3.getX();
		float f3y = Locf3.getY();
		int colorf3 = f3.getColor();
		System.out.println("Flag 3: loc=" + f3x + " ," + f3y + " color=[" + ColorUtil.red(colorf3) + ", " + ColorUtil.green(colorf3)+ ", " + ColorUtil.blue(colorf3) +"] size=" + f3.getSize() + " Sequence Number: "+ f3.sequenceNumber);
		
		Point Locf4 = f4.getLocation();
		float f4x = Locf4.getX();
		float f4y = Locf4.getY();
		int colorf4 = f4.getColor();
		System.out.println("Flag 4: loc=" + f4x + " ," + f4y + " color=[" + ColorUtil.red(colorf4) + ", " + ColorUtil.green(colorf4)+ ", " + ColorUtil.blue(colorf4) +"] size=" + f4.getSize() + " Sequence Number: "+ f4.sequenceNumber);
		
		Point jillLoc = jill.getLocation();
		float antX = jillLoc.getX();
		float antY = jillLoc.getY();
		int antColor = jill.getColor();
		System.out.println("Ant: loc=" + antX + " ," + antY + " color=[" + ColorUtil.red(antColor) + ", " + ColorUtil.green(antColor)+ ", " + ColorUtil.blue(antColor) +"] heading=" + jill.getHeading()+ " speed=" + jill.getSpeed()+" size=" + jill.getSize()+" maxSpeed=" + jill.getMaxSpeed() + " foodConsumptionRate="+ jill.getFoodConsumptionRate());
	}
	
	
	
	
	public void accelerate() {
		System.out.println("You have accelerated the ant");
		int s = jill.getSpeed();
		int h = jill.getHeading();
		if(s<50) {
			s = s + 5; 
			jill.setSpeed(s);
			jill.move(s, h, tick);
			System.out.println("Your speed is now " + s);
			
		}
		else {
			System.out.println("You are at your fastest speed.");
		}
		tick = tick + 1;
		setChanged();
		notifyObservers();
	}
	
	public void brake() {
		System.out.println("Hold your horses!");
		int s = jill.getSpeed();
		int h = jill.getHeading();
		 
		if(s>0) {
			s = s-5;
			jill.setSpeed(s);
			jill.move(s, h, tick);
			System.out.println("Your speed is now " + s);
		}	
		else if(s==0) {
			System.out.println("You have stopped.");
		}
		tick = tick+1;
		setChanged();
		notifyObservers();
	}
	
	public void left() {
		System.out.println("Turning left");
		jill.goLeft();
		tick = tick + 1;
		setChanged();
		notifyObservers();
	}
	
	public void right() {
		System.out.println("Turning right");
		jill.goRight();
		tick = tick + 1; 
		setChanged();
		notifyObservers();
	}
	
	public void gotFlag(int i) {
		System.out.println("Last flag reached: " + jill.getLastFlagReached());
		
		
		if(jill.getLastFlagReached() + 1 == i)
		{
			System.out.println("Way to go! You reached the next flag!");
			jill.setFlag(i);
			if(b==true) {
				cheer.playSound();
			}
		}
		else {
			System.out.println("Wrong flag");
		}
		
		tick = tick +1;
		setChanged();
		notifyObservers();
	}
	public int gotTheFlag(int i) {
		return jill.getLastFlagReached();
	}
	
	public void gotFood() {
		System.out.println("Hungry, hungry ant");
		if(b==true) {
			crunch.playSound();
		}
		int c = fs.getCapacity();
		System.out.println("The Foodstation's current capacity: " + fs.getCapacity());
		int f = jill.getFoodLevel();

		int antNewFoodLevel = c+f;
		//System.out.println("antNewFoodLevel "+ antNewFoodLevel);
		int newFSLevel = c-(50-f);
		//System.out.println("newFSLevel "+ newFSLevel);
		if(newFSLevel >= 0)
			fs.setCapacity(newFSLevel);
		else
			fs.setCapacity(0);
		
		
		if(antNewFoodLevel > 50) {
			antNewFoodLevel = 50;
			jill.setFoodLevel(50);
		}
		System.out.println("New ant food level is: " + antNewFoodLevel);
		if(fs.getCapacity() <= 0) {
			int bound1 = 1000;
			int bound2 = 50;
			Random rnd = new Random();
			int rand1 = rnd.nextInt(bound1);
			int rand2 = rnd.nextInt(bound1);
			int newFSRand = rnd.nextInt(bound2);
			fs.setCapacity(newFSRand);
			fs.setLocation(rand1, rand2);
			fs.setColor(0, 255, 0);
			Point a = fs.getLocation();
			System.out.println("New Foodstation created at " + a.getX() +", " + a.getY());
		}
		
		//fs.setCapacity(0);
		else if(fs.getCapacity() <= 10) {
			fs.setColor(0, 100, 0);
			
		}
			
		
		int colorfs = fs.getColor();
		System.out.println("New color of foodstation: " + ColorUtil.red(colorfs) + " ,"+ ColorUtil.green(colorfs)+ " ,"+ ColorUtil.blue(colorfs));
		setChanged();//////////////Observable
		tick = tick +1;
		notifyObservers();
		
		
	}
	
	public void setPause(boolean bool) {
		if(bool == true) {
			g.pause(true);
			//System.out.println("Made it to set pause");
		}
		else {
			g.pause(false);
		}
		
	}
	
	public int foodLevel() {
		return jill.getFoodLevel();
	}
	
	public void attack() {
		System.out.println("The spider attacked!");
		if(b == true) {
			ouch.playSound();
		}
		jill.decreaseHealth();
		tick = tick +1;
		setChanged();
		notifyObservers();
		//notifyObservers(tick);
		//notifyObservers(jill.getLives());
	}
	
	public int getTime() {
		return tick;
	}
	
	public int getLives() {
		return jill.getLives();
	}
	
	public int health() {
		return jill.getHealthLevel();
	}
	
	public void time() {

		int bound1 = 360;
		Random rnd = new Random();
		int rand1 = rnd.nextInt(bound1);
		int r1 = getRandom(rand1);

		int rand3 = rnd.nextInt(bound1);
		int r3 = getRandom(rand3);

		
		//System.out.println("Jill speed " + jill.getSpeed() +" Jill heading: " + jill.getHeading());
		Point ant = jill.getLocation();
		//System.out.println("Ant loc: " + ant.getX()+ ", " + ant.getY() );
		s1.setSpeed(10);
		s2.setSpeed(10);
		s1.setHeading(r1);
		s2.setHeading(r3);
		s1.move(r1, 10, elapsedTime());//r1
		
		s2.move(r3, 10, elapsedTime());//r4
		Point a = s1.getLocation();
		Point b = s2.getLocation();
		
		//s1.setLocation((int)a.getX(), (int)a.getY());
		//s2.setLocation((int)b.getX(), (int)b.getY());
		
		//System.out.println("New s1 location " + a.getX() + " ," + a.getY());
		//System.out.println("New s2 location " + b.getX() + " ," + b.getY());
		
		if(jill.getFoodLevel() > 0) {
			int newFoodLevel = jill.getFoodLevel() - jill.getFoodConsumptionRate();
			jill.move(jill.getSpeed(), jill.getHeading(), elapsedTime());
			if(newFoodLevel > 50) {
				newFoodLevel = 50;
			}
			jill.setFoodLevel(newFoodLevel); 
			System.out.println("New food level: " + newFoodLevel);
		}
		
		else if(jill.getFoodLevel()<=0) {
			System.out.println("You can no longer move.");
		}
		tick = tick +1;
		
		setChanged();
		notifyObservers();
	}
	
	public static int elapsedTime() {
		int time = tick * 450;
		return time;
	}
	
	public void displayStats() {
		System.out.println("Number of lives left: " + jill.getLives() + " Time: " + tick + " Highest flag value: " + jill.getLastFlagReached() + " Current food level: " + jill.getFoodLevel() + "Current health: " + jill.getHealthLevel());
		
	}
	
	public void exit() {
		System.out.println("Are you sure you want to leave?");
	}
	
	public void yes() {
		System.out.println("Yup");
		System.exit(0);
	}
	
	public void nope() {
		System.out.println("Nope");
	}
	
	public void createSounds() {
		background = new BGSound("background.wav");
		//background.play();
		crunch = new Sound("TOON50.wav");
		ouch = new Sound("bump.wav");
		cheer = new Sound("cheer.wav");
		
	}

}
