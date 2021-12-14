package com.mycompany.a3;
 
import com.codename1.charts.models.Point;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

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
	

	public void setColor(int r, int g, int b) {	}

	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		Point p = getLocation();
		int locX = (int)p.getX();
		int locY = (int)p.getY();
		int pointX = (int)pCmpRelPrnt.getX();
		int pointY = (int)pCmpRelPrnt.getY();
		int finalX = locX + pointX;
		int finalY = locY+ pointY;
		int[] x = {0+finalX, 50+finalX, 100+finalX}; 
		int[] y = {0+finalY, 125+finalY, 0+finalY};
		g.setColor(ColorUtil.BLACK);
		g.drawPolygon(x, y, 3);
		
	}

}
