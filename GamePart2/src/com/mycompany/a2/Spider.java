package com.mycompany.a2;
 
import com.codename1.charts.models.Point;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class Spider extends Movable{

	private int speed = 10;
	private int bound = 5;
	private Point location;
	
	Random rnd = new Random();
	
	
	public Spider(int size, int x, int y, int r, int g, int b) {
		super(size, x, y, r, g, b);
		speed = rnd.nextInt(bound);
		location = new Point(x,y);
	}
	
	/*public Point getLocation() {
		return location;
	}*/
	
	/*public void setLocation(int x, int y){
		//System.out.println("New value of x inside set location: " + x);
		//System.out.println("New value of y inside set location: " + y);
		
		if(0<=x && x<=1000 && 0<=y && y<=1000) {
			//System.out.println("New value of x inside set location with parameters: " + x);
			//System.out.println("New value of y inside set location with parameters: " + y);
			//location.setX(x);
			//location.setY(y);
			//getLocation();
			//System.out.println("New Spider loc " + location.getX() + " ," + location.getY());
			//System.out.println("New s2 location " + location.getX() + " ," + location.getY());
			Point loc = new Point(x, y);
			System.out.println("New Spider loc " + loc.getX() + " ," + loc.getY());
			location = loc;
			System.out.println("New Spider location " + location.getX() + " ," + location.getY());
		}
		
		else if(x <= 0) {
			super.setHeading(45);
			location = new Point(10, y);
			

		}
		else if (x >= 1000) {
			super.setHeading(135);
			location = new Point(990, y);
		}
		
		else if(y <= 0) {
			super.setHeading(320);
			location = new Point(x, 10);
		}
		
		else if(y >= 1000){
			super.setHeading(225);
			location = new Point(x, 990);
		}
		//return loc;
		
	}*/
	
	
	/*Point currentLoc = super.getLocation();
	float X = currentLoc.getX();
	float Y = currentLoc.getY();
	
	if(X <= 0||X >= 1000||Y <= 0 ||Y >= 1000)
	{
		
	}*/
	

	public void setColor(int r, int g, int b) {	}

}
