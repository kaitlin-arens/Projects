package com.mycompany.a3;

import com.codename1.charts.models.Point;

public abstract class Fixed extends GameObject{
	
	public Fixed(int size, int x, int  y, int r, int g, int b) { 
		super(size, x, y, r, g, b);
		
		
	}
	
	public void setLocation(int x, int y) {
		//Point location = new Point(x, y);
		//return location;
	}
	
	//public abstract void setColor(int r, int g, int b);

}
