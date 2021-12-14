package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Graphics;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Point;
import com.codename1.ui.plaf.Border;

public class Pause extends Command implements ISelectable{
	private BGSound bgSound;
	private boolean bSelected = true;
	private boolean isSelected= false;
	private GameWorld gw;
	private Game g;
	private int iShapeX;
	private int iShapeY;
	private int width;
	private int height;
	
	public Pause(GameWorld gw, Game g){

		super("Pause");
		this.gw = gw;
		
		this.g = g;
		//GameObject.getSize();
		
		iShapeX = g.getX();
		iShapeY = g.getY();
		
		
	}

	public void actionPerformed(ActionEvent e) {
		//gw.jill.pause();
		if(bSelected == true) {
			g.p.setText("Play");
			//gw.setPause(bSelected);
			bSelected = false;
		}
		else {
			g.p.setText("Pause");
			//gw.setPause(bSelected);
			bSelected = true;
		}
		
		
	}

	@Override
	public void setSelected(boolean b) {
		// TODO Auto-generated method stub
		bSelected = b;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return bSelected;
	}

	@Override
	public boolean contains(Point pPterRelPrnt, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		int px = pPterRelPrnt.getX();
		int py = pPterRelPrnt.getY();
		int xLoc = pCmpRelPrnt.getX() + iShapeX;
		int yLoc = pCmpRelPrnt.getY() + iShapeY;
		if((px>= xLoc)&&(px<=xLoc+width)&&(py>=yLoc)&&(py<=yLoc+height)) {
			return true;
		}
		else {return false;}
		//return false;
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		int xLoc = pCmpRelPrnt.getX() + iShapeX;
		int yLoc = pCmpRelPrnt.getY() + iShapeY;
		if(isSelected()) {
			g.fillRect(xLoc, yLoc, width, height);
		}
		else {
			g.drawRect(xLoc, yLoc, width, height);
		}
	}
}
