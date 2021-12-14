package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.FlowLayout;

public class MapView extends Container implements Observer{
	//private Graphics ant;
	private GameWorld gw;
	int i;
	private GameObject gmeObj;


	public MapView(Observable myGW) {
		
		gw = (GameWorld) myGW;
	
	}
	
	//@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//GameObject[] gmeObjArr = gw.getGmeObjs();//fix this
		//System.out.println("In the paint method");
		/*for(int i=0; i <= gmeObjArr.length ; i++) {//GameObject gmeObj:gw.getGmeObjs()
			//System.out.println("Should be seeing all game objects");
			float x = getX();
			float y = getY();
			Point p = new Point(x,y);
			GameObject gmeObj = gmeObjArr[i];
			gmeObj.draw(g, p);
		}*/
		
		IIterator theElements = gw.theGameObjects.getIterator();
		
		while(theElements.hasNext()) {
			GameObject gmeObj = (GameObject) theElements.getNext();
			
			//Point p = gmeObj.getLocation();
			float x = getX();
			float y = getY();
			//System.out.println(x);
			//System.out.println(y);
			
			Point newp = new Point(x,y);
			//System.out.println("gmeObj" + gmeObj);
			gmeObj.draw(g, newp);
			
		}
		
	}

	@Override
	public void update(Observable observable, Object data) {
		GameWorld g = (GameWorld) observable;
		this.repaint();
		//gmeObj.setLocation();
		
		//ant.setColor(ColorUtil.rgb(255,0,0));
	}

}
