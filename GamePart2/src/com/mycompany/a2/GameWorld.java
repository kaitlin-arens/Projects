package com.mycompany.a2;

import java.util.Random; 
import java.util.Observable;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class GameWorld extends Observable{//   add mapview and scoreview classes as observers
	Flag f1;
	Flag f2;
	Flag f3;
	Flag f4;
	Spider s1;
	Spider s2;
	FoodStation fs;
	Ant jill;
	int tick;
	ScoreView sv;
	MapView mv;
	
	int bound = 50;
	//int bound2 = 1000;
	Random rnd = new Random();
	int rand = rnd.nextInt(bound);
	//int rand2 = rnd.nextInt(bound2);
	int newRand = getRandom(rand);
	//int newRand2 = getRandom(rand2);
	
	public int getRandom(int r) {
			if(r<10) {r= r+10;}
			return r;
	}
	
	private GameObjectCollection theGameObjects;
	
	public GameWorld(){
		
		theGameObjects = new GameObjectCollection();
		
		f1 = new Flag(10, 100, 100, 255, 0, 0);//int size, int x, int y, int r, int g, int b
		f2 = new Flag(10, 300, 300, 255, 0, 0);
		f3 = new Flag(10, 500, 500, 255, 0, 0);
		f4 = new Flag(10, 700, 700, 255, 0, 0);
		
		s1 = new Spider(5, 600, 100, 0, 0, 0);
		s2 = new Spider(5, 600, 700, 0, 0, 0);
		int nr = newRand +10;
		fs = new FoodStation(nr, 200, 600, 0, 255, 0);//newRand
		//System.out.println("Th);
		jill = Ant.getAnt();
		//jill = new Ant(15, 0, 0, 255, 80, 80);//I have an aunt named Jill so I named my ant Jill
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
		/*f1 = new Flag(10, 100, 100, 255, 0, 0);//int size, int x, int y, int r, int g, int b
		f2 = new Flag(10, 300, 300, 255, 0, 0);
		f3 = new Flag(10, 500, 500, 255, 0, 0);
		f4 = new Flag(10, 700, 700, 255, 0, 0);
		
		s1 = new Spider(5, 600, 100, 0, 0, 0);
		s2 = new Spider(5, 600, 700, 0, 0, 0);
		
		fs = new FoodStation(newRand, 200, 600, 0, 255, 0);
		//System.out.println("This is the size generator: " + newRand);
		
		jill = new Ant(15, 0, 0, 255, 80, 80);//I have an aunt named Jill so I named my ant Jill
	*/
		IIterator theElements = theGameObjects.getIterator();
		
		while(theElements.hasNext()) {
			GameObject gmeObj = (GameObject) theElements.getNext();
			//System.out.println(gmeObj);
		}

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
			jill.move(s, h);
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
			jill.move(s, h);
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
		int c = fs.getCapacity();
		System.out.println("The Foodstation's current capacity: " + fs.getCapacity());
		int f = jill.getFoodLevel();

		int newFoodLevel = c+f;
		
		
		if(newFoodLevel > 50) {
			newFoodLevel = 50;
		}
		System.out.println("New food level is: " + newFoodLevel);
		if(fs.getCapacity() == 0) {
			int bound1 = 1000;
			Random rnd = new Random();
			int rand1 = rnd.nextInt(bound1);
			int rand2 = rnd.nextInt(bound1);
			fs.setCapacity(newRand);
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
	
	public int foodLevel() {
		return jill.getFoodLevel();
	}
	
	public void attack() {
		System.out.println("The spider attacked!");
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
		//System.out.println("Time is ticking....");
		int bound1 = 360;
		//int bound2 = 10;
		Random rnd = new Random();
		int rand1 = rnd.nextInt(bound1);
		int r1 = getRandom(rand1);
		//int rand2 = rnd.nextInt(bound2);
		//int r2 = getRandom(rand2);
		int rand3 = rnd.nextInt(bound1);
		int r3 = getRandom(rand3);
		//int rand4 = rnd.nextInt(bound2);
		//int r4 = getRandom(rand4);

		s1.move(r1,10);//r2
		
		s2.move(r3, 10);//r4
		Point a = s1.getLocation();
		Point b = s2.getLocation();
		System.out.println("New s1 location " + a.getX() + " ," + a.getY());
		System.out.println("New s2 location " + b.getX() + " ," + b.getY());
		
		if(jill.getFoodLevel() > 0) {
			int newFoodLevel = jill.getFoodLevel() - jill.getFoodConsumptionRate();
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
		
		System.out.println("Time is ticking.... " + tick);
		setChanged();
		notifyObservers();
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

}
