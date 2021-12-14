package com.mycompany.a1;

import com.codename1.charts.models.Point;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class Spider extends Movable{

	private int speed;
	private int bound = 5;
	
	Random rnd = new Random();
	
	
	public Spider(int size, int x, int y, int r, int g, int b) {
		super(size, x, y, r, g, b);
		speed = rnd.nextInt(bound);
	}
	
	
	
	public void setLocation(int x, int y){
		
		if(0<=x && x<=1000 && 0<=y && y<=1000) {
			Point loc = new Point(x, y);
		}
		
		else if(x <= 0) {
			super.setHeading(45);
		}
		else if (x >= 1000) {
			super.setHeading(135);
		}
		
		else if(y <= 0) {
			super.setHeading(320);
		}
		
		else if(y >= 1000){
			super.setHeading(225);
		}
		
		
	}
	
	/*Point currentLoc = super.getLocation();
	float X = currentLoc.getX();
	float Y = currentLoc.getY();
	
	if(X <= 0||X >= 1000||Y <= 0 ||Y >= 1000)
	{
		
	}*/
	

	public void setColor(int r, int g, int b) {	}

}
