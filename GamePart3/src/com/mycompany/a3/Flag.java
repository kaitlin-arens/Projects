package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Flag extends Fixed { 
	
	int sequenceNumber=0;
	static int instanceCounter;
	int flagColor;
	private Point loc;
	public int size = 50;
	
	public Flag(int size, int x, int y, int r, int g, int b) {
		super(size, x, y, r, g, b);
		flagColor = ColorUtil.rgb(r, g, b);
		loc = new Point(x,y);
		instanceCounter++;
        sequenceNumber = instanceCounter;
	}
	
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		int locX = (int)loc.getX();
		int locY = (int)loc.getY();
		int pointX = (int)pCmpRelPrnt.getX();
		int pointY = (int)pCmpRelPrnt.getY();
		int finalX = locX + pointX;
		int finalY = locY+ pointY;
		int[] x = {0+finalX, 50+finalX, 100+finalX}; 
		int[] y = {0+finalY, 125+finalY, 0+finalY};
		g.setColor(ColorUtil.rgb(0, 150, 150));
		g.fillPolygon(x, y, 3);
		String s = Integer.toString(sequenceNumber);
		g.setColor(ColorUtil.BLACK);
		g.drawString(s, finalX+size, finalY+size);
		
	}

} 