package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class FoodStation extends Fixed{ 
	private int foodColor;
	private int capacity=1;
	private Point loc;
	private int size = 50;

	
	public FoodStation(int size, int x, int y, int r, int g, int b) {
		super(size, x, y, r, g, b);
		foodColor = ColorUtil.rgb(r, g, b);
		loc = new Point(x, y);
		capacity = capacity*size;
	}

	public void setColor(int r, int g, int b) {
		foodColor = ColorUtil.rgb(r, g, b);
		
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int i) {
		capacity = i;
	}
	public int getSize() {
		return size;
	}
	

	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		int locX = (int)loc.getX();
		int locY = (int)loc.getY();
		int pointX = (int)pCmpRelPrnt.getX();
		int pointY = (int)pCmpRelPrnt.getY();
		int finalX = locX + pointX;
		int finalY = locY+ pointY;
		
		g.setColor(ColorUtil.rgb(0, 250, 150));
		g.fillRect(finalX, finalY, size, size);
		String s = Integer.toString(capacity);
		g.setColor(ColorUtil.BLACK);
		g.drawString(s, finalX, finalY);
		
		
		
	}

}